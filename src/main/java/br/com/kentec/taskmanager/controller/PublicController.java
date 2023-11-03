package br.com.kentec.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.taskmanager.enuns.StatusEnum;
import br.com.kentec.taskmanager.utils.Utilidade;

@RestController
@RequestMapping("/taskmanager/api/v1/public")
public class PublicController {
	
	@Autowired
	private Utilidade util;
	
	@GetMapping("/opt/status")
	public ResponseEntity<List<StatusEnum>> selectStatus() {
		return ResponseEntity.ok(util.selectEnumStatus());
	}
}
