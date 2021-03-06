package pe.edu.upc.controller;

import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.time.ZoneId;

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
		List<Registration> listInscription = rService.listByStudent(sesion.getStudent().getId_student());
		model.put("listInscription", listInscription);
		if (listInscription.isEmpty())
			model.put("vacio", 1);
		model.put("course", new Course());

		return "registration/listMyCourses";
	}

	@RequestMapping("/goRegister")
	public String goRegister(Map<String, Object> model) {
		List<Course> listCourse = cService.listCourse();
		List<Registration> listRegistration = rService.listByStudent(sesion.getStudent().getId_student());

		for (int i = 0; i < listRegistration.size(); i++) {
			for (int j = 0; j < listCourse.size(); j++) {
				if (listRegistration.get(i).getCourse().getId_course() == listCourse.get(j).getId_course()) {
					for (int n = 0; n < listCourse.size(); n++) {
						if (listCourse.get(n).getId_course() == listCourse.get(j).getId_course()) {
							listCourse.remove(n);
							break;
						}
					}
					break;
				}
			}
		}

		if (listCourse.isEmpty())
			model.put("vacio", 2);
		model.put("listCourse", listCourse);
		model.put("course", new Course());

		return "registration/listSelectCourse";
	}

	@RequestMapping("/delete")
	public String deleteStudent(Map<String, Object> model, Registration registration,
			@RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {

				Registration r = rService.searchById(id);
				Calendar date = r.getDate_register();
				Calendar today = Calendar.getInstance();

				LocalDate hoy = today.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate despues = date.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				long limit = ChronoUnit.DAYS.between(despues, hoy);

				if (limit > 7) {
					List<Registration> listInscription = rService.listByStudent(sesion.getStudent().getId_student());
					model.put("listInscription", listInscription);
					if (listInscription.isEmpty())
						model.put("vacio", 1);
					model.put("course", new Course());
					model.put("mensaje", "L??mite de tiempo excedido(7 dias) para retiro");
					return "registration/listMyCourses";
				} else {
					rService.deleteRegistration(id);

					List<Registration> listInscription = rService.listByStudent(sesion.getStudent().getId_student());
					model.put("listInscription", listInscription);
					if (listInscription.isEmpty())
						model.put("vacio", 1);
					model.put("course", new Course());
					model.put("inf", "Retiro exitoso");
					return "registration/listMyCourses";
				}

			}
		} catch (Exception ex) {
			model.put("mensaje", "El curso en la matricula no se puede elminar");
			model.put("listInscription", rService.listByStudent(sesion.getStudent().getId_student()));
		}
		return "registration/listMyCourses";
	}

	@RequestMapping("/buscarcursos")
	public String buscarcursos(Map<String, Object> model, @ModelAttribute Course course) throws ParseException {
		List<Course> listCourseSaerch = cService.searchCourse(course.getName());

		List<Registration> listRegistration = rService.listByStudent(sesion.getStudent().getId_student());

		for (int i = 0; i < listRegistration.size(); i++) {
			for (int j = 0; j < listCourseSaerch.size(); j++) {
				if (listRegistration.get(i).getCourse().getId_course() == listCourseSaerch.get(j).getId_course()) {
					for (int n = 0; n < listCourseSaerch.size(); n++) {
						if (listCourseSaerch.get(n).getId_course() == listCourseSaerch.get(j).getId_course()) {
							listCourseSaerch.remove(n);
							break;
						}
					}
					break;
				}
			}
		}

		if (listCourseSaerch.isEmpty())
			model.put("vacio", 2);

		model.put("listCourse", listCourseSaerch);
		return "registration/listSelectCourse";
	}

	@RequestMapping("/buscarcursosinscritos")
	public String buscarcursosinscritos(Map<String, Object> model, @ModelAttribute Course course)
			throws ParseException {
		List<Registration> listRegistration = rService.searchInscription(sesion.getStudent().getId_student(),
				course.getName());

		if (listRegistration.isEmpty())
			model.put("vacio", 2);

		model.put("listInscription", listRegistration);
		return "registration/listMyCourses";
	}

	@RequestMapping("/registrarmatricula")
	public String registrarmatricula(Model model, @RequestParam(value = "id") Integer id) {
		Registration registration = new Registration();
		List<Registration> list = rService.listByStudent(sesion.getStudent().getId_student());
		List<Registration> listcompare = rService.listall();

		Course course = cService.searchById(String.valueOf(id));
		int count = 0;
		for (int i = 0; i < listcompare.size(); i++) {
			if (listcompare.get(i).getCourse().getId_course() == course.getId_course())
				count++;
		}

		if (count < 10) {
			Calendar today = Calendar.getInstance();
			registration.setCourse(course);
			registration.setDate_register(today);
			registration.setEnabled(true);
			registration.setStudent(sesion.getStudent());

			rService.save(registration);
			list = rService.listByStudent(sesion.getStudent().getId_student());
			model.addAttribute("listInscription", list);
			if (list.isEmpty())
				model.addAttribute("vacio", 1);
			model.addAttribute("course", new Course());
			model.addAttribute("inf", "Registro exitoso");
			return "registration/listMyCourses";

		} else if (count >= 10) {
			List<Course> listCourse = cService.listCourse();
			List<Registration> listRegistration = rService.listByStudent(sesion.getStudent().getId_student());
			;

			for (int i = 0; i < listRegistration.size(); i++) {
				for (int j = 0; j < listCourse.size(); j++) {
					if (listRegistration.get(i).getCourse().getId_course() == listCourse.get(j).getId_course()) {
						for (int n = 0; n < listCourse.size(); n++) {
							if (listCourse.get(n).getId_course() == listCourse.get(j).getId_course()) {
								listCourse.remove(n);
								break;
							}
						}
						break;
					}
				}
			}

			if (listCourse.isEmpty())
				model.addAttribute("vacio", 2);
			model.addAttribute("listCourse", listCourse);
			model.addAttribute("error", "El curso tiene el m??ximo de estudiantes");
			model.addAttribute("course", new Course());
			return "registration/listSelectCourse";
		} else {
			List<Course> listCourse = cService.listCourse();
			List<Registration> listRegistration = rService.listByStudent(sesion.getStudent().getId_student());
			;

			for (int i = 0; i < listRegistration.size(); i++) {
				for (int j = 0; j < listCourse.size(); j++) {
					if (listRegistration.get(i).getCourse().getId_course() == listCourse.get(j).getId_course()) {
						for (int n = 0; n < listCourse.size(); n++) {
							if (listCourse.get(n).getId_course() == listCourse.get(j).getId_course()) {
								listCourse.remove(n);
								break;
							}
						}
						break;
					}
				}
			}

			if (listCourse.isEmpty())
				model.addAttribute("vacio", 2);
			model.addAttribute("listCourse", listCourse);
			model.addAttribute("error", "Error: No se pudo matricular");
			model.addAttribute("course", new Course());
			return "registration/listSelectCourse";
		}

	}
}
