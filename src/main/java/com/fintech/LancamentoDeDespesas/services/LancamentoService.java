package com.fintech.LancamentoDeDespesas.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fintech.LancamentoDeDespesas.dto.LancamentoDto;
import com.fintech.LancamentoDeDespesas.forms.AtualizarForm;
import com.fintech.LancamentoDeDespesas.forms.LancamentoForm;
import com.fintech.LancamentoDeDespesas.models.Empresa;
import com.fintech.LancamentoDeDespesas.models.Lancamento;
import com.fintech.LancamentoDeDespesas.repository.EmpresaRepository;
import com.fintech.LancamentoDeDespesas.repository.LancamentoRepository;

/**
 * @author willian.souza
 * 
 * A classe lancamentoService contem toda a regra de negocio da API
 */
@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	
	
	@Transactional
	public LancamentoForm converter(LancamentoForm lancamentoForm) {
		Optional<Empresa> idEmpresa = buscarEmpresaPorId(lancamentoForm.getIdEmpresa());
		if (!idEmpresa.isPresent()) {
			return null;
		}
		var lancamento = new Lancamento();
		BeanUtils.copyProperties(lancamentoForm, lancamento);
		lancamento.setIdEmpresa(idEmpresa.get());
		return new LancamentoForm(lancamentoRepository.save(lancamento));
	}
	
//	public List<Lancamento> buscarTodos() {
//		return lancamentoRepository.findAll();
//	}
	
	public List<Lancamento> buscarTodos(){
		return lancamentoRepository.findTodosLancamentos();
	}
	
	public Optional<Lancamento> buscarPorId(UUID id) {
		return lancamentoRepository.findById(id);
	}
	
	public Optional<Empresa> buscarEmpresaPorId(UUID idEmpresa) {
		return empresaRepository.findById(idEmpresa);
	}

	public ResponseEntity<Object> salvar(Lancamento lancamento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoRepository.save(lancamento));
	}

	@Transactional
	public AtualizarForm atualizarLancamento(UUID id, AtualizarForm form) {
		Optional<Lancamento> updateForm = buscarPorId(id);
		if (!updateForm.isPresent()) {
			return null;
		}
		var lancamento = updateForm.get();
		BeanUtils.copyProperties(form, lancamento);
		return new AtualizarForm(lancamentoRepository.save(lancamento));
	}

	public ResponseEntity<Object> deletarLancamento(UUID id) {
		Optional<Lancamento> deleteId = buscarPorId(id);
		if (!deleteId.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lançamento não encontrado!");
		}
		lancamentoRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Lançamento deletado com sucesso!");
	}
	
}
