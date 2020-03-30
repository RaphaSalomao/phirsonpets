package br.com.phirsonpets.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.phirsonpets.daos.PetDao;
import br.com.phirsonpets.daos.UsuarioDao;
import br.com.phirsonpets.model.GeneroAnimal;
import br.com.phirsonpets.model.Pet;
import br.com.phirsonpets.model.TipoAnimal;
import br.com.phirsonpets.model.Usuario;
import br.com.phirsonpets.validations.PetValidator;

@Controller
@RequestMapping("/user")
public class UserController {

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
	
	@RequestMapping(value = "/{id}/cadastra-pet", method = RequestMethod.GET)
	public ModelAndView furmularioCadastraPet(@PathVariable("id") String idUsuario,Pet pet) {
		ModelAndView modelAndView = new ModelAndView("user/formulario-cadastra-pets");
		modelAndView.addObject("tiposAnimais", TipoAnimal.values());
		modelAndView.addObject("generos", GeneroAnimal.values());
		modelAndView.addObject("pet", pet);
		modelAndView.addObject("usuario", usuarioDao.find(idUsuario));
		return modelAndView;
	}

	@RequestMapping(value = "/{id}/home")
	public ModelAndView perfilCliente(@PathVariable("id") String idUsuario) {
		ModelAndView modelAndView = new ModelAndView("user/perfil-cliente");
		Usuario usuario = usuarioDao.find(idUsuario);
		modelAndView.addObject("usuario", usuario);
		modelAndView.addObject("pets", usuario.getPets());
		return modelAndView;
	}
	
	@RequestMapping(value = "/{id}/cadastra-pet", method = RequestMethod.POST)
	public ModelAndView cadastrarPet( @PathVariable("id") String idUsuario, @Valid Pet pet, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			return furmularioCadastraPet(idUsuario, pet);
		}
		int petIndex;
		Usuario usuario = new Usuario();
		usuario.setId(idUsuario);
		usuario = usuarioDao.find(usuario);
		List<Pet> pets = usuario.getPets();
		if (pets.isEmpty()) {
			petIndex = 1;
		} else {
			petIndex = pets.size() + 1;
		}
		pet.setId(idUsuario + "#" + petIndex);
		pets.add(pet);
		petDao.insert(pet);
		usuario.setPets(pets);
		usuarioDao.update(usuario);
		return perfilCliente(idUsuario);
	}
}
