package br.com.kentec.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kentec.taskmanager.domain.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
	
}
