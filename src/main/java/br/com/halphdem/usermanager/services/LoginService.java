package br.com.halphdem.usermanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.halphdem.usermanager.model.Usuario;

@Service
public class LoginService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	public boolean efetuaLogin(Usuario usuario) {
		Usuario usuarioBanco = usuarioService.findByLogin(usuario.getLogin());
		if (usuarioBanco != null) {
			if (usuarioBanco.getSenha().equals(usuario.getSenha())) {
				return true;
			}
		}
		return false;				
	}

}
