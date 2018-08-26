package br.com.glauco.conta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.glauco.conta.model.Conta;
import br.com.glauco.conta.model.RegrasAtraso;
import br.com.glauco.conta.service.ContaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContaApplicationTests {
	
	@Autowired
	private ContaService contaService;
	
	@Test
	public void insereConta() {
		Conta c = criaConta();
		contaService.salvarConta(c);
		assertNotNull(c.getId());
	}
	
	@Test (expected = DataIntegrityViolationException.class)
	public void insereContaIncompleta() {
		Conta c = criaConta();
		c.setNome(null);
		contaService.salvarConta(c);
	}
	
	@Test 
	public void buscaConta() {
		Conta c = criaConta();
		c.setNome("Conta de Gas");
		contaService.salvarConta(c);
		Conta c2 = contaService.buscarConta(c.getId());
		assertEquals(c2.getNome(), "Conta de Gas");
	}
	
	@Test
	public void testaCarregamentoRegras() {
		RegrasAtraso r1 = contaService.buscarRegras(1);
		assertNotNull(r1);
	}
	
	@Test
	public void validaCalculos() {
		Conta c = criaConta();
		c.setValorCorrigido(contaService.calculaAtraso(c));
		assertEquals(1068, c.getValorCorrigido().longValue());
	}
	
	private Conta criaConta() {
		Conta c = new Conta();
		c.setDataPagamento(LocalDate.of(2018, Month.AUGUST, 26));
		c.setDataVencimento(LocalDate.of(2018, Month.AUGUST, 20));
		Period p = Period.between(c.getDataVencimento(), c.getDataPagamento()); 
		c.setDiasAtraso(p.getDays());
		c.setNome("Conta de Luz");
		c.setValorOriginal(new BigDecimal(1000));
		c.setValorCorrigido(new BigDecimal(1000));
		return c;
	}
	
	

}
