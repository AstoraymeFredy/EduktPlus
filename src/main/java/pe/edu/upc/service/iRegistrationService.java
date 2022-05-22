package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.model.Registration;



public interface iRegistrationService {
	public List<Registration> listByStudent(int idStudent);
	public void deleteRegistration(int idStudent);
}
