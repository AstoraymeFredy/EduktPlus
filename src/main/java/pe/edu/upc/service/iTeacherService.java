package pe.edu.upc.service;


import pe.edu.upc.model.Teacher;

import java.util.List;

public interface iTeacherService extends iCrudService<Teacher, Integer> {
    public List<Teacher> searchTeacher(String nameTeacher);
    public List<Teacher> searchTeacherLastname(String nameTeacher);
    public List<Teacher> listTeacher();

}
