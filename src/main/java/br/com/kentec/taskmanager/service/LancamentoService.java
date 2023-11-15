package br.com.kentec.taskmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.kentec.taskmanager.DTO.LancamentoDTO;
import br.com.kentec.taskmanager.domain.Atividade;
import br.com.kentec.taskmanager.domain.Entrega;
import br.com.kentec.taskmanager.domain.Lancamento;
import br.com.kentec.taskmanager.domain.OrdemFornecimento;
import br.com.kentec.taskmanager.domain.Projeto;
import br.com.kentec.taskmanager.domain.Tarefa;
import br.com.kentec.taskmanager.repository.AtividadeRepository;
import br.com.kentec.taskmanager.repository.EntregaRepository;
import br.com.kentec.taskmanager.repository.LancamentoRepository;
import br.com.kentec.taskmanager.repository.OrdemFornecimentoRepository;
import br.com.kentec.taskmanager.repository.ProjetoRepository;
import br.com.kentec.taskmanager.repository.TarefaRepository;
import br.com.kentec.taskmanager.utils.Utilidade;

@Service
public class LancamentoService {
	
	@Autowired
	private Utilidade util;
	
	@Autowired
	private AtividadeRepository ar;
	
	@Autowired
	private ProjetoRepository pr;
	
	@Autowired
	private TarefaRepository tr;
	
	@Autowired
	private EntregaRepository er;
	
	@Autowired
	private OrdemFornecimentoRepository ofr;
	
	@Autowired
	private LancamentoRepository lr;
	
	public Iterable<Lancamento> listarTodos(){
		return lr.findAll();
	}
	
	public Iterable<Lancamento> listarTodosLancamento() {
		return lr.listarTodosLancamento();
	}
	
	public Iterable<Lancamento> listarParaLancar() {
		return lr.listarParaLancamento();
	}
	
	public void gravarLancamento(Iterable<LancamentoDTO> lancamentoDTO) {
		List<Lancamento> lancList = new ArrayList<>();
		for (LancamentoDTO lancamentoDTO2 : lancamentoDTO) {
			Optional<Atividade> ati = ar.findById(lancamentoDTO2.getAtividadeId());
			Optional<Projeto> pro = pr.findById(lancamentoDTO2.getProjetoId());
			Optional<Tarefa> tar = tr.findById(lancamentoDTO2.getTarefaId());
			Optional<Entrega> ent = er.findByUrlGit(lancamentoDTO2.getUrlGit());
			Optional<OrdemFornecimento> ordForn = ofr.findById(lancamentoDTO2.getOfId());
			
			Lancamento lanc = new Lancamento();
			lanc.setAtividade(ati.get());
			lanc.setProjeto(pro.get());
			lanc.setTarefa(tar.get());
			lanc.setEntrega(ent.get());
			lanc.setOrdemFornecimento(ordForn.get());
			lanc.setHash(lancamentoDTO2.getHash());
			lanc.setArquivoGit(lancamentoDTO2.getArquivoGit());
			lanc.setStatus(util.setarStatus(lancamentoDTO2.getStatus()));
			lancList.add(lanc);
		}
		lr.saveAll(lancList);
	}
}
