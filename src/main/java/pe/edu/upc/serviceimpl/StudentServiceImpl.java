package pe.edu.upc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.model.Student;
import pe.edu.upc.repository.iStudentRepository;
import pe.edu.upc.service.iStudentService;

@Service
public class StudentServiceImpl implements iStudentService {
	
	@Autowired
	private iStudentRepository dStudent;

	@Override
	public Student findByUserId(int idUser) {
		return dStudent.findByUserId(idUser);
	}

	@Override
	public Student findById(int idStudent) {
		return dStudent.findById(idStudent).get();
	}

}
