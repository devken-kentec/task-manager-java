package br.com.kentec.taskmanager.DTO;

import br.com.kentec.taskmanager.domain.Projeto;

public class ProjetoDTO {
  private Long id;
  private String descricao;
  private String status;
  private Long userId;
  
  public ProjetoDTO() {}
  
  public ProjetoDTO(Projeto projeto) {
	  this.id = projeto.getId();
	  this.descricao = projeto.getDescricao();
	  this.status = projeto.getStatus().toString();
	  this.userId = projeto.getUser().getId();
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
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ProjetoDTO [id=" + id + ", descricao=" + descricao + ", status=" + status + ", userId=" + userId + "]";
	}  
}
