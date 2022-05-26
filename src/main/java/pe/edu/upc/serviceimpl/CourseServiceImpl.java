package pe.edu.upc.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.model.Course;
import pe.edu.upc.repository.iCourseRepository;
import pe.edu.upc.service.iCourseService;


@Service
public class CourseServiceImpl implements iCourseService {

	@Autowired
	private iCourseRepository rCourse;
	@Override
	public List<Course> listCourse() {
		return rCourse.findAll();
	}
	@Override
	public JpaRepository<Course, Integer> getJpaRepository() {
		return rCourse;
	}
	@Override
	public List<Course> findByNameContaining(String name)throws Exception{
		return rCourse.findByNameContaining(name);
	}
	

}