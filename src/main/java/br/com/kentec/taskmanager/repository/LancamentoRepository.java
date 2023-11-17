package br.com.kentec.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.taskmanager.domain.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
	
	@Query("SELECT e.urlGit, l.arquivoGit, l.hash, a.codigo, a.valor, t.numero, of.numero, p.descricao, l.status FROM Lancamento l "
			+ "JOIN l.atividade a "
			+ "JOIN l.ordemFornecimento of "
			+ "JOIN l.projeto p "
			+ "JOIN l.tarefa t "
			+ "JOIN l.entrega e ")
	Iterable<Lancamento> listarTodosLancamento();
	
	@Query("SELECT a.codigo, p.descricao, l.arquivoGit, l.hash, l.status, a.valor FROM Lancamento l "
			+ "JOIN l.atividade a "
			+ "JOIN l.projeto p ")
	Iterable<Lancamento> listarParaLancamento();
	
	@Query("SELECT l FROM Lancamento l WHERE l.atividade.codigo = :codigo ")
	List<Lancamento> listarParaLancamentoAtividade(@Param("codigo") String codigo);

}