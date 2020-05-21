package br.com.phirsonpets.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Entity
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Usuario implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String email;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Pet> pets = new ArrayList<Pet>();
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles = new ArrayList<Role>();
	private String nome;
	private Genero genero;
	private String cpf;
	private String celular;
	private boolean cuidador;
	private String cep;
	private String rua;
	private String bairro;
	private String uf;
	private String numero;
	private String cidade;
	private String senha;
	private double notaMedia;
	private int petIndice;
	
	public Usuario() {
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public boolean isCuidador() {
		return cuidador;
	}
	public void setCuidador(boolean cuidador) {
		this.cuidador = cuidador;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public void removePet(Pet pet) {
		this.pets.remove(pet);
	}
	
	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}
	
	public int getNotaInteira() {
		String notaString = "" + this.notaMedia;
		String[] vetorNotaString = notaString.split(".");
		return Integer.valueOf(vetorNotaString[0]);
	}
	
	public int getPetIndice() {
		return petIndice;
	}

	public void setPetIndice(int petIndex) {
		this.petIndice = petIndex;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nome=" + nome + ", genero=" + genero + ", cpf=" + cpf + ", celular="
				+ celular + ", cuidador=" + cuidador + ", cep=" + cep + ", rua=" + rua + ", bairro=" + bairro + ", uf="
				+ uf + ", numero=" + numero + ", cidade=" + cidade + ", senha=" + senha + "]";
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}
	@Override
	public String getPassword() {
		return this.senha;
	}
	@Override
	public String getUsername() {
		return this.nome;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
