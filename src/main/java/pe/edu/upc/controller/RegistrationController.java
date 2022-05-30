package pe.edu.upc.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.model.Course;
import pe.edu.upc.model.Registration;
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
		model.put("listInscription", rService.listByStudent(sesion.getStudent().getId_student()));
		if (rService.listByStudent(sesion.getStudent().getId_student()).isEmpty())
			model.put("vacio", 1);
		model.put("course", new Course());

		return "registration/listMyCourses";
	}

	@RequestMapping("/goRegister")
	public String goRegister(Map<String, Object> model) {
		model.put("listCourse", cService.listCourse());
		model.put("course", new Course());
		return "registration/listSelectCourse";
	}

	@RequestMapping("/delete")
	public String deleteStudent(Map<String, Object> model, Registration registration,
			@RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				rService.deleteRegistration(id);
				return "redirect:/registration/list";
			}
		} catch (Exception ex) {
			model.put("mensaje", "El curso en la matricula no se puede elminar");
			model.put("listInscription", rService.listByStudent(sesion.getStudent().getId_student()));
		}
		return "registration/listMyCourses";
	}

	@RequestMapping("/buscarcursos")
	public String buscarcursos(Map<String, Object> model, @ModelAttribute Course course) throws ParseException {
		List<Course> listCourse;
		listCourse = cService.searchCourse(course.getName());

		if (listCourse.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}

		model.put("listCourse", listCourse);
		return "registration/listSelectCourse";
	}

	@RequestMapping("/buscarcursosinscritos")
	public String buscarcursosinscritos(Map<String, Object> model, @ModelAttribute Course course)
			throws ParseException {
		List<Registration> listRegistration;
		listRegistration = rService.searchInscription(sesion.getStudent().getId_student(), course.getName());
	
		model.put("listInscription", listRegistration);
		return "registration/listMyCourses";
	}
	
	@RequestMapping("/registrarmatricula")
	public String registrarmatricula(Model model, @RequestParam(value = "id") Integer id) {
		Registration registration = new Registration();
		 List<Registration> list = rService.listByStudent(sesion.getStudent().getId_student());
		Course course= cService.searchById(String.valueOf(id));
		registration.setCourse(course);
		registration.setDate_register(new Date());
		registration.setEnabled(true);
		registration.setStudent(sesion.getStudent());
		
		boolean flag = false;
		  for (int i = 0; i < list.size(); i++) {
		     if(list.get(i).getCourse().getId_course()== course.getId_course()) flag=true; 
		    }
		
		if(flag) {
			return "redirect:/registration/goRegister";
		}
		else {
			boolean f=rService.save(registration);
			if(f) {
				return "redirect:/registration/list";
			}
			
			return "redirect:/registration/list";
		}
		
	}
	
	
}
