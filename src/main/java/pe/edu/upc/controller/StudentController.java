package pe.edu.upc.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.service.iStudentService;
import pe.edu.upc.service.iUserService;
import pe.edu.upc.utils.Session;
import pe.edu.upc.model.Student;
import pe.edu.upc.model.UserModel;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private Session sesion;
	
	@Autowired
	private iStudentService sService;
	
	@Autowired
	private iUserService uService;
	
	@RequestMapping("/list")
	public String goPageListStudent(Map<String, Object> model) {
		model.put("listStudent", sService.listStudent());
		model.put("student", new Student());
		return "student/list";
	}
	
	@RequestMapping("/search")
	public String buscar(Map<String, Object> model, @ModelAttribute Student student)
			throws ParseException
	{
		List<Student> listaStudent;
		listaStudent = sService.searchStudent(student.getName());			
		if (listaStudent.isEmpty()) {
			listaStudent = sService.searchStudentLastname(student.getName());
		}
		
		model.put("listStudent", listaStudent);		
		return  "student/list";
	}	
	
	@RequestMapping("/register")
	public String goPageRegister(Model model) {
		model.addAttribute("student", new Student());
		return "student/register";
	}
	
	@RequestMapping("/registerStudent")
	public String register(@Valid @ModelAttribute Student objStudent, BindingResult binRes, Model model)
			throws ParseException {

		if (binRes.hasErrors()) {
			int id = objStudent.getId_student();
			if(id != 0) {
				model.addAttribute("mensaje1", "Ocurrio un error");
				return "student/update";
			} else {
				model.addAttribute("mensaje1", "Ocurrio un error");
				return "student/register";
			}
			
		} else {
			UserModel user = objStudent.getUser();
			user.setUsername(user.getUsername().trim());
			user.setPassword(user.getPassword().trim());
			Calendar birth_date = objStudent.getBirth_date();
			Calendar today = Calendar.getInstance();
			int age = today.get(1) - birth_date.get(1);
			if (age < 14) {
				model.addAttribute("mensaje", "La edad mínima para el registro es 14");
				return "student/register";
			}
			boolean flag = true;
			try {
				flag = uService.createUser(user);
			} catch (Exception e) {
				model.addAttribute("mensaje", "El usuario ya existe");
				return "student/register";
			}
			if (flag) {
				objStudent.setUser(user);
				
				try {
					flag = sService.createStudent(objStudent);
				} catch (Exception e) {
					model.addAttribute("mensaje", "El DNI ya existe");
					return "student/register";
				}
			} 
			if (flag) {
				model.addAttribute("mensaje2","Registro exitoso");
				model.addAttribute("listStudent", sService.listStudent());
				model.addAttribute("student", new Student());
				return  "student/list";
			}	
			else {
				int id = objStudent.getId_student();
				if(id != 0) {
					model.addAttribute("mensaje", "Ocurrio un error");
					return "redirect:/student/update";
				} else {
					model.addAttribute("mensaje", "Ocurrio un error");
					return "redirect:/student/register";
				}
				
			}
		}
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(Map<String, Object> model, Student student, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				Student studendg = sService.findById(id);
				sService.deleteStudent(id);
				uService.deleteUser(studendg.getUser().getId_user());
				model.put("listStudent", sService.listStudent());
			}
		} catch (Exception ex) {
			model.put("mensaje", "El estudiante no se puede eliminar, está matriculado en un curso");
			model.put("listStudent", sService.listStudent());
		}
		return "student/list";
	}
	
	@RequestMapping("/edit/{id}")
	public String editStudent(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Student objStudent = sService.findById(id);
		if (objStudent == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/student/list";
		} else {
			if (objStudent != null)
				model.addAttribute("student", objStudent);
			return "student/update";
		}
	}
	
	
	@RequestMapping("/view")
	public String goPageView(Model model) {
		model.addAttribute("student",sesion.getStudent());
		return "perfilStudent/view";
	}

	@RequestMapping("/edit")
	public String goPageEdit(Model model) {
		model.addAttribute("student",sesion.getStudent());
		return "perfilStudent/update";
	}
	
	@RequestMapping("/editStudent")
	public String editClient(@Valid @ModelAttribute(value = "student") Student objStudent, BindingResult binRes,
			Model model, HttpSession httpSession) throws ParseException {
		if (binRes.hasErrors()) {
			return "perfilStudent/update";
		} else {
			boolean flag = sService.updateStudent(objStudent);
			if (flag) {
				httpSession.setAttribute("nameUser", objStudent.getName() + " " + objStudent.getLastname());
				sesion.setStudent(objStudent);
				model.addAttribute("inf", "Actualización exitosa");
				model.addAttribute("student",sesion.getStudent());
				return "perfilStudent/view";
			} else {
				return "redirect:/student/edit";
			}
		}
	}
}
