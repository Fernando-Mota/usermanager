package br.com.halphdem.usermanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.halphdem.usermanager.model.Usuario;
import br.com.halphdem.usermanager.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(path="/lista", method=RequestMethod.GET)
	public ModelAndView lista() {
		ModelAndView modelAndView = new ModelAndView("usuario/lista");
		List<Usuario> usuarios = usuarioService.findAll();
		modelAndView.addObject("usuarios", usuarios);		
		return modelAndView;
	}
	
	@RequestMapping(path="/form", method=RequestMethod.GET)
	public ModelAndView formulario(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuario/form");
		if (usuario != null) {
			modelAndView.addObject("usuario", usuario);
		}
		return modelAndView;
	}
	
	@RequestMapping(path="/form/{id}", method=RequestMethod.GET)
	public void formularioAlteracao(@PathVariable String id) {
		Usuario usuario = usuarioService.findById(id);
		formulario(usuario);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public ModelAndView visualiza(@PathVariable String id) {
		ModelAndView modelAndView = new ModelAndView("usuario/detalhe");
		Usuario usuario = usuarioService.findById(id);
		modelAndView.addObject("usuario", usuario);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView adiciona(Usuario usuario, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:usuario/lista");
		usuarioService.grava(usuario);
		return modelAndView;
	}
	
	@RequestMapping(path="/deleta", method=RequestMethod.POST)
	public ModelAndView deleta(String id) {
		ModelAndView modelAndView = new ModelAndView("redirect:lista");
		usuarioService.delete(id);
		return modelAndView;
	}
}
