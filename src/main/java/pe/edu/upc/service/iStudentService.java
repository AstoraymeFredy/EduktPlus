package pe.edu.upc.service;

import pe.edu.upc.model.Student;

public interface iStudentService {
	public Student findById(int idStudent);
	public Student findByUserId(int idUser);
}
