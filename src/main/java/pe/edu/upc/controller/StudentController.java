package pe.edu.upc.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.el.parser.ParseException;

import pe.edu.upc.service.iStudentService;
import pe.edu.upc.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private iStudentService sService;
	
	@RequestMapping("/list")
	public String goPageListStudent(Map<String, Object> model) {
		model.put("listStudent", sService.listStudent());
		return "student/list";
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
			return "student/Student";
		} else {
			boolean flag = sService.createStudent(objStudent);
			if (flag)
				return "redirect:/student/list";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/student/register";
			}
		}
	}

}
