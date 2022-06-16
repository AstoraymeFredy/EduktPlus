package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.model.Course;


public interface iCourseService extends iCrudService<Course, Integer>{
	public boolean createCourse(Course course);
	public Course findById(int idCourse);
	public void deleteCourse(int idCourse);
	public List<Course> listCourse();
	public List<Course> searchCourse(String nameCourse);
	public Course searchById(String id);

}
