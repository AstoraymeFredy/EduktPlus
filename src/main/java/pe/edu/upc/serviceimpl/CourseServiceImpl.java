package pe.edu.upc.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Course;
import pe.edu.upc.controller.repository.iCourseRepository;
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
	@Transactional(readOnly = true)
	public List<Course> searchCourse(String nameCourse){
		return rCourse.searchByName(nameCourse.toLowerCase());
	}

	@Override
	@Transactional
	public boolean createCourse(Course course) {
		Course objCourse = rCourse.save(course);
		if (objCourse == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Course findById(int idCourse) {
		Course course = rCourse.findById(idCourse).get();
		return course;
	}
	@Override
		public void deleteCourse(int idCourse) {
		rCourse.deleteById(idCourse);
	}

	@Override
	@Transactional(readOnly = true)
	public Course searchById(String idCourse) {
		return rCourse.searchById(idCourse);
	}

}