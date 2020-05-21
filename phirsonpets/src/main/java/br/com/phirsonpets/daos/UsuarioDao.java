package br.com.phirsonpets.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.phirsonpets.model.Pet;
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

	public Usuario buscaUsuarioPeloEmail(String email) {
		Usuario usuario = (Usuario) em.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
				.setParameter("email", email)
				.getSingleResult();
		return usuario;
	}
	
	public void update(Usuario novoUsuario, String idUsuario) {
		Usuario usuarioAntigo = em.find(Usuario.class, idUsuario);
		em.refresh(usuarioAntigo);
		usuarioAntigo.setBairro(novoUsuario.getBairro());
		usuarioAntigo.setCelular(novoUsuario.getCelular());
		usuarioAntigo.setCep(novoUsuario.getCep());
		usuarioAntigo.setCidade(novoUsuario.getCidade());
		usuarioAntigo.setCuidador(novoUsuario.isCuidador());
		usuarioAntigo.setGenero(novoUsuario.getGenero());
		usuarioAntigo.setNome(novoUsuario.getNome());
		usuarioAntigo.setNotaMedia(novoUsuario.getNotaMedia());
		usuarioAntigo.setNumero(novoUsuario.getNumero());
		usuarioAntigo.setPetIndice(novoUsuario.getPetIndice());
		usuarioAntigo.setPets(novoUsuario.getPets());
		usuarioAntigo.setRua(novoUsuario.getRua());
		usuarioAntigo.setSenha(novoUsuario.getSenha());
		usuarioAntigo.setUf(novoUsuario.getUf());
	}
	
	public void updatePets(Usuario usuario) {
		Usuario u = em.find(Usuario.class, usuario.getId());
		em.refresh(u);
		u.setPets(usuario.getPets());
		System.out.println("Numero de Pets: " + u.getPets().size());
	}
	
	public void removePet(String idUsuario, Pet pet) {
		Usuario u =  em.find(Usuario.class, idUsuario);
		em.refresh(u);
		List<Pet> pets = u.getPets();
		pets.remove(pet);
		u.setPets(pets);
	}
	
	public boolean esteEmailEstaCadastrado(String email) {
		List<Usuario> usuarios = em.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
			.setParameter("email", email)
			.getResultList();
		if (usuarios.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean esteCpfEstaCadastrado(String cpf) {
		List<Usuario> usuarios = em.createQuery("select u from Usuario u where u.cpf = :cpf", Usuario.class)
				.setParameter("cpf", cpf)
				.getResultList();
		if (usuarios.isEmpty()) {
			return false;
		}
		return true;
	}
}
