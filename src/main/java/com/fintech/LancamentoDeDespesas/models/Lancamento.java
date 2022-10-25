package com.fintech.LancamentoDeDespesas.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@FlywayDataSource
@Entity
@Table(name = "LANCAMENTO_DE_DESPESAS")
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "UUIDGenerator")
	@SequenceGenerator(name = "SEQ_LANCAMENTO_DE_DESPESAS", sequenceName = "SEQ_LANCAMENTO_DE_DESPESAS", allocationSize = 1)
	private UUID id;

	@Version
	private Long jversion;

	@Column(nullable = false, length = 20)
	private String tipo;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa", referencedColumnName = "id")
	private Empresa idEmpresa;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false, length = 100)
	private Double valor;

	@Column(nullable = false)
	private Boolean pago;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(name = "data_pagamento")
	private LocalDate data_pagamento;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(name = "data_vencimento")
	private LocalDate data_vencimento;
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Long getJversion() {
		return jversion;
	}

	public void setJversion(Long jversion) {
		this.jversion = jversion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Empresa getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Empresa idEmpresa) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lancamento [id=" + id + ", jversion=" + jversion + ", tipo=" + tipo + ", idEmpresa=" + idEmpresa
				+ ", descricao=" + descricao + ", valor=" + valor + ", pago=" + pago + ", data_pagamento="
				+ data_pagamento + ", data_vencimento=" + data_vencimento + "]";
	}
}
