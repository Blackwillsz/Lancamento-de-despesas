package com.fintech.LancamentoDeDespesas.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fintech.LancamentoDeDespesas.models.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, UUID> {
	
	@Query(" SELECT lancamento FROM Lancamento lancamento "
			+ "LEFT JOIN lancamento.idEmpresa ORDER BY lancamento.pago ")
	public Page<Lancamento> findTodosLancamentos(Pageable paginacao);

}
