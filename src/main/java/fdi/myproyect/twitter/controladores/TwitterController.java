package fdi.myproyect.twitter.controladores;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import fdi.myproyect.twitter.entidades.TweetEntity;
import fdi.myproyect.twitter.entidades.UsuarioEntity;
import fdi.myproyect.twitter.servicioAplicacion.TwitterSA;
import fdi.myproyect.twitter.servicioAplicacion.UsuarioSA;

@Controller
public class TwitterController {
	
	TwitterSA servicio ;
	UsuarioSA servicioUsuario;
	
	@Autowired
	public TwitterController(TwitterSA servicio,UsuarioSA servicioUsuario) {
		this.servicio = servicio;
		this.servicioUsuario = servicioUsuario;
	}
	
	@RequestMapping(value = "/paginaTwitter", method = RequestMethod.GET)
	public ModelAndView paginaTwitter() {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("tweets", servicio.getAllTweets());
		
		
		ModelAndView view = new ModelAndView("paginaTwitter", model);
		
	
		return view;
	}

	
	@RequestMapping(value="/paginaTwitter", method = RequestMethod.POST)
	String add(TweetEntity tweet){
		
		
		List<UsuarioEntity> arrayUsu = servicioUsuario.getAllUsuario();
		
		Iterator<UsuarioEntity> it = arrayUsu.iterator();
		
		while(it.hasNext()){
		//	Object aux = it.next();
			UsuarioEntity usuarioAux = it.next();
			if(usuarioAux.getLogin() == true)
				tweet.setUsuario(usuarioAux);
		}
		servicio.addTweet(tweet);
		
		return "redirect:/paginaTwitter";
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ModelAndView user(@PathVariable(value="id") int id) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("tweets", servicio.getAllTweetsByUser(id));
		
		
		ModelAndView view = new ModelAndView("tweets", model);
		
		
			
		return view;
	}

	
	
}
