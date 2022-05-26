package pe.edu.upc.service;


import pe.edu.upc.model.Teacher;

import java.util.List;

public interface iTeacherService extends iCrudService<Teacher, Integer> {
    List<Teacher> findByNameContaining(String name)throws Exception;
    


}
