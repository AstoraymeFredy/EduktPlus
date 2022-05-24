package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.model.Teacher;
import pe.edu.upc.service.iTeacherService;
import pe.edu.upc.utils.TeacherSearch;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private iTeacherService teacherService;

    @GetMapping
    public String list(Model model) {
        try {
            List<Teacher> teachers = teacherService.getAll();
            model.addAttribute("teachers", teachers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ""; /** pantalla de docentes-administrador**/
    }

    @GetMapping("new")
    public String newTeacher(Model model) {
        try {
            model.addAttribute("teacher", new Teacher());
        } catch (Exception e) {
        }
        return ""; /** pantalla de registro de docente**/
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
        return ""; /** pantalla de docentes-administrador**/
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable("id") Integer id) {
        try {
            if(teacherService.existsById(id)) {
                Optional<Teacher> optional = teacherService.findById(id);
                model.addAttribute("teacher", optional.get());
            } else {
                return ""; /** pantalla de lista de docentes**/
            }
        } catch (Exception e) {
        }

        return ""; /** pantalla de edicion de docentes**/
    }

    @PostMapping("saveedit")
    public String saveEdit(Model model, @ModelAttribute("teacher") Teacher teacher ) {
        try {
            Teacher teacherSaved = teacherService.update(teacher);
            model.addAttribute("teacher", teacherSaved);
        } catch (Exception e) {

        }
        return ""; /** pantalla de docentes-administrador**/
    }

    @GetMapping("{id}/del")
    public String delete (Model model,@PathVariable("id") Integer id) {
        try {
            if(teacherService.existsById(id)) {
                teacherService.deleteById(id);
            }

        }catch(	Exception e) {}

        return ""; /** pantalla de docentes-administrador**/
    }

    @PostMapping("busqueda")
    public String searchTeachers(Model model, @ModelAttribute("teacherSearch") TeacherSearch teacherSearch) {

        List<Teacher> teachers = new ArrayList<>();

        try {
            teachers = teacherService.findByNameContaining(teacherSearch.getName());
        } catch (Exception e) {
            // TODO: handle exception
        }

        model.addAttribute("teacherSearch", teacherSearch);
        model.addAttribute("teachers", teachers);

        return "searchs/"; /**pantalla actualizada de busqueda**/
    }

}
