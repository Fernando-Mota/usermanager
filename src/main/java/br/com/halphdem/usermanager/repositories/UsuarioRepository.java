package br.com.halphdem.usermanager.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.halphdem.usermanager.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
	public Usuario findByNome(String nome);
	
	public Usuario findByLogin(String login);
	
}
