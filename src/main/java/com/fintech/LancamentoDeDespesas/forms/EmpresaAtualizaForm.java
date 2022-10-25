package com.fintech.LancamentoDeDespesas.forms;

import javax.validation.constraints.NotBlank;

public class EmpresaAtualizaForm {

	@NotBlank
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	
}
