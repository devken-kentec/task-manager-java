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
@Table(name="lancamento")
@SuppressWarnings("serial")
public class Lancamento implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_projeto", nullable = false)
	private Projeto projeto = new Projeto();
	
	@ManyToOne
	@JoinColumn(name = "id_tarefa", nullable = false)
	private Tarefa tarefa = new Tarefa();
	
	@ManyToOne
	@JoinColumn(name = "id_ordem_fornecimento", nullable = false)
	private OrdemFornecimento ordemFornecimento = new OrdemFornecimento(); 
	
	@ManyToOne
	@JoinColumn(name = "id_atividade", nullable = false)
	private Atividade atividade = new Atividade();
	
	@ManyToOne
	@JoinColumn(name = "id_entrega", nullable = false)
	private Entrega entrega = new Entrega();
	
	@Column(name = "hash", nullable = false, length = 10)
	private String hash;
	
	@Column(name = "arquivo_git", nullable = false, length = 256)
	private String arquivoGit;
	
	@Column(name="status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusEnum status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public OrdemFornecimento getOrdemFornecimento() {
		return ordemFornecimento;
	}

	public void setOrdemFornecimento(OrdemFornecimento ordemFornecimento) {
		this.ordemFornecimento = ordemFornecimento;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getArquivoGit() {
		return arquivoGit;
	}

	public void setArquivoGit(String arquivoGit) {
		this.arquivoGit = arquivoGit;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	@Override
	public String toString() {
		return "Lancamento [id=" + id + ", projeto=" + projeto + ", tarefa=" + tarefa + ", ordemFornecimento="
				+ ordemFornecimento + ", atividade=" + atividade + ", entrega=" + entrega + ", hash=" + hash
				+ ", arquivoGit=" + arquivoGit + ", status=" + status + "]";
	}
}
