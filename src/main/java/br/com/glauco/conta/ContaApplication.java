package br.com.glauco.conta;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.glauco.conta.controller.ContaController;
import br.com.glauco.conta.model.Conta;
import br.com.glauco.conta.model.RegrasAtraso;
import br.com.glauco.conta.repository.ContaRepository;
import br.com.glauco.conta.repository.RegrasAtrasoRepository;
import br.com.glauco.conta.service.ContaService;

@SpringBootApplication
@EntityScan(basePackageClasses = Conta.class)
@ComponentScan(basePackageClasses = {ContaController.class, ContaService.class})
@EnableJpaRepositories(basePackageClasses = ContaRepository.class)
public class ContaApplication {
	
	@Autowired
	private RegrasAtrasoRepository regrasRepository;

	public static void main(String[] args) {
		SpringApplication.run(ContaApplication.class, args);
	}
	
	@Bean
	InitializingBean initData() {
	    return () -> {
	        regrasRepository.save(new RegrasAtraso(1, 2.0, 0.1));
	        regrasRepository.save(new RegrasAtraso(2, 2.0, 0.1));
			regrasRepository.save(new RegrasAtraso(3, 2.0, 0.1));
			regrasRepository.save(new RegrasAtraso(4, 3.0, 0.2));
			regrasRepository.save(new RegrasAtraso(5, 3.0, 0.2));
			regrasRepository.save(new RegrasAtraso(6, 5.0, 0.3));
	      };
	   }
	
}
