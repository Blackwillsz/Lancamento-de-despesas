package com.fintech.LancamentoDeDespesas.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fintech.LancamentoDeDespesas.dto.LancamentoDto;
import com.fintech.LancamentoDeDespesas.models.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, UUID> {
	
	@Query(" SELECT lancamento FROM Lancamento lancamento "
			+ "LEFT JOIN FETCH lancamento.idEmpresa ORDER BY lancamento.pago ")
	public List<LancamentoDto> findTodosLancamentos();

}
