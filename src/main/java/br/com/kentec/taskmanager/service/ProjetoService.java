package br.com.kentec.taskmanager.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.taskmanager.DTO.ProjetoDTO;
import br.com.kentec.taskmanager.domain.Projeto;
import br.com.kentec.taskmanager.domain.User;
import br.com.kentec.taskmanager.repository.ProjetoRepository;
import br.com.kentec.taskmanager.repository.UserRepository;
import br.com.kentec.taskmanager.utils.Utilidade;

@Service
public class ProjetoService {
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private Utilidade util;
	
	@Autowired
	private ProjetoRepository pr;
	
	public Optional<ProjetoDTO> listarProjeto(Long id){
		return pr.findById(id).map(ProjetoDTO::new);
	}
	
	public Iterable<ProjetoDTO> listarProjetos(){
		return pr.findAll().stream().map(ProjetoDTO::new).collect(Collectors.toList());
	}
	
	public void gravarProjeto(ProjetoDTO projetoDTO) {
		Optional<User> user = ur.findById(projetoDTO.getUserId());
		Projeto projeto = new Projeto();
		projeto.setDescricao(projetoDTO.getDescricao());
		projeto.setStatus(util.setarStatus(projetoDTO.getStatus()));
		projeto.setUser(user.get());
		System.out.println(projeto);
		pr.save(projeto);
	}
	
	public void alterarProjeto(ProjetoDTO projetoDTO) {
		Optional<Projeto> proj = pr.findById(projetoDTO.getId());
		if(proj.isPresent()) {
			Optional<User> user = ur.findById(projetoDTO.getUserId());
			Projeto projeto = new Projeto();
			projeto.setId(projetoDTO.getId());
			projeto.setDescricao(projetoDTO.getDescricao());
			projeto.setStatus(util.setarStatus(projetoDTO.getStatus()));
			projeto.setUser(user.get());
			System.out.println(projeto);
			pr.save(projeto);
		}
	
	}
}
