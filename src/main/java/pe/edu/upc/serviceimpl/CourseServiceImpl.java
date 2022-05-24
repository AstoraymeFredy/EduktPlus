package pe.edu.upc.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
