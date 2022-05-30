package pe.edu.upc.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.model.Teacher;

import java.util.Date;
import java.util.List;

@Repository
public interface iTeacherRepository extends JpaRepository<Teacher, Integer> {

	@Query("from Teacher t where lower(t.name) like %:nameTeacher%")
	List<Teacher> searchByName(@Param("nameTeacher")String nameTeacher);

	@Query("from Teacher t where lower(t.lastname) like %:nameTeacher%")
	List<Teacher> searchByLastName(@Param("nameTeacher") String nameTeacher);


	@Query(value = "SELECT d.nombre, d.apellidos, count(m.id_student)  "
			+ "FROM matricula m join curso c on c.id_course = m.id_course "
			+ "join docente d on d.id_teacher = d.id_teacher "
			+ "group by d.nombre, d.apellidos "
			+ "ORDER BY count(m.id_student) DESC limit 1" , nativeQuery = true)
	List<String[]> findHeaderReportTeacher();
	
	@Query(value = "SELECT d.nombre, d.apellidos, count(m.id_student)  "
			+ "FROM matricula m join curso c on c.id_course = m.id_course "
			+ "join docente d on d.id_teacher = d.id_teacher "
			+ "where m.fecha_registro>=:start_date and m.fecha_registro<=:end_date " 
			+ "group by d.nombre, d.apellidos "
			+ "ORDER BY count(m.id_student) DESC limit 1" , nativeQuery = true)
	List<String[]> findHeaderReportTeacherByDates(@Param("start_date") Date start_date,
			@Param("end_date") Date end_date);
}
