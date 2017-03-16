package br.com.halphdem.usermanager.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.halphdem.usermanager.model.Usuario;
import br.com.halphdem.usermanager.services.LoginService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(path="/form", method=RequestMethod.GET)
	public ModelAndView formulario() {
		ModelAndView modelAndView = new ModelAndView("login/form");
		return modelAndView;
	}
	
	@RequestMapping(path="/efetualogin", method=RequestMethod.POST)
	public ModelAndView efetualogin(Usuario usuario) {
		ModelAndView modelAndView;
		if (loginService.efetuaLogin(usuario)) {
			modelAndView = new ModelAndView("redirect:/dashboard");
		} else {
			modelAndView = new ModelAndView("login/erro");
		}
		return modelAndView;
	}
	
	@RequestMapping(path="/logout", method=RequestMethod.POST)
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		return modelAndView;
	}
}
