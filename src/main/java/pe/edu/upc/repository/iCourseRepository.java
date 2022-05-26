package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Course;

import java.util.Date;
import java.util.List;


@Repository
public interface iCourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByNameContaining(String name);
    
    
	@Query(value = "SELECT c.nombre, count(m.id_registration), sum(c.precio) as profit "
			+ "from curso c join matricula m on c.id_course = m.id_course "
			+ "group by c.nombre " + "order by profit DESC", nativeQuery = true)
	List<String[]> findCourseReport();
	
	@Query(value = "SELECT c.nombre, count(m.id_registration), sum(c.precio) as profit "
			+ "from curso c join matricula m on c.id_course = m.id_course "
			+ "where m.fecha_registro>=:start_date and m.fecha_registro<=:end_date " 
			+ "group by c.nombre " + "order by profit DESC", nativeQuery = true)
	List<String[]> findCourseReportByDates(@Param("start_date") Date start_date,
			@Param("end_date") Date end_date);
	
	@Query(value = "SELECT c.nombre, count(m.id_course)  "
			+ "FROM matricula m join curso c on c.id_course = m.id_course "
			+ "group by c.nombre "
			+ "ORDER BY count(m.id_course) DESC limit 1", nativeQuery = true)
	List<String[]> findHeaderReportCourse();
	
	@Query(value = "SELECT c.nombre, count(m.id_course)  "
			+ "FROM matricula m join curso c on c.id_course = m.id_course "
			+ "where m.fecha_registro>=:start_date and m.fecha_registro<=:end_date " 
			+ "group by c.nombre "
			+ "ORDER BY count(m.id_course) DESC limit 1", nativeQuery = true)
	List<String[]> findHeaderReportCourseByDates(@Param("start_date") Date start_date,
			@Param("end_date") Date end_date);
	
}
