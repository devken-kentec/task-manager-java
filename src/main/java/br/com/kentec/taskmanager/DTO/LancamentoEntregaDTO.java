package br.com.kentec.taskmanager.DTO;

import java.math.BigDecimal;

import br.com.kentec.taskmanager.domain.Lancamento;

public class LancamentoEntregaDTO {
	 private String codigo;
	 private String descricao;
	 private String arquivoGit;
	 private String hash;
	 private String status;
	 private Integer tarefa;
	 private BigDecimal valor;
	 
	 public LancamentoEntregaDTO(Lancamento lanc) {
		 this.codigo = lanc.getAtividade().getCodigo();
		 this.descricao = lanc.getProjeto().getDescricao();
		 this.arquivoGit = lanc.getArquivoGit();
		 this.hash = lanc.getHash();
		 this.status = lanc.getStatus().toString();
		 this.tarefa = lanc.getTarefa().getNumero();
		 this.valor = lanc.getAtividade().getValor();
	 }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getArquivoGit() {
		return arquivoGit;
	}

	public void setArquivoGit(String arquivoGit) {
		this.arquivoGit = arquivoGit;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Integer getTarefa() {
		return tarefa;
	}
	
	public void setTarefa(Integer tarefa) {
		this.tarefa = tarefa;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "LancamentoEntregaDTO [codigo=" + codigo + ", descricao=" + descricao + ", arquivoGit=" + arquivoGit
				+ ", hash=" + hash + ", status=" + status + ", tarefa=" + tarefa + ", valor=" + valor + "]";
	}
	 
}
