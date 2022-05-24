package pe.edu.upc.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Registration;


@Repository
public interface iRegistrationRepository extends JpaRepository<Registration, Integer> {
	

	@Query("from Registration r where r.student.id_student = :idStudent")
	List<Registration> findByStudentId(@Param("idStudent") int idStudent);
}
