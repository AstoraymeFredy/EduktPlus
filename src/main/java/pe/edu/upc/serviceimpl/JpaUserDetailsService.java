package pe.edu.upc.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.controller.repository.iUserRepository;
import pe.edu.upc.model.CustomUser;
import pe.edu.upc.model.UserModel;

@Service
public class JpaUserDetailsService implements UserDetailsService {
	
	@Autowired
	private iUserRepository userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		String role = "ROLE_";
		if (user.getId_user() == 1) {
			role = role + "Administrador";
		} else {
			role = role + "Estudiante";
		}
		authorities.add(new SimpleGrantedAuthority(role));
		return new CustomUser(user.getUsername(), user.getPassword(), true, true, true, true, authorities, user.getId_user());
	}
	
}
