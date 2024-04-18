package org.deem.project.leisure.repository;

import java.util.List;

import org.deem.project.leisure.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findById(long id);
	List<Usuario> findByEmailOrCpf(String email, String cpf);
	Usuario findByEmailAndSenha(String email, String senha);
	Usuario findByNome(String nome);
	Usuario findByEmail(String email);
	@Procedure(procedureName="delete_usuario")
	void deleteUsuario(@Param("id") Long id);
}
