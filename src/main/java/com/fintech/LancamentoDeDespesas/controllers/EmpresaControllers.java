package com.fintech.LancamentoDeDespesas.controllers;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintech.LancamentoDeDespesas.forms.EmpresaAtualizaForm;
import com.fintech.LancamentoDeDespesas.forms.EmpresaForm;
import com.fintech.LancamentoDeDespesas.models.Empresa;
import com.fintech.LancamentoDeDespesas.services.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaControllers {
	
	@Autowired
	private EmpresaService empresaService;
	
	@PostMapping
	public ResponseEntity<Object> cadastrarEmpresa(@RequestBody @Valid EmpresaForm empresaForm){
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.cadastrarEmpresa(empresaForm));
	}
	
	@GetMapping
	public List<Empresa> buscarEmpresasCadastrada(){
		return empresaService.buscarTodasEmpresa();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarEmpresaPorId(@PathVariable UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(empresaService.buscarPorId(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizarEmpresa(@PathVariable UUID id, @RequestBody @Valid EmpresaAtualizaForm atualizaForm){
		return ResponseEntity.status(HttpStatus.OK).body(empresaService.atualizarEmpresa(id, atualizaForm));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletarEmpresa(@PathVariable UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(empresaService.deletarPorId(id));
	}

}
