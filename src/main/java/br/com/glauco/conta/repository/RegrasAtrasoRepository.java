package br.com.glauco.conta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.glauco.conta.model.RegrasAtraso;

public interface RegrasAtrasoRepository extends JpaRepository<RegrasAtraso, Integer> {
	
	RegrasAtraso findByDiasAtraso (Integer diasAtraso);

}
