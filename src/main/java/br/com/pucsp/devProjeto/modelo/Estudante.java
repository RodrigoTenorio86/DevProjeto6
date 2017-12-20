package br.com.pucsp.devProjeto.modelo;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Estudante extends AbstractEntity {
	@NotEmpty
	private String nome;
	@Email
	private String email;

	public Estudante() {}

	public Estudante(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public Estudante(Long id, String nome, String email) {
		this(nome, email);
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Estudante [nome=" + nome + ", email=" + email + "]";
	}

}
