package br.com.kentec.taskmanager.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.kentec.taskmanager.domain.Tarefa;
import br.com.kentec.taskmanager.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tr;
	
	public Iterable<Tarefa> listarTarefas(){
		return tr.findAll();
	}
	
	public void gravarTarefa(Tarefa tarefa) {
		tr.save(tarefa);
	}

	public void alterarTarefa(Tarefa tarefa) {
		tr.save(tarefa);
	}

}
