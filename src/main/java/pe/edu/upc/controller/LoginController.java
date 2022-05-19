package pe.edu.upc.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.utils.Session;
import pe.edu.upc.model.Admin;
import pe.edu.upc.model.Student;
import pe.edu.upc.service.iAdminService;
import pe.edu.upc.service.iStudentService;
import pe.edu.upc.model.CustomUser;

@Controller
public class LoginController {
	
	@Autowired
	private Session sesion;
	
	@Autowired
	private iAdminService aService;
	
	@Autowired
	private iStudentService sService;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes flash, HttpSession httpSession) {
		if (principal != null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			CustomUser customUser = (CustomUser) authentication.getPrincipal();
			if (customUser.getUserID() == 1) {
				Admin admin = aService.findByUserId(customUser.getUserID());
				sesion.setAdmin(admin);
				model.addAttribute("admin", admin);
				httpSession.setAttribute("nameUser", admin.getName() + " " + admin.getLastname());
				return "redirect:/student/list";
			} else {
				Student findedStdudent = sService.findByUserId(customUser.getUserID());
				Student student = findedStdudent;
				httpSession.setAttribute("nameUser", student.getName() + " " + student.getLastname());
				sesion.setStudent(student);
				return "redirect:/registration/list";
			}

		}

		if (error != null) {
			model.addAttribute("error",
					"Error: Nombre de usuario o contraseña incorrecta. Por favor vuelva a intentarlo.");
		}

		if (logout != null) {
			sesion.setAdmin(new Admin());
			sesion.setStudent(new Student());
			model.addAttribute("success", "Ha cerrado sesión con éxito!");
		}

		return "index";
	}

}
