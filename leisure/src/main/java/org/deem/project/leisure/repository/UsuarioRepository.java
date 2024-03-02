package org.deem.project.leisure.repository;

import java.util.List;

import org.deem.project.leisure.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findById(long id);
	//List<Usuario> findAllByAtivo(boolean ativo);
	List<Usuario> findByEmailOrCpf(String email, String cpf);
	Usuario findByEmailAndSenha(String email, String senha);
	void deleteById(Long id);
	
	//@Modifying(clearAutomatically = true, flushAutomatically = true)	
	//@Query("UPDATE Usuario u set u.senha = :senha, u.telefone = :telefone, u.cep = :cep, u.numResidencia = :numResidencia, u.complemento = :complemento WHERE u.id = :id RETURNING u")
	//Usuario updateAll(@Param(value = "id")Long id,@Param(value = "senha")String senha, @Param(value = "telefone")String telefone, @Param(value = "cep")String cep, @Param(value = "numResidencia")Short numResidencia, @Param(value = "complemento")String complemento);
	
	//void atualizacao(String senha, String telefone, String cep, Short numResidencia, String complemento);;
}
