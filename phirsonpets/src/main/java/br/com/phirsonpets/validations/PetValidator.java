package br.com.phirsonpets.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.phirsonpets.model.Pet;
import br.com.phirsonpets.model.Usuario;

public class PetValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Pet.class.isAssignableFrom(clazz) || Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genero", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipoAnimal", "field.required");
		Pet pet = (Pet) target;
		if (pet.getNome().length() > 20) {
			errors.rejectValue("nome", "typeMismatch");
		}
		if (pet.getRaca().length() > 20) {
			errors.rejectValue("raca", "typeMismatch");			
		}
	}
}
