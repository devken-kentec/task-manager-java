package br.com.kentec.taskmanager.service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.taskmanager.DTO.EntregaDTO;
import br.com.kentec.taskmanager.domain.Entrega;
import br.com.kentec.taskmanager.domain.Projeto;
import br.com.kentec.taskmanager.domain.Tarefa;
import br.com.kentec.taskmanager.domain.User;
import br.com.kentec.taskmanager.repository.EntregaRepository;
import br.com.kentec.taskmanager.repository.ProjetoRepository;
import br.com.kentec.taskmanager.repository.TarefaRepository;
import br.com.kentec.taskmanager.repository.UserRepository;
import br.com.kentec.taskmanager.utils.Utilidade;

@Service
public class EntregaService {
	
	@Autowired
	private EntregaRepository er;
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private ProjetoRepository pr;
	
	@Autowired
	private TarefaRepository tr;
	
	@Autowired
	private Utilidade util;
	
	public Optional<EntregaDTO> listarEntrega(Long id){
		return er.findById(id).map(EntregaDTO::new);
	}
	
	public Iterable<EntregaDTO> listarEntregas() {
		return er.listarTodasEntregas().stream().map(EntregaDTO::new).collect(Collectors.toList());
	}

	public void gravarEntrega(EntregaDTO entregaDTO) {
		Optional<User> user = ur.findById(entregaDTO.getUserId());
		Optional<Projeto> projeto = pr.findById(entregaDTO.getProjetoId());
		Optional<Tarefa> tarefa = tr.findById(entregaDTO.getTarefaId());
		
		if(user.isPresent()) {
			var data = LocalDate.now();
			Entrega ent = new Entrega();
			ent.setData(data);
			ent.setUrlGit(entregaDTO.getUrlGit());
			ent.setObservacao(entregaDTO.getObservacao());
			ent.setStatus(util.setarStatus(entregaDTO.getStatus()));
			ent.setProjeto(projeto.get());
			ent.setTarefa(tarefa.get());
			ent.setUser(user.get());
			er.save(ent);
			System.out.println(ent);
		}
	}

	public void alterarEntrega(EntregaDTO entregaDTO) {
		Optional<Entrega> entrega = er.findById(entregaDTO.getId());
		if(entrega.isPresent()) {
			Optional<User> user = ur.findById(entregaDTO.getUserId());
			Optional<Projeto> projeto = pr.findById(entregaDTO.getProjetoId());
			Optional<Tarefa> tarefa = tr.findById(entregaDTO.getTarefaId());
			
			if(user.isPresent()) {
				var data = LocalDate.now();
				entrega.get().setData(data);
				entrega.get().setUrlGit(entregaDTO.getUrlGit());
				entrega.get().setObservacao(entregaDTO.getObservacao());
				entrega.get().setStatus(util.setarStatus(entregaDTO.getStatus()));
				entrega.get().setProjeto(projeto.get());
				entrega.get().setTarefa(tarefa.get());
				entrega.get().setUser(user.get());
				er.save(entrega.get());
			}
		}
	}
}
