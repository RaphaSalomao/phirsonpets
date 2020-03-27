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
	
}
