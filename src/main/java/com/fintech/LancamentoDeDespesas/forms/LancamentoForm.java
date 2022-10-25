package com.fintech.LancamentoDeDespesas.forms;

import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fintech.LancamentoDeDespesas.models.Empresa;
import com.fintech.LancamentoDeDespesas.models.Lancamento;

/**
 * @author willian.souza
 * 
 * LancamentoForm tem os atributos enviado pelo front e repassado ao 
 * controller e depois para o service, para fazer o provessamento 
 * dessas informações no momento em que for salvar os dados.
 */
public class LancamentoForm {

	@NotBlank
	private String tipo;

	@NotNull
	private UUID idEmpresa;

	@NotBlank
	private String descricao;

	private Double valor;

	private Boolean pago;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate data_pagamento;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate data_vencimento;

	public LancamentoForm() {
	}

	public LancamentoForm(Lancamento lancamento) {
		this.tipo = lancamento.getTipo();
		this.idEmpresa = lancamento.getIdEmpresa().getId();
		this.descricao = lancamento.getDescricao();
		this.valor = lancamento.getValor();
		this.pago = lancamento.getPago();
		this.data_pagamento = lancamento.getData_pagamento();
		this.data_vencimento = lancamento.getData_vencimento();
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public UUID getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(UUID idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public LocalDate getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(LocalDate data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	public LocalDate getData_vencimento() {
		return data_vencimento;
	}

	public void setData_vencimento(LocalDate data_vencimento) {
		this.data_vencimento = data_vencimento;
	}

	
}
