package org.deem.project.leisure.repository;

import org.deem.project.leisure.model.Imovel;
import org.deem.project.leisure.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long>{
	Imovel findById(long id);
	//List<Imovel> findAllByAtivo(boolean ativo);
	
	//@Query("SELECT i FROM Imovel i WHERE i.proprietario = :usuario")
	Imovel findByUsuario(@Param("usuario") Usuario usuario);
	
	@Query("SELECT CASE WHEN COUNT(i) > 0 THEN TRUE ELSE FALSE END FROM Imovel i WHERE i.cep = :cep AND i.numero = :numero")
	boolean existsByCepAndNumero(@Param("cep")int cep, @Param("numero")int numero);
	
}
