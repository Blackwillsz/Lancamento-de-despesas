package com.fintech.LancamentoDeDespesas.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintech.LancamentoDeDespesas.models.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, UUID>{

}
