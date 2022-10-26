package com.fintech.LancamentoDeDespesas.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fintech.LancamentoDeDespesas.models.Lancamento;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LancamentoDto {
	
	private String tipo;
	private String descricao;
	private Double valor;
	private Boolean pago;
	private LocalDate data_pagamento;
	private LocalDate data_vencimento;
	
	
	public LancamentoDto(Lancamento lancamento) {
		this.tipo = lancamento.getTipo();
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
	
	
//	public static Page<LancamentoDto> converter(Page<Lancamento> lancamento) {
//        return lancamento.map(LancamentoDto::new);
//    }
	
	public static List<LancamentoDto> converter(List<Lancamento> lancamento) {
        return lancamento.stream().map(LancamentoDto::new).collect(Collectors.toList());
    }
	
	
}
