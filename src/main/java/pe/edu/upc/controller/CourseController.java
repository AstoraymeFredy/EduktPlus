package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.model.Course;
import pe.edu.upc.model.Teacher;
import pe.edu.upc.service.iCourseService;
import pe.edu.upc.service.iTeacherService;
import pe.edu.upc.utils.CourseSearch;
import pe.edu.upc.utils.TeacherSearch;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private iCourseService courseService;

    @Autowired
    private iTeacherService teacherService;

    @GetMapping
    public String list(Model model) {
        try {
            List<Course> courses = courseService.getAll();
            model.addAttribute("courses", courses);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ""; /** pantalla de cursos-administrador**/
    }

    @GetMapping("new")
    public String newCourse(Model model) {
        try {
            List<Teacher> teachers = teacherService.getAll();
            model.addAttribute("teachers",teachers);
            model.addAttribute("course", new Course());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ""; /** pantalla de registro de curso**/
    }

    @PostMapping("saveNew")
    public String saveNew(Model model, @Valid @ModelAttribute("course") Course course,
                          BindingResult result) {
        if(result.hasErrors()) {  }

        try {
            Course courseSaved = courseService.create(course);
            model.addAttribute("course", courseSaved);

        } catch (Exception e) {
            // TODO: handle exception
        }
        return ""; /** pantalla de cursos-administrador**/
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable("id") Integer id) {
        try {
            if(courseService.existsById(id)) {
                Optional<Course> optional = courseService.findById(id);
                List<Teacher> teachers = teacherService.getAll();
                model.addAttribute("teacher", optional.get());
                model.addAttribute("course", optional.get());
            } else {
                return ""; /** pantalla de lista de cursos**/
            }
        } catch (Exception e) {
        }

        return ""; /** pantalla de edicion de curso**/
    }

    @PostMapping("saveedit")
    public String saveEdit(Model model, @ModelAttribute("country") Course course ) {
        try {
            Course courseSaved = courseService.update(course);
            model.addAttribute("course", courseSaved);
        } catch (Exception e) {

        }
        return ""; /** pantalla de cursos-administrador**/
    }

    @GetMapping("{id}/del")
    public String delete (Model model,@PathVariable("id") Integer id) {
        try {
            if(courseService.existsById(id)) {
                courseService.deleteById(id);
            }

        }catch(	Exception e) {}

        return ""; /** pantalla de cursos-administrador**/
    }

    @PostMapping("busqueda")
    public String searchCourses(Model model, @ModelAttribute("courseSearch") CourseSearch courseSearch) {

        List<Course> courses = new ArrayList<>();

        try {
            courses = courseService.findByNameContaining(courseSearch.getName());
        } catch (Exception e) { }

        model.addAttribute("courseSearch", courseSearch);
        model.addAttribute("courses", courses);

        return "searchs/"; /**pantalla actualizada de busqueda**/
    }
}
