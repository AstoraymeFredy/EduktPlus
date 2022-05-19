package pe.edu.upc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	
	@RequestMapping("/list")
	public String goPageListRegistrations(Map<String, Object> model) {
		// model.put("listAdmin", aService.listAdmin());
		return "registration/list";
	}
	
}
