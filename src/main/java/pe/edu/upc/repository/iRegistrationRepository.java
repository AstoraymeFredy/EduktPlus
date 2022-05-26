package pe.edu.upc.repository;

import java.util.Date;
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
	
	@Query(value = "SELECT count(m.id_student), sum(c.precio) as profit "
			+ "FROM matricula m join curso c on c.id_course = m.id_course" , nativeQuery = true)
	List<String[]> findHeaderReportNumber();
	
	@Query(value =  "SELECT count(m.id_student), sum(c.precio) as profit "
			+ "FROM matricula m join curso c on c.id_course = m.id_course "
			+ "where m.fecha_registro>=:start_date and m.fecha_registro<=:end_date"  , nativeQuery = true)
	List<String[]> findHeaderReportNumber(@Param("start_date") Date start_date,
			@Param("end_date") Date end_date);
}
