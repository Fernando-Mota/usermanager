package br.com.halphdem.usermanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("dashboard")
public class DashboardController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView formulario() {
		ModelAndView modelAndView = new ModelAndView("dashboard/principal");
		return modelAndView;
	}
}
