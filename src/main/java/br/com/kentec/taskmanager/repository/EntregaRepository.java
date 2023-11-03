package br.com.kentec.taskmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kentec.taskmanager.domain.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{
	
	Optional<Entrega> findByUrlGit(String urlGit);
}
