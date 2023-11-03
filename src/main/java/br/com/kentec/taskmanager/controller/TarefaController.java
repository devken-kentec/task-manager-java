package br.com.kentec.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.taskmanager.domain.Tarefa;
import br.com.kentec.taskmanager.service.TarefaService;

@RestController
@RequestMapping("/taskmanager/api/v1/tarefa")
public class TarefaController {
	
	@Autowired
	private TarefaService ts;
	
	@GetMapping("/listarTarefas")
	public ResponseEntity<Iterable<Tarefa>> listarTarefas(){
		return ResponseEntity.ok(ts.listarTarefas());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravarTarefa(@RequestBody Tarefa tarefa) {
		ts.gravarTarefa(tarefa);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterarTarefa(@RequestBody Tarefa tarefa) {
		ts.alterarTarefa(tarefa);
	}
}
