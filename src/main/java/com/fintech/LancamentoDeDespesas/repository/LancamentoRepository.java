package com.fintech.LancamentoDeDespesas.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintech.LancamentoDeDespesas.models.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, UUID> {

}
