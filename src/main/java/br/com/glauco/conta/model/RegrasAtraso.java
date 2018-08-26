package br.com.glauco.conta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RegrasAtraso {
	
	public RegrasAtraso() {
		// TODO Auto-generated constructor stub
	}
	
	public RegrasAtraso(Integer diasAtraso, Double multa, Double juros) {
		this.diasAtraso = diasAtraso;
		this.multa = multa;
		this.jurosDia = juros;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "diasAtraso")
	private Integer diasAtraso;
	
	@Column(name = "multa")
	private Double multa;
	
	@Column(name = "jurosDia")
	private Double jurosDia;

	public Integer getDiasAtraso() {
		return diasAtraso;
	}

	public Double getMulta() {
		return multa;
	}

	public Double getJurosDia() {
		return jurosDia;
	}

	public void setDiasAtraso(Integer diasAtraso) {
		this.diasAtraso = diasAtraso;
	}

	public void setMulta(Double multa) {
		this.multa = multa;
	}

	public void setJurosDia(Double jurosDia) {
		this.jurosDia = jurosDia;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
