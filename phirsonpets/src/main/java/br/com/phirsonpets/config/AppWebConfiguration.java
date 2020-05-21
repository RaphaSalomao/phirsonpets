package br.com.phirsonpets.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.phirsonpets.controllers.HomeController;
import br.com.phirsonpets.controllers.UserController;
import br.com.phirsonpets.daos.PetDao;
import br.com.phirsonpets.daos.UsuarioDao;
import br.com.phirsonpets.model.Usuario;
import br.com.phirsonpets.validations.LoginValidator;
import br.com.phirsonpets.validations.PetValidator;
import br.com.phirsonpets.validations.UsuarioValidator;

@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class, UserController.class, 
		UsuarioDao.class,PetDao.class,
		UsuarioValidator.class, PetValidator.class,LoginValidator.class,
		Usuario.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposedContextBeanNames("usuario");
		return resolver;
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setCacheSeconds(1);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	}

}
