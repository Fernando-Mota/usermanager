package br.com.halphdem.usermanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.halphdem.usermanager.model.Usuario;
import br.com.halphdem.usermanager.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario findById(String id) {
		Usuario usuario = usuarioRepository.findOne(id); 
		return usuario;
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario delete(String id) {
		Usuario usuario = usuarioRepository.findOne(id);
		usuarioRepository.delete(usuario);		
		return usuario;
	}
	
	public Usuario grava(Usuario usuario) {
		usuarioRepository.save(usuario);
		return usuario;
	}

	public Usuario findByLogin(String login) {
		return usuarioRepository.findByLogin(login);
	}
}
