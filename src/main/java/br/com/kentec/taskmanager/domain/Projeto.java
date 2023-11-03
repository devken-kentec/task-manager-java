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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="projeto" )
@SuppressWarnings("serial")
public class Projeto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="descricao", nullable = false, length = 64)
	private String descricao;
	
	@Column(name="status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private User user = new User();
	
	public Projeto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Projeto [id=" + id + ", descricao=" + descricao + ", status=" + status + ", user=" + user + "]";
	}
}
