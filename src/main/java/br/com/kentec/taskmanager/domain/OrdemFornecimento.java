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
@Table(name="ordem_fornecimento")
@SuppressWarnings("serial")
public class OrdemFornecimento implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="numero", nullable = true, length = 10)
	private Integer numero;
	
	@Column(name="referencia", nullable = false, length = 7)
	private String referencia;
	
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private User user = new User();
	
	@Column(name="status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	public OrdemFornecimento() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrdemFornecimento [id=" + id + ", numero=" + numero + ", referencia=" + referencia + ", user=" + user
				 + ", status=" + status + "]";
	}
}
