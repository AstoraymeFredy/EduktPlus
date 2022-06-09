package pe.edu.upc.controller;

import com.sun.el.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.model.Student;
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
            // TODO: handle exception
        }
        return "teacher/register";
    }

    @RequestMapping("/saveNew")
    public String register(@Valid @ModelAttribute Teacher objTeacher, BindingResult binRes, Model model)
            throws ParseException {

        if (binRes.hasErrors()) {
            int id = objTeacher.getId_teacher();
            if(id != 0) {
                model.addAttribute("mensaje", "Ocurrio un error");
                return "teacher/update";
            } else {
                model.addAttribute("mensaje", "Ocurrio un error");
                return "teacher/register";
            }

        } else {
                boolean flag = true;

            if (flag) {
                try {
                    flag =  teacherService.createTeacher(objTeacher);
                } catch (Exception e) {
                    model.addAttribute("mensaje", "El DNI ya existe");
                    return "teacher/register";
                }
            }

            if(flag) {
                    model.addAttribute("success","Registro exitoso");
                    model.addAttribute("listTeacher", teacherService.listTeacher());
                    model.addAttribute("teacher", new Teacher());
                    return "teacher/list";
                }
                int id = objTeacher.getId_teacher();
                if(id != 0) {
                    model.addAttribute("mensaje", "Ocurrio un error");
                    return "redirect:/teacher/update";
                } else {
                    model.addAttribute("mensaje", "Ocurrio un error");
                    return "redirect:/teacher/register";
                }
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
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
    public String saveEdit(Model model, @ModelAttribute("teacher") Teacher teacher,
                           BindingResult result )throws ParseException {
        try {
                    Teacher teacherSaved = teacherService.update(teacher);
                    model.addAttribute("teacher", teacherSaved);
            } catch (Exception e) {
                result.getFieldErrors();
                return "teacher/update";

            }
            return "redirect:/teacher/list";


    }
    @RequestMapping("/delete")
    public String deleteTeacher(Map<String, Object> model, Teacher teacher, @RequestParam(value = "id") Integer id) {
        try {
            if (id != null && id > 0) {
                teacherService.deleteTeacher(id);
                model.put("listTeacher", teacherService.listTeacher());
                model.put("success", "Se eliminó el docente con éxito");
            }
        } catch (Exception ex) {
            model.put("mensaje", "El docente no se puede eliminar porque está asignado a un curso");
            model.put("listTeacher", teacherService.listTeacher());
        }
        return "teacher/list";
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