package br.com.kentec.taskmanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.taskmanager.domain.OrdemFornecimento;
import br.com.kentec.taskmanager.domain.User;
import br.com.kentec.taskmanager.repository.OrdemFornecimentoRepository;
import br.com.kentec.taskmanager.repository.UserRepository;

@Service
public class OrdemFornecimentoService {
	
	@Autowired
	private OrdemFornecimentoRepository ofr;
	
	@Autowired
	private UserRepository ur;
	
	public Iterable<OrdemFornecimento> listarOFs(){
		return ofr.findAll();
	}
	
	public void gravarOF(OrdemFornecimento of) {
		Optional<User> user = ur.findById(1L);
		of.setUser(user.get());
		ofr.save(of);
	}
	
	public void alterarOF(OrdemFornecimento of) {
		Optional<OrdemFornecimento> ordFor = ofr.findById(of.getId());
		if(ordFor.isPresent()) {
			Optional<User> user = ur.findById(1L);
			of.setUser(user.get());
			ofr.save(of);
		}
	}
}
