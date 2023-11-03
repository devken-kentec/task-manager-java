package br.com.kentec.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.taskmanager.domain.Atividade;
import br.com.kentec.taskmanager.repository.AtividadeRepository;

@Service
public class AtividadeService {
	
	@Autowired
	private AtividadeRepository ar;
	
	public Iterable<Atividade> listarAtividades(){
		return ar.findAll();
	}

}
