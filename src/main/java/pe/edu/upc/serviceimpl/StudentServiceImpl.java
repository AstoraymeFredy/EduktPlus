package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Student;
import pe.edu.upc.repository.iStudentRepository;
import pe.edu.upc.service.iStudentService;

@Service
public class StudentServiceImpl implements iStudentService {
	
	@Autowired
	private iStudentRepository dStudent;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public boolean createStudent(Student student) {
		student.getUser().setPassword(passwordEncoder.encode(student.getUser().getPassword()));
		Student objStudent = dStudent.save(student);
		if(objStudent==null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Student findById(int idStudent) {
		Student student = dStudent.findById(idStudent).get();
		return student;
	}

	@Override
	public Student findByUserId(int idUser) {
		return dStudent.findByUserId(idUser);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Student> listStudent() {
		return dStudent.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Student> searchStudent(String nameStudent) {
		return dStudent.searchByName(nameStudent.toLowerCase());
	}

	@Override
	public void deleteStudent(int idStudent) {
		dStudent.deleteById(idStudent);
	}

	@Override
	public List<Student> searchStudentLastname(String nameStudent) {
		return dStudent.searchByLastName(nameStudent.toLowerCase());
	}

	@Override
	@Transactional
	public boolean updateStudent(Student student) {
		Student objStudent = dStudent.save(student);
		if(objStudent==null) {
			return false;
		} else {
			return true;
		}
	}
}
