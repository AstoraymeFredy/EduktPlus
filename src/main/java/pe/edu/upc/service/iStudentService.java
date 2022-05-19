package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.model.Student;

public interface iStudentService {
	public boolean createStudent(Student student);
	public Student findById(int idStudent);
	public Student findByUserId(int idUser);
	public List<Student> listStudent();
	public List<Student> searchStudent(String nameStudent);
}
