package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Admin;

@Repository
public interface iAdminRepository extends JpaRepository<Admin, Integer> {	
	@Query("from Admin c where c.user.id_user=:idUser")
	Admin findByUserId(int idUser);
}
