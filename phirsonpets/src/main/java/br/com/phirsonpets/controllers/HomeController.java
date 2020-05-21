package br.com.phirsonpets.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.phirsonpets.daos.UserDao;
import br.com.phirsonpets.daos.UsuarioDao;
import br.com.phirsonpets.model.Genero;
import br.com.phirsonpets.model.Role;
import br.com.phirsonpets.model.Usuario;
import br.com.phirsonpets.util.UsuarioBuilder;
import br.com.phirsonpets.validations.LoginValidator;
import br.com.phirsonpets.validations.UsuarioValidator;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class HomeController {

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	UserDao UserDao;

	@Autowired
	private UsuarioValidator usuarioValidator;

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.addValidators(usuarioValidator);
	}

	@RequestMapping("/")
	public ModelAndView index(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("home/index");
		Usuario usuario = UsuarioBuilder.getUsuarioFromPrincipal(principal, usuarioDao);
		modelAndView.addObject("usuario", usuario);
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Usuario u) {
		ModelAndView modelAndView = new ModelAndView("home/tela-login");
		return modelAndView;
	}

	@RequestMapping(value = "home/cadastro-usuario", method = RequestMethod.GET)
	public ModelAndView formularioCadastro(Usuario u, Authentication auth) {
		ModelAndView modelAndView = new ModelAndView("home/formulario-cadastro");
		String[] estados = { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
				"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };
		modelAndView.addObject("generos", Genero.values());
		modelAndView.addObject("usuario", u);
		modelAndView.addObject("estados", estados);
		try {
			if (auth.isAuthenticated()) {
				return new ModelAndView("redirect:/");
			} else {
				return modelAndView;
			}
		} catch (NullPointerException npe) {
			return modelAndView;
		}
	}

	@RequestMapping(value = "home/cadastro-usuario", method = RequestMethod.POST)
	public ModelAndView cadastrarUsuario(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			return formularioCadastro(usuario, null);
		}
		usuario.setId(Long.toHexString(Long.valueOf(usuario.getCpf())));
		ModelAndView modelAndView = new ModelAndView("redirect:/user/" + usuario.getId() + "/home");
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role("ROLE_USER"));
		usuario.setRoles(roles);
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		usuario.setNotaMedia(5.00);
		usuario.setPetIndice(0);
		usuarioDao.insert(usuario);
		return modelAndView;
	}

	@RequestMapping("home/usuario-cadastrado")
	public ModelAndView usuarioCadastrado() {
		return new ModelAndView("home/usuario-cadastrado");
	}


}
