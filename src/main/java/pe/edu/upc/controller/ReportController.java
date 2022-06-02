package pe.edu.upc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.el.parser.ParseException;

import pe.edu.upc.service.iRegistrationService;
import pe.edu.upc.utils.ReportSearch;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private iRegistrationService sRegistration;

	
	@RequestMapping("/view")
	public String reportCourse(Model model) {
		model.addAttribute("reportSearch", new ReportSearch());
		model.addAttribute("listCourseReport", sRegistration.courseReport());
		model.addAttribute("headerNumber", sRegistration.headerReportNumber());
		model.addAttribute("headerCourse", sRegistration.headerReportCourse());
		model.addAttribute("headerTeacher", sRegistration.headerReportTeacher());
		return "report/list";
	}
	
	@RequestMapping("/viewByDates")
	public String reportCourseByDates(Map<String, Object> model, @ModelAttribute ReportSearch reportSearch) throws ParseException {
		if (reportSearch.getStart_date() == null || reportSearch.getEnd_date() == null) {
			model.put("message", "Error: Debes seleccionar el rango de fecha");
			model.put("listCourseReport", sRegistration.courseReport());
			model.put("headerNumber", sRegistration.headerReportNumber());
			model.put("headerCourse", sRegistration.headerReportCourse());
			model.put("headerTeacher", sRegistration.headerReportTeacher());
		} else {
			if (reportSearch.getEnd_date().after(reportSearch.getStart_date())) {
				model.put("message", null);
				model.put("listCourseReport",
						sRegistration.courseReportByDates(reportSearch.getStart_date(), reportSearch.getEnd_date()));
				model.put("headerNumber", sRegistration.headerReportNumberByDates(reportSearch.getStart_date(), reportSearch.getEnd_date()));
				model.put("headerCourse", sRegistration.headerReportCourseByDates(reportSearch.getStart_date(), reportSearch.getEnd_date()));
				model.put("headerTeacher", sRegistration.headerReportTeacherByDates(reportSearch.getStart_date(), reportSearch.getEnd_date()));
			} else {
				model.put("listCourseReport",
						sRegistration.courseReportByDates(reportSearch.getStart_date(), reportSearch.getEnd_date()));
				model.put("headerNumber", sRegistration.headerReportNumberByDates(reportSearch.getStart_date(), reportSearch.getEnd_date()));
				model.put("headerCourse", sRegistration.headerReportCourseByDates(reportSearch.getStart_date(), reportSearch.getEnd_date()));
				model.put("headerTeacher", sRegistration.headerReportTeacherByDates(reportSearch.getStart_date(), reportSearch.getEnd_date()));
				model.put("message",
						"Error: Debes seleccionar correctamente las fechas. La fecha de inicio no puede ser posterior");
			}
		}
		return "report/list";
	}
	
	
}
