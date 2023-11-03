package br.com.kentec.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.kentec.taskmanager.domain.Atividade;
import br.com.kentec.taskmanager.service.AtividadeService;

@RestController
@RequestMapping("/taskmanager/api/v1/atividade")
public class AtividadeController {
	
	@Autowired
	private AtividadeService as;
	
	@GetMapping("/listarAtividades")
	public ResponseEntity<Iterable<Atividade>> listarAtividades(){
		return ResponseEntity.ok(as.listarAtividades());
	}
}
