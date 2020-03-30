package br.com.phirsonpets.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.phirsonpets.daos.UsuarioDao;
import br.com.phirsonpets.model.Genero;
import br.com.phirsonpets.model.Role;
import br.com.phirsonpets.model.Usuario;
import br.com.phirsonpets.validations.UsuarioValidator;

@Controller
public class HomeController {

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private UsuarioValidator usuarioValidator;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.addValidators(usuarioValidator);
	}

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("home/index");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "home/tela-login";
	}

	@RequestMapping(value = "home/cadastro-usuario", method = RequestMethod.GET)
	public ModelAndView formularioCadastro(Usuario u) {
		ModelAndView modelAndView = new ModelAndView("home/formulario-cadastro");
		String[] estados = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS",
				"MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
		modelAndView.addObject("generos", Genero.values());
		modelAndView.addObject("usuario", u);
		modelAndView.addObject("estados", estados);
		return modelAndView;
	}
	
	@RequestMapping(value = "home/cadastro-usuario", method = RequestMethod.POST)
	public ModelAndView cadastrarUsuario(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			return formularioCadastro(usuario);
		}
		ModelAndView modelAndView = new ModelAndView("redirect:usuario-cadastrado");
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role("ROLE_USER"));
		usuario.setRoles(roles);
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		usuario.setId(Long.toHexString(Long.valueOf(usuario.getCpf())));
		usuarioDao.insert(usuario);
		return modelAndView;
	}
	
	@RequestMapping("home/usuario-cadastrado")
	public ModelAndView usuarioCadastrado() {
		return new ModelAndView("home/usuario-cadastrado");
	}

}
