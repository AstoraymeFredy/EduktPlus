package pe.edu.upc.controller;

import com.sun.el.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.model.Teacher;
import pe.edu.upc.service.iTeacherService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private iTeacherService teacherService;


    @RequestMapping("/list")
    public String listTeachers(Map<String, Object> model) {
        try {
            model.put("listTeacher", teacherService.listTeacher());
            model.put("teacher", new Teacher());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "teacher/list";
    }

    @GetMapping("register")
    public String newTeacher(Model model) {
        try {
            model.addAttribute("teacher", new Teacher());
        } catch (Exception e) {
        }
        return "teacher/register";
    }

    @PostMapping("saveNew")
    public String saveNew(Model model, @Valid @ModelAttribute("teacher") Teacher teacher,
                          BindingResult result) {
        if(result.hasErrors()) {  }

        try {
           Teacher teacherSaved = teacherService.create(teacher);
            model.addAttribute("teacher", teacherSaved);

        } catch (Exception e) {

        }
        return "redirect:/teacher/list";
    }

    @GetMapping("/edit/{id}")
    public String editTeacher(Model model, @PathVariable("id") Integer id) {
        try {
            if(teacherService.existsById(id)) {
                Optional<Teacher> optional = teacherService.findById(id);
                model.addAttribute("teacher", optional.get());
            } else {
                return "redirect:/teacher/list";
            }
        } catch (Exception e) {
        }

        return "teacher/update";
    }

    @PostMapping("saveedit")
    public String saveEdit(Model model, @ModelAttribute("teacher") Teacher teacher ) {
        try {
            Teacher teacherSaved = teacherService.update(teacher);
            model.addAttribute("teacher", teacherSaved);
        } catch (Exception e) {

        }
        return "redirect:/teacher/list";
    }

    @GetMapping("/del/{id}")
    public String deleteTeacher (Model model,@PathVariable("id") Integer id) {
        try {
            if(teacherService.existsById(id)) {
                teacherService.deleteById(id);
            }

        }catch(	Exception e) {}

        return "redirect:/teacher/list";
    }

    @RequestMapping("/search")
    public String buscar(Map<String, Object> model, @ModelAttribute Teacher teacher)
            throws ParseException
    {
        List<Teacher> listaTeacher;
        listaTeacher = teacherService.searchTeacher(teacher.getName());
        if (listaTeacher.isEmpty()) {
            listaTeacher = teacherService.searchTeacherLastname(teacher.getName());
        }

        if (listaTeacher.isEmpty()) {
            model.put("mensaje", "No existen coincidencias");
        }

        model.put("listTeacher", listaTeacher);
        return  "teacher/list";
    }
}