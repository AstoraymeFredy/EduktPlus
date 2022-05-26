package pe.edu.upc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pe.edu.upc.model.Teacher;
import pe.edu.upc.repository.iTeacherRepository;
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
    public List<Teacher> findByNameContaining(String name)throws Exception{
        return rTeacher.findByNameContaining(name);
    }
    

}
