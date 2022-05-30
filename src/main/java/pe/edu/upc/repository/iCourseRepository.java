package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Course;

import java.util.List;


@Repository
public interface iCourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByNameContaining(String name);
	
}