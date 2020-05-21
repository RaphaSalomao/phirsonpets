package br.com.phirsonpets.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pet implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	@ManyToOne
	private Usuario usuario;
	private int indice;
	private String nome;
	private TipoAnimal tipoAnimal;
	private String raca;
	private GeneroAnimal genero;
	private double notaMedia;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getIndice() {
		return indice;
	}
	public void setIndice(int index) {
		this.indice = index;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public double getNotaMedia() {
		return notaMedia;
	}
	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}
	
	public int getNotaInteira() {
		if (this.notaMedia != 5) {
		String notaString = "" + this.notaMedia;
		String[] vetorNotaString = notaString.split(".");
		return Integer.valueOf(vetorNotaString[0]);}else {
			return (int) this.notaMedia;
		}
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", nome=" + nome + ", tipoAnimal=" + tipoAnimal + ", raca=" + raca + ", genero="
				+ genero + ", notaMedia=" + notaMedia + "]";
	}

}
