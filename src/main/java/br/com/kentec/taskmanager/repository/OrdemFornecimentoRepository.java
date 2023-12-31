package br.com.kentec.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kentec.taskmanager.domain.OrdemFornecimento;

@Repository
public interface OrdemFornecimentoRepository extends JpaRepository<OrdemFornecimento, Long>{

}
