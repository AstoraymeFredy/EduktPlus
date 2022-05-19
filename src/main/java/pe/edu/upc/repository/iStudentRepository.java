package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Student;

@Repository
public interface iStudentRepository extends JpaRepository<Student, Integer> {
	
	@Query("from Student c where c.name like %:nameStudent%")
	List<Student> searchByName(@Param("nameStudent") String nameStudent);
	
	@Query("from Admin c where c.user.id_user=:idUser")
	Student findByUserId(int idUser);
}
