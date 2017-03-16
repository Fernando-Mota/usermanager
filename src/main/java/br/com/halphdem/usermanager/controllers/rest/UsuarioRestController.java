package br.com.halphdem.usermanager.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.halphdem.usermanager.model.Usuario;
import br.com.halphdem.usermanager.services.UsuarioService;

@RestController
@RequestMapping(path="/rest/usuario", produces="application/json")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(path="/lista", method=RequestMethod.GET)
	public List<Usuario> lista() {
		return usuarioService.findAll();
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Usuario visualiza(@PathVariable String id) {
		return usuarioService.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Usuario adiciona(@RequestBody Usuario usuario) {
		return usuarioService.grava(usuario);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Usuario altera(@RequestBody Usuario usuario) {
		return usuarioService.grava(usuario);
	}

	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public Usuario deleta(@PathVariable String id) {
		return usuarioService.delete(id);
	}
}
