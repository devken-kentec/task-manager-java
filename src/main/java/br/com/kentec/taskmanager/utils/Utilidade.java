package br.com.kentec.taskmanager.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import br.com.kentec.taskmanager.enuns.StatusEnum;

@Service
public class Utilidade {
	
	public List<StatusEnum> selectEnumStatus() {
		List<StatusEnum> listaStatus = new ArrayList<>();
		 Arrays.asList(StatusEnum.values()).forEach(
				s -> listaStatus.add(s));
		return listaStatus;
	}
	
	public StatusEnum setarStatus(String status) {
		StatusEnum setStatus = null;
		switch (status) {
		case "ATIVO": 
			setStatus = StatusEnum.ATIVO;
		break;
		case "INATIVO" : 
			setStatus = StatusEnum.INATIVO;
		break;
		case "ANDAMENTO" : 
			setStatus = StatusEnum.ANDAMENTO;
		break;
		case "EM_ESPERA" : 
			setStatus = StatusEnum.EM_ESPERA;
		break;
		case "FINALIZADO" : 
			setStatus = StatusEnum.FINALIZADO;
		break;
		default:
			setStatus = null;
		}
		return setStatus;
	}
}
