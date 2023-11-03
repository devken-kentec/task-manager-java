package br.com.kentec.taskmanager.DTO;

public class LancamentoDTO {
	 private Long id;
	 private String urlGit;
	 private Long projetoId;
	 private Long tarefaId;
	 private String hash;
	 private Long ofId;
	 private Long atividadeId;
	 private String arquivoGit;
     private String status;
	
	public LancamentoDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrlGit() {
		return urlGit;
	}

	public void setUrlGit(String urlGit) {
		this.urlGit = urlGit;
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

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Long getOfId() {
		return ofId;
	}

	public void setOfId(Long ofId) {
		this.ofId = ofId;
	}

	public Long getAtividadeId() {
		return atividadeId;
	}

	public void setAtividadeId(Long atividadeId) {
		this.atividadeId = atividadeId;
	}


	public String getArquivoGit() {
		return arquivoGit;
	}

	public void setArquivoGit(String arquivoGit) {
		this.arquivoGit = arquivoGit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LancamentoDTO [id=" + id + ", urlGit=" + urlGit + ", projetoId=" + projetoId + ", tarefaId=" + tarefaId
				+ ", hash=" + hash + ", ofId=" + ofId + ", atividadeId=" + atividadeId + ", arquivoGit=" + arquivoGit
				+ ", status=" + status + "]";
	}
}
