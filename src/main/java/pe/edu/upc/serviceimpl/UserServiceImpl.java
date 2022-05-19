package pe.edu.upc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.UserModel;
import pe.edu.upc.repository.iUserRepository;
import pe.edu.upc.service.iUserService;

@Service
public class UserServiceImpl implements iUserService {
	
	@Autowired
	private iUserRepository dUser;

	@Override
	@Transactional
	public boolean createUser(UserModel user) {
		UserModel objUser = dUser.save(user);
		if(objUser==null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public UserModel findByUsernameRepeated(String username) {
		return dUser.findByUsernameRepeated(username);
	}

}
