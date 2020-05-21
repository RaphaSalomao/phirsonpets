package br.com.phirsonpets.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.phirsonpets.daos.PetDao;
import br.com.phirsonpets.daos.UserDao;
import br.com.phirsonpets.daos.UsuarioDao;
import br.com.phirsonpets.model.GeneroAnimal;
import br.com.phirsonpets.model.Pet;
import br.com.phirsonpets.model.TipoAnimal;
import br.com.phirsonpets.model.Usuario;
import br.com.phirsonpets.util.UsuarioBuilder;
import br.com.phirsonpets.validations.PetValidator;

@Controller
@RequestMapping("/user")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class UserController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	PetValidator petValidator;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.addValidators(petValidator);
	}
	
	@Autowired
	PetDao petDao;
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@RequestMapping(value = "/cadastra-pet", method = RequestMethod.GET)
	public ModelAndView furmularioCadastraPet(Principal principal,Pet pet) {
		ModelAndView modelAndView = new ModelAndView("user/formulario-cadastra-pets");
		modelAndView.addObject("tiposAnimais", TipoAnimal.values());
		modelAndView.addObject("generos", GeneroAnimal.values());
		modelAndView.addObject("pet", pet);
		modelAndView.addObject("usuario", usuarioDao.find(UsuarioBuilder
				.getUsuarioFromPrincipal(principal, usuarioDao).getId()));
		return modelAndView;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView perfilCliente(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("user/perfil-cliente");
		Usuario usuario = usuarioDao.find(UsuarioBuilder.getUsuarioFromPrincipal(principal, usuarioDao).getId());
		List<Pet> pets = usuario.getPets();
		System.out.println("Entrando na HOME");
		for (Pet pet : pets) {
			System.out.println("Pet: " + pet);
		}
		modelAndView.addObject("ehPaginaPerfil", true);
		modelAndView.addObject("usuario", usuario);
		modelAndView.addObject("pets", pets);
		return modelAndView;
	}
	
	@RequestMapping(value = "/cadastra-pet", method = RequestMethod.POST)
	public ModelAndView cadastrarPet(Principal principal, @Valid Pet pet, BindingResult result, RedirectAttributes attributes) {
		String idUsuario = UsuarioBuilder.getUsuarioFromPrincipal(principal, usuarioDao).getId();
		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			return furmularioCadastraPet(principal, pet);
		}
		int petIndex;
		Usuario usuario = new Usuario();
		usuario.setId(idUsuario);
		usuario = usuarioDao.find(usuario);
		List<Pet> pets = usuario.getPets();
		petIndex = usuario.getPetIndice() + 1;
		pet.setId(idUsuario + "#" + petIndex);
		pet.setNotaMedia(5);
		pet.setIndice(petIndex);
		pet.setUsuario(usuario);
		pets.add(pet);
		System.out.println("Adicionando Pet: " + pet.getNome() + ", ID: " + pet.getId());
		petDao.insert(pet);
		usuario.setPets(pets);
		usuario.setPetIndice(petIndex);
		usuarioDao.update(usuario, usuario.getId());
		usuarioDao.updatePets(usuario);
		return perfilCliente(principal);
	}
	
	@RequestMapping(value = "/editar-perfil", method = RequestMethod.GET)
	public ModelAndView editarPerfilCliente(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("user/editar-perfil-cliente");
		modelAndView.addObject("usuario", UsuarioBuilder.getUsuarioFromPrincipal(principal, usuarioDao));
		return modelAndView;
	}
	
	@RequestMapping(value = "/editar-pet", method = RequestMethod.GET)
	public ModelAndView formularioEditaPet(@RequestParam int petIndex, Principal principal) {
		ModelAndView modelAndView = new ModelAndView("user/editar-pet");
		Usuario usuario = UsuarioBuilder.getUsuarioFromPrincipal(principal, usuarioDao);
		Pet pet = null;
		for (Pet p : usuario.getPets()) {
			if (p.getIndice() == petIndex) {
				pet = p;
				break;
			}
		}
		modelAndView.addObject("pet", pet);
		modelAndView.addObject("generos", GeneroAnimal.values());
		modelAndView.addObject("tiposAnimais", TipoAnimal.values());
		return modelAndView;
	}
	
	@RequestMapping(value = "/editar-pet", method = RequestMethod.POST)
	public ModelAndView editarPet(Principal principal, @Valid Pet pet, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			return formularioEditaPet(pet.getIndice(), principal);
		}
		Usuario usuario = UsuarioBuilder.getUsuarioFromPrincipal(principal, usuarioDao);
		String idPet = null;
		for (Pet p : usuario.getPets()) {
			if (p.getIndice() == pet.getIndice()) {
				idPet = p.getId();
				break;
			}
		}
		petDao.update(pet, idPet);
		return perfilCliente(principal);
	}
	
	@RequestMapping(value = "/excluir-pet", method = RequestMethod.POST)
	public ModelAndView excluirPet(Principal principal, Pet pet) {
		Usuario usuario = UsuarioBuilder.getUsuarioFromPrincipal(principal, usuarioDao);
		String idPet = usuario.getId() + "#" + pet.getIndice();
		List<Pet> pets = usuario.getPets();
		pets.remove(petDao.find(idPet));
		petDao.delete(idPet);
		usuarioDao.removePet(usuario.getId(), petDao.find(idPet));
		return (perfilCliente(principal));
	}
}
