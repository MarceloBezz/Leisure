package org.deem.project.leisure.repository;


import java.util.List;

import org.deem.project.leisure.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Roles, Long>{
	
	@Query(value="SELECT * FROM perfil p WHERE p.tipo=?", nativeQuery=true)
	Roles findByName(String roles);

	@Query(value="SELECT id_perfil FROM usuario_perfil WHERE ID_USUARIO =?", nativeQuery = true)
	List<Long> findPapeisById(Long id);

}
