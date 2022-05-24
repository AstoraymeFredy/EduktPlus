package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.model.Teacher;

import java.util.List;

@Repository
public interface iTeacherRepository extends JpaRepository<Teacher, Integer> {
    List<Teacher> findByNameContaining(String name);
}
