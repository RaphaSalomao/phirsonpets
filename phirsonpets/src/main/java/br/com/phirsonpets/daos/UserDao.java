package br.com.phirsonpets.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.phirsonpets.model.Usuario;

@Repository
public class UserDao implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;
	
	public  Usuario loadUserByUsername(String email) throws UsernameNotFoundException {
		List<Usuario> usuarios = manager.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
			.setParameter("email", email)
			.getResultList();
		
		if (usuarios.isEmpty()) {
			throw new RuntimeException("Usuário " + email + " nao foi encontrado");
		}
		
		return usuarios.get(0);
	}

	
}
