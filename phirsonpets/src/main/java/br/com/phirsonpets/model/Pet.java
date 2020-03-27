package br.com.phirsonpets.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pet {

	@Id
	private String id;
	private String nome;
	private TipoAnimal tipoAnimal;
	private String raca;
	private GeneroAnimal genero;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}
	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public GeneroAnimal getGenero() {
		return genero;
	}
	public void setGenero(GeneroAnimal genero) {
		this.genero = genero;
	}
}
