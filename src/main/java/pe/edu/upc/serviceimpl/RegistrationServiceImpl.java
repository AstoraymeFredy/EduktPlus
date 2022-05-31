package pe.edu.upc.serviceimpl;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Registration;
import pe.edu.upc.controller.repository.iCourseRepository;
import pe.edu.upc.controller.repository.iRegistrationRepository;
import pe.edu.upc.controller.repository.iTeacherRepository;
import pe.edu.upc.service.iRegistrationService;

@Service
public class RegistrationServiceImpl implements iRegistrationService {
	
	@Autowired
	private iRegistrationRepository rRegistration;

	@Autowired
	private iCourseRepository rCourse;
	
	@Autowired
	private iTeacherRepository rTeacher;

	@Override
	public List<Registration> listByStudent(int idStudent) {
		return rRegistration.findByStudentId(idStudent);
	}
	
	@Override
	public List<Registration> listall() {
		return rRegistration.findAll();
	}
	
	@Override
	public List<Registration> searchInscription(int idStudent, String nameCourse){
		return rRegistration.searchInscription( idStudent,nameCourse);
	}

	@Override
	@Transactional
	public boolean save(Registration registration) {
		Registration objRegistration = rRegistration.save(registration);
		if (objRegistration == null)
			return false;
		else
			return true;
	}

	
	@Override
	public void deleteRegistration(int idStudent) {
		rRegistration.deleteById(idStudent);
	}
	
	@Override
	public List<String[]> headerReportNumber() {	
		return rRegistration.findHeaderReportNumber();
	}
	
	@Override
	public List<String[]> headerReportNumberByDates(Date start_date, Date end_date) {	
		return rRegistration.findHeaderReportNumber(start_date, end_date);
	}
	
	@Override
	public List<String[]> courseReport() {	
		return rCourse.findCourseReport();
	}
	
	@Override
	public List<String[]> courseReportByDates(Date start_date, Date end_date) {	
		return rCourse.findCourseReportByDates(start_date, end_date);
	}
	
	@Override
	public List<String[]> headerReportCourse() {	
		return rCourse.findHeaderReportCourse();
	}
	
	@Override
	public List<String[]> headerReportCourseByDates(Date start_date, Date end_date) {	
		return rCourse.findCourseReportByDates(start_date, end_date);
	}
	
	@Override
	public List<String[]> headerReportTeacher() {	
		return rTeacher.findHeaderReportTeacher();
	}
	
	@Override
	public List<String[]> headerReportTeacherByDates(Date start_date, Date end_date) {	
		return rTeacher.findHeaderReportTeacherByDates(start_date, end_date);
	}

}
