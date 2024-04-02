package org.deem.project.leisure.repository;


import org.deem.project.leisure.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Roles, Long>{
	
	@Query(value="SELECT * FROM roles r WHERE r.role=?", nativeQuery=true)
	Roles findByName(String roles);

}
