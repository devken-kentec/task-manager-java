package br.com.kentec.taskmanager.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.kentec.taskmanager.domain.Entrega;


public interface EntregaRepository extends JpaRepository<Entrega, Long>{
	
	Optional<Entrega> findByUrlGit(String urlGit);
	
	@Query("SELECT e FROM Entrega e WHERE e.status != 'FINALIZADO' ")
	List<Entrega> listarTodasEntregas();
}
