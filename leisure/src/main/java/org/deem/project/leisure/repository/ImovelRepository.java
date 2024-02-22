package org.deem.project.leisure.repository;

import java.util.List;

import org.deem.project.leisure.model.Imovel;
import org.deem.project.leisure.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long>{
	Imovel findById(long id);
	List<Imovel> findAllByAVenda(boolean ativo);
	
	@Query("SELECT IMOVEL FROM PROPRIETARIO WHERE PROPRIETARIO = :proprietario")
	Imovel findByProprietario(Imovel proprietario);
	
	@Query("SELECT CASE WHEN COUNT(i) > 0 THEN TRUE ELSE FALSE END FROM IMOVEL i WHERE i.cep = :cep AND i.numero = :numero")
	boolean existsByCepAndNumero(int cep, int numero);
	
}
