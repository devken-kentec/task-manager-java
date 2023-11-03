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
import br.com.kentec.taskmanager.domain.OrdemFornecimento;
import br.com.kentec.taskmanager.service.OrdemFornecimentoService;

@RestController
@RequestMapping("/taskmanager/api/v1/ordemfornecimento")
public class OrdemFornecimentoController {
	
	@Autowired
	private OrdemFornecimentoService ofs;
	
	@GetMapping("/listarofs")
	public ResponseEntity<Iterable<OrdemFornecimento>> listarOFs(){
		return ResponseEntity.ok(ofs.listarOFs());
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravarOF(@RequestBody OrdemFornecimento of) {
		ofs.gravarOF(of);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterarOF(@RequestBody OrdemFornecimento of) {
		ofs.alterarOF(of);
	}
}
