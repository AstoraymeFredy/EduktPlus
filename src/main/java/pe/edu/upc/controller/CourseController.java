package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.upc.model.Course;
import pe.edu.upc.model.Teacher;
import pe.edu.upc.service.iCourseService;
import pe.edu.upc.service.iTeacherService;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private iCourseService courseService;

    @Autowired
    private iTeacherService teacherService;

    @RequestMapping("/list")
    public String listCourses(Map<String, Object> model) {
        try {
            model.put("listCourse", courseService.listCourse());
            model.put("course", new Course());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "course/list";
    }

    @GetMapping("/register")
    public String newCourse(Model model) {
        try {
            List<Teacher> teachers = teacherService.getAll();
            model.addAttribute("teachers",teachers);
            model.addAttribute("course", new Course());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "course/register";
    }

    @PostMapping("saveNew")
    public String saveNew(Model model, @Valid @ModelAttribute("course") Course course,
                          BindingResult result) {
        List<Teacher> teachers = teacherService.listTeacher();
        model.addAttribute("teachers",teachers);
        if (result.hasErrors()) {
            return "course/register";
        }

        try {
            Course courseSaved = courseService.create(course);
            model.addAttribute("course", courseSaved);

        } catch (Exception e) {

        }
        return "redirect:/course/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        try {
            if(courseService.existsById(id)) {
                Optional<Course> optional = courseService.findById(id);
                List<Teacher> teachers = teacherService.getAll();
                model.addAttribute("teachers", teachers);
                model.addAttribute("course", optional.get());
            } else {
                return "redirect:/course/list";
            }
        } catch (Exception e) {
        }

        return "course/update";
    }

    @PostMapping("saveedit")
    public String saveEdit(Model model, @ModelAttribute("course") Course course, RedirectAttributes objRedir,
                           BindingResult result ) throws ParseException {
        if (result.hasErrors()) {
            return "course/update";
        }
        List<Teacher> teachers = teacherService.listTeacher();
        model.addAttribute("teachers",teachers);
        try {
            Course courseSaved = courseService.update(course);
            model.addAttribute("course", courseSaved);
            if (courseSaved == null) {
                objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
            }
        } catch (Exception e) {
            return "course/update";
        }
        return "redirect:/course/list";
    }

    @GetMapping("/del/{id}")
    public String delete (Model model,@PathVariable("id") Integer id) {
        try {
            if(courseService.existsById(id)) {
                courseService.deleteById(id);
            }
        }catch(	Exception e) {
           System.out.println("Error: El curso no se puede eliminar porque hay alumnos inscritos");
            return "redirect:/course/list";
        }
        return "redirect:/course/list";
    }

    @RequestMapping("/search")
    public String buscar(Map<String, Object> model, @ModelAttribute Course course)
            throws ParseException
    {
        List<Course> listCourse;
        listCourse = courseService.searchCourse(course.getName());

        if (listCourse.isEmpty()) {
            model.put("mensaje", "No existen coincidencias");
        }

        model.put("listCourse", listCourse);
        return  "course/list";
    }
}
