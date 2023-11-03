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

import br.com.kentec.taskmanager.DTO.EntregaDTO;
import br.com.kentec.taskmanager.service.EntregaService;

@RestController
@RequestMapping("/taskmanager/api/v1/entrega")
public class EntregaController {
	
	@Autowired
	private EntregaService es;
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<EntregaDTO>> listarProjeto(@PathVariable("id") Long id){
		return ResponseEntity.ok(es.listarEntrega(id));
	}
	
	@GetMapping("/listarEntregas")
	public ResponseEntity<Iterable<EntregaDTO>> listarEntregas(){
		return ResponseEntity.ok(es.listarEntregas());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravarEntrega(@RequestBody EntregaDTO entregaDTO) {
		es.gravarEntrega(entregaDTO);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterarEntrega(@RequestBody EntregaDTO entregaDTO) {
		es.alterarEntrega(entregaDTO);
	}
}
