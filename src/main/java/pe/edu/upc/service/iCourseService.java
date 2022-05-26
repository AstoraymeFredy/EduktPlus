package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.model.Course;


public interface iCourseService extends iCrudService<Course, Integer>{
	public List<Course> listCourse();
	List<Course> findByNameContaining(String name)throws Exception;
	

}
