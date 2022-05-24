package pe.edu.upc.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Registration;

import pe.edu.upc.repository.iRegistrationRepository;

import pe.edu.upc.service.iRegistrationService;

@Service
public class RegistrationServiceImpl implements iRegistrationService {
	
	@Autowired
	private iRegistrationRepository rRegistration;


	@Override
	public List<Registration> listByStudent(int idStudent) {
		return rRegistration.findByStudentId(idStudent);
	}
	
	@Override
	public void deleteRegistration(int idStudent) {
		rRegistration.deleteById(idStudent);
	}


}
