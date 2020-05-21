package br.com.phirsonpets.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.phirsonpets.model.Pet;

@Transactional
@Repository
public class PetDao {

	@PersistenceContext
	EntityManager em;
	
	public void insert(Pet p) {
		em.persist(p);
	}
	
	public Pet find(String id) {
		return em.find(Pet.class, id);
	}
	
	public void update(Pet pet, String idPet) {
		Pet petAntigo = em.find(Pet.class, idPet);
		em.refresh(petAntigo);
		petAntigo.setGenero(pet.getGenero());
		petAntigo.setNome(pet.getNome());
		petAntigo.setRaca(pet.getRaca());
	}

	public void delete(String idPet) {
		em.remove(em.find(Pet.class, idPet));
	}
}
