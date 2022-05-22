package pe.edu.upc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.model.Registration;
import pe.edu.upc.model.Student;
import pe.edu.upc.service.iCourseService;
import pe.edu.upc.service.iRegistrationService;

import pe.edu.upc.utils.Session;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private Session sesion;
	
	@Autowired
	private iRegistrationService rService;
	
	@Autowired
	private iCourseService cService;
	
	@RequestMapping("/list")
	public String goPageListRegistrations(Map<String, Object> model) {
		// model.put("listAdmin", aService.listAdmin());
		model.put("listInscription",rService.listByStudent(sesion.getStudent().getId_student()));
		return "registration/list";
	}
	
	@RequestMapping("/goRegister")
	public String goRegister(Map<String, Object> model) {
		model.put("listCourse",cService.listCourse());
		return "Course/list";
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(Map<String, Object> model, Registration registration, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				rService.deleteRegistration(id);
				model.put("listInscription",rService.listByStudent(sesion.getStudent().getId_student()));
			}
		} catch (Exception ex) {
			model.put("mensaje", "El curso en la matricula no se puede elminar");
			model.put("listInscription",rService.listByStudent(sesion.getStudent().getId_student()));
		}
		return "registration/list";
	}
	
}
