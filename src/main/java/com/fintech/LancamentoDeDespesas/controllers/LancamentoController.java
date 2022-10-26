package com.fintech.LancamentoDeDespesas.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import com.fintech.LancamentoDeDespesas.dto.LancamentoDto;
import com.fintech.LancamentoDeDespesas.forms.AtualizarForm;
import com.fintech.LancamentoDeDespesas.forms.LancamentoForm;
import com.fintech.LancamentoDeDespesas.services.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoService lancamentoService;

	@PostMapping
	public ResponseEntity<Object> cadastrarLancamento(@RequestBody @Valid LancamentoForm lancamentoForm){
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoService.converter(lancamentoForm));
	}
	
	@GetMapping
	public Page<LancamentoDto> listaDeLancamentos(@PageableDefault( page = 0, size = 10) Pageable paginacao){
		return lancamentoService.buscarTodos(paginacao);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseEntity<LancamentoDto>> buscarLancamentoPorId(@PathVariable UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.lancamentoPorId(id));	
	}
	

	
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizarLancamento(@PathVariable UUID id, @RequestBody @Valid AtualizarForm form){
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.atualizarLancamento(id, form));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletarLancamento(@PathVariable UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.deletarLancamento(id));
	}
}
