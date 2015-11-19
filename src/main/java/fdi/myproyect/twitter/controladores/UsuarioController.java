package fdi.myproyect.twitter.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fdi.myproyect.twitter.entidades.TweetEntity;
import fdi.myproyect.twitter.servicioAplicacion.UsuarioSA;

@Controller
public class UsuarioController {

	UsuarioSA servicio;
	
	@Autowired
	public UsuarioController(UsuarioSA servicio)
	{
		this.servicio = servicio;
	}
		
	@RequestMapping(value="/", method = RequestMethod.POST)
	String add(){			
		
		return "redirect:/twitter"; // vuelve a entrar home() de arriba
	}		
	
	
}