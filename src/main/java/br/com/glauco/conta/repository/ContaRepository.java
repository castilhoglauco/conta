package br.com.glauco.conta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.glauco.conta.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{
	
	List<Conta> findByNome (String nome);
	
	Conta findById(Long id);

}
