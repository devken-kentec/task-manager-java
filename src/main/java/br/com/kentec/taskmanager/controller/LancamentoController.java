package br.com.kentec.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.kentec.taskmanager.DTO.LancamentoDTO;
import br.com.kentec.taskmanager.domain.Lancamento;
import br.com.kentec.taskmanager.service.LancamentoService;

@RestController
@RequestMapping("/taskmanager/api/v1/lancamento")
public class LancamentoController {
	
	@Autowired
	private LancamentoService ls;
	
	@GetMapping("/todos")
	public Iterable<Lancamento> listarTodos(){
		return ls.listarTodos();
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravarLancamento(@RequestBody Iterable<LancamentoDTO> lancamentoDTO) {
		ls.gravarLancamento(lancamentoDTO);
	}

}
