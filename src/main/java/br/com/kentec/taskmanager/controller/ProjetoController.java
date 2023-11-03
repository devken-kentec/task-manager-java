package br.com.kentec.taskmanager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.kentec.taskmanager.DTO.ProjetoDTO;
import br.com.kentec.taskmanager.service.ProjetoService;


@RestController
@RequestMapping("/taskmanager/api/v1/projeto")
public class ProjetoController {
	
	@Autowired
	private ProjetoService ps;
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ProjetoDTO>> listarProjeto(@PathVariable("id") Long id){
		return ResponseEntity.ok(ps.listarProjeto(id));
	}
	
	@GetMapping("/listarProjetos")
	public ResponseEntity<Iterable<ProjetoDTO>> listarProjetos(){
		return ResponseEntity.ok(ps.listarProjetos());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravarProjeto(@RequestBody ProjetoDTO projetoDTO) {
		ps.gravarProjeto(projetoDTO);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterarPeriodo(@RequestBody ProjetoDTO projetoDTO) {
		ps.alterarProjeto(projetoDTO);
	}
}
