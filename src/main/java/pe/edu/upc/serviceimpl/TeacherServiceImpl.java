package pe.edu.upc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.model.Teacher;
import pe.edu.upc.controller.repository.iTeacherRepository;
import pe.edu.upc.service.iTeacherService;

import java.util.List;


@Service
public class TeacherServiceImpl implements iTeacherService {
    @Autowired
    private iTeacherRepository rTeacher;
    @Override
    public JpaRepository<Teacher, Integer> getJpaRepository() {
        return rTeacher;
    }


    @Override
    @Transactional
    public boolean createTeacher(Teacher teacher) {
        Teacher objTeacher = rTeacher.save(teacher);
        if (objTeacher == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Teacher> listTeacher() {
        return rTeacher.findAll();
    }

    @Override
    public void deleteTeacher(int idTeacher) {
        rTeacher.deleteById(idTeacher);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Teacher> searchTeacher(String nameTeacher){
        return rTeacher.searchByName(nameTeacher.toLowerCase());
    }

    @Override
    public List<Teacher> searchTeacherLastname(String nameTeacher) {
        return rTeacher.searchByLastName(nameTeacher.toLowerCase());
    }

}
