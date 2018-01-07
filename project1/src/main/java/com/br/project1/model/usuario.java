package com.br.project1.model;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

@Entity

public class usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private Integer cpf;

	private DateTime dtnascimento;

	private String email;

	private String senha;

	public usuario() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public DateTime getDtnascimento() {
		return dtnascimento;
	}

	public void setDtnascimento(DateTime dtnascimento) {
		this.dtnascimento = dtnascimento;
	}

}
