package pe.edu.upc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/list")
	public String goPageListStudent(Map<String, Object> model) {
		// model.put("listAdmin", aService.listAdmin());
		return "student/list";
	}

}
