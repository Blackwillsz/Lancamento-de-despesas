package com.fintech.LancamentoDeDespesas.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fintech.LancamentoDeDespesas.forms.EmpresaAtualizaForm;
import com.fintech.LancamentoDeDespesas.forms.EmpresaForm;
import com.fintech.LancamentoDeDespesas.models.Empresa;
import com.fintech.LancamentoDeDespesas.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Transactional
	public ResponseEntity<Empresa> cadastrarEmpresa(EmpresaForm form) {
		var empresa = new Empresa();
		BeanUtils.copyProperties(form, empresa);
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(empresa));
	}

	public List<Empresa> buscarTodasEmpresa() {
		return empresaRepository.findAll();
	}

	public ResponseEntity<Object> buscarPorId(UUID id) {
		Optional<Empresa> idEmpresa = empresaRepository.findById(id);
		if (!idEmpresa.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Código da empresa não encontrado!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(idEmpresa.get());
	}

	@Transactional
	public ResponseEntity<Object> atualizarEmpresa(UUID id, EmpresaAtualizaForm atualizaForm) {
		Optional<Empresa> updateEmpresa = empresaRepository.findById(id);
		if (!updateEmpresa.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Código da empresa não encontrado!");
		}
		var empresa = updateEmpresa.get();
		BeanUtils.copyProperties(atualizaForm, empresa);
		return ResponseEntity.status(HttpStatus.OK).body(empresaRepository.save(empresa));
	}

	@Transactional
	public Object deletarPorId(UUID id) {
		Optional<Empresa> updateEmpresa = empresaRepository.findById(id);
		if (!updateEmpresa.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Código da empresa não encontrado!");
		}
		empresaRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Empresa deletada com sucesso!");
	}
	
	
	
	
	
}
