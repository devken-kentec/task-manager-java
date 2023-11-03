package br.com.kentec.taskmanager.domain;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name="tarefa")
@SuppressWarnings("serial")
public class Tarefa implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="numero", nullable = false, length = 10)
	private Integer numero;
	
	@Column(name="descricao", nullable = true, length = 64)
	private String descricao;
	
	@Column(name="data_inicial", nullable = true, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataInicial; 
	
	@Column(name="data_final", nullable = true, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataFinal;
	
	@Column(name="status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	public Tarefa() {}

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", numero=" + numero + ", descricao=" + descricao + ", dataInicial=" + dataInicial
				+ ", dataFinal=" + dataFinal + ", status=" + status + "]";
	}
}
