package org.deem.project.leisure.repository;


import java.util.List;

import org.deem.project.leisure.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RoleRepository extends JpaRepository<Roles, Long>{
	
	@Query("SELECT r FROM Roles r WHERE r.role = :tipo")
	Roles findByName(@Param("tipo")String tipo);

	// @Query(value="SELECT id_perfil FROM usuario_perfil WHERE ID_USUARIO =?", nativeQuery = true)
	// List<Long> findPapeisById(Long id);

}
