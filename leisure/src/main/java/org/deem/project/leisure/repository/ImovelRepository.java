package org.deem.project.leisure.repository;

import java.util.List;

import org.deem.project.leisure.model.Imovel;
import org.deem.project.leisure.model.Usuario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long>{
	Imovel findById(long id);

	Imovel findByUsuario(@Param("usuario") Usuario usuario);
	
	@Query("SELECT CASE WHEN COUNT(i) > 0 THEN TRUE ELSE FALSE END FROM Imovel i WHERE i.cep = :cep AND i.numero = :numero")
	boolean existsByCepAndNumero(@Param("cep")int cep, @Param("numero")int numero);

	boolean existsByCepAndNumero(String cep, int numero);
	
	List<Imovel> findByUsuarioId(Long id);

	List<Imovel> findAll(Specification<Imovel> spec);
	List<Imovel> findAll();

	Imovel save(Imovel imovel);
	
}
