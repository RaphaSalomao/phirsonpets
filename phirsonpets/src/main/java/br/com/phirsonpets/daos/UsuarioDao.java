package br.com.phirsonpets.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.phirsonpets.model.Usuario;

@Repository
@Transactional
public class UsuarioDao {

	@PersistenceContext
	private EntityManager em;

	public void insert(Usuario usuario) {
		em.persist(usuario);
	}

	public Usuario find(Usuario usuario) {
		return em.find(Usuario.class, usuario.getId());
	}

	public Usuario find(String id) {
		return em.find(Usuario.class, id);
	}

	public void update(Usuario usuario) {
		Usuario u = em.find(Usuario.class, usuario.getId());
		em.refresh(u);
		u.setPets(usuario.getPets());
		System.out.println("Numero de Pets: " + u.getPets().size());
	}

	public  boolean buscaUsuarioPeloEmail(String email) {
		List<Usuario> usuarios = em.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
			.setParameter("email", email)
			.getResultList();
		if (usuarios.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean buscaUsuarioPeloCpf(String cpf) {
		List<Usuario> usuarios = em.createQuery("select u from Usuario u where u.cpf = :cpf", Usuario.class)
				.setParameter("cpf", cpf)
				.getResultList();
		if (usuarios.isEmpty()) {
			return false;
		}
		return true;
	}
}
