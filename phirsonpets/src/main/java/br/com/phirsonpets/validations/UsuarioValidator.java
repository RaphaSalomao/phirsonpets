package br.com.phirsonpets.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.phirsonpets.daos.UsuarioDao;
import br.com.phirsonpets.model.Usuario;
import br.com.phirsonpets.util.ValidadorCpf;

public class UsuarioValidator implements Validator {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bairro", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "celular", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cep", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cidade", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpf", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genero", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rua", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senha", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uf", "field.required");
		Usuario u = (Usuario) target;
		if (u.getBairro().length() > 30) {
			errors.rejectValue("bairro", "typeMismatch");
		}
		if (u.getCelular().length() > 13) {
			errors.rejectValue("celular", "typeMismatch");
		}
		if (u.getCep().length() > 9) {
			errors.rejectValue("cep", "typeMismatch");
		}
		if (u.getCidade().length() > 30) {
			errors.rejectValue("cidade", "typeMismatch");
		}
		if (u.getCpf().length() > 11) {
			errors.rejectValue("cpf", "typeMismatch");
		}
		if (u.getNome().length() > 50) {
			errors.rejectValue("nome", "typeMismatch");
		}
		if (u.getRua().length() > 100) {
			errors.rejectValue("rua", "typeMismatch");
		}
		if (u.getUf().length() != 2) {
			errors.rejectValue("uf", "typeMismatch");
		}
		if (!u.getCpf().isEmpty()) {
			String cpf = u.getCpf();
			String email = u.getEmail();
			if (usuarioDao.buscaUsuarioPeloCpf(cpf)) {
				errors.rejectValue("cpf", "constraintViolated");
			}
			if (usuarioDao.buscaUsuarioPeloEmail(email)) {
				errors.rejectValue("email", "constraintViolated");
			}
			if (!ValidadorCpf.isValid(cpf)) {
				errors.rejectValue("cpf", "typeMismatch");
			}
		}
	}
}
