package br.com.phirsonpets.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.com.phirsonpets.validations.PetValidator;
import br.com.phirsonpets.validations.UsuarioValidator;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {AppWebConfiguration.class, 
				JPAConfiguration.class, SecurityConfiguration.class,
				UsuarioValidator.class, PetValidator.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
}
