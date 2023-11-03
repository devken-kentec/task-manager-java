package br.com.kentec.taskmanager.domain;

import java.io.Serializable;

import br.com.kentec.taskmanager.enuns.StatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user" )
@SuppressWarnings("serial")
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="nome", nullable = true, length = 16)
	private String nome;
	
	@Column(name="matricula", nullable = false, length = 7)
	private String matricula;
	
	@Column(name="senha", nullable = false, length = 8)
	private String senha; 
	
	@Column(name="status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	public User() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", matricula=" + matricula + ", senha=" + senha + ", status="
				+ status + "]";
	}
}
