package br.com.glauco.conta.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "valorOriginal", nullable = false)
	private BigDecimal valorOriginal;
	
	@Column(name = "valorCorrigido", nullable = false)
	private BigDecimal valorCorrigido;
	
	@Column(name = "dataVencimento", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataVencimento;
	
	@Column(name = "dataPagamento", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPagamento;
	
	@Column(name = "diasAtraso", nullable = false)
	private Integer diasAtraso;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorOriginal() {
		return valorOriginal;
	}

	public void setValorOriginal(BigDecimal valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public BigDecimal getValorCorrigido() {
		return valorCorrigido;
	}

	public void setValorCorrigido(BigDecimal valorCorrigido) {
		this.valorCorrigido = valorCorrigido;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Integer getDiasAtraso() {
		return diasAtraso;
	}

	public void setDiasAtraso(Integer diasAtraso) {
		this.diasAtraso = diasAtraso;
	}

	public Long getId() {
		return id;
	}
	
	

}
