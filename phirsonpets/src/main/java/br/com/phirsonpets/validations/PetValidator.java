package br.com.phirsonpets.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.phirsonpets.model.Pet;

public class PetValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Pet.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
	}

}
