package pe.edu.upc.service;

import java.util.Date;
import java.util.List;

import pe.edu.upc.model.Registration;



public interface iRegistrationService {
	public List<Registration> listByStudent(int idStudent);
	public Registration searchById(int id);
	public List<Registration> listall();
	public List<Registration> searchInscription(int idStudent, String nameCourse);
	public void deleteRegistration(int idStudent);
	public boolean save(Registration registration);
	
	public List<String[]> courseReport();
	public List<String[]> courseReportByDates(Date start_date, Date end_date);
	public List<String[]> headerReportCourse();
	public List<String[]> headerReportCourseByDates(Date start_date, Date end_date);
	public List<String[]> headerReportTeacher();
	public List<String[]> headerReportTeacherByDates(Date start_date, Date end_date);
	public List<String[]> headerReportNumber();
	public List<String[]> headerReportNumberByDates(Date start_date, Date end_date);

}
