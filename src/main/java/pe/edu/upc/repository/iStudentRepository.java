package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Student;

@Repository
public interface iStudentRepository extends JpaRepository<Student, Integer> {
	
	@Query("from Student c where c.user.id_user=:idUser")
	Student findByUserId(int idUser);
}
