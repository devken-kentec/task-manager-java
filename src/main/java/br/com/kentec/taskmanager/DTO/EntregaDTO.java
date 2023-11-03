package br.com.kentec.taskmanager.DTO;

import java.time.LocalDate;

import br.com.kentec.taskmanager.domain.Entrega;

public class EntregaDTO {
	
	private Long id;
	private LocalDate data;
	private String urlGit;
	private String observacao;
	private String status;
	private Long projetoId;
	private String projetoDescricao;
	private Long tarefaId;
	private String tarefaDescricao;
	private Long userId;
	
	public EntregaDTO(){}
	
	public EntregaDTO(Entrega entrega) {
		this.id = entrega.getId();
		this.data = entrega.getData();
		this.urlGit = entrega.getUrlGit();
		this.observacao = entrega.getObservacao();
		this.status = entrega.getStatus().toString();
		this.projetoId = entrega.getProjeto().getId();
		this.projetoDescricao = entrega.getProjeto().getDescricao();
		this.tarefaId = entrega.getTarefa().getId();
		this.tarefaDescricao = entrega.getTarefa().getDescricao();
		this.userId = entrega.getUser().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getUrlGit() {
		return urlGit;
	}

	public void setUrlGit(String urlGit) {
		this.urlGit = urlGit;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getProjetoId() {
		return projetoId;
	}

	public void setProjetoId(Long projetoId) {
		this.projetoId = projetoId;
	}

	public Long getTarefaId() {
		return tarefaId;
	}

	public void setTarefaId(Long tarefaId) {
		this.tarefaId = tarefaId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getProjetoDescricao() {
		return projetoDescricao;
	}

	public void setProjetoDescricao(String projetoDescricao) {
		this.projetoDescricao = projetoDescricao;
	}

	public String getTarefaDescricao() {
		return tarefaDescricao;
	}

	public void setTarefaDescricao(String tarefaDescricao) {
		this.tarefaDescricao = tarefaDescricao;
	}

	@Override
	public String toString() {
		return "EntregaDTO [id=" + id + ", data=" + data + ", urlGit=" + urlGit + ", observacao=" + observacao
				+ ", status=" + status + ", projetoId=" + projetoId + ", projetoDescricao=" + projetoDescricao
				+ ", tarefaId=" + tarefaId + ", tarefaDescricao=" + tarefaDescricao + ", userId=" + userId + "]";
	}
}
