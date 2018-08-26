package br.com.glauco.conta.service;

import java.math.BigDecimal;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.glauco.conta.model.Conta;
import br.com.glauco.conta.model.RegrasAtraso;
import br.com.glauco.conta.repository.ContaRepository;
import br.com.glauco.conta.repository.RegrasAtrasoRepository;

@Service("contaService")
public class ContaService {
	
	private final ContaRepository contaRepository;
	private final RegrasAtrasoRepository regrasRepository;

    @Autowired 
    public ContaService(ContaRepository contaRepository, RegrasAtrasoRepository regrasRepository){
        this.contaRepository = contaRepository;
        this.regrasRepository = regrasRepository;
    }
    
    public void salvarConta(Conta conta){
    	
    	if(conta.getDataPagamento().isAfter(conta.getDataVencimento())) {
    		conta.setDiasAtraso(Period.between(conta.getDataVencimento(), conta.getDataPagamento()).getDays());
    		conta.setValorCorrigido(calculaAtraso(conta));
    	}else {
    		conta.setDiasAtraso(0);
    		conta.setValorCorrigido(conta.getValorOriginal());
    	}
        contaRepository.save(conta);
    }
    
    public Conta buscarConta(Long id) {
    	return contaRepository.findById(id);
    }
    
    public List<Conta> listarContas(){
    	return contaRepository.findAll();
    }
    
    public RegrasAtraso buscarRegras(Integer diasAtraso) {
    	if(diasAtraso > 6) {
    		diasAtraso = 6;
    	}
    	return regrasRepository.findByDiasAtraso(diasAtraso);
    }
    
    public void salvarRegras(RegrasAtraso regras) {
    	regrasRepository.save(regras);
    }
    
    public BigDecimal calculaAtraso(Conta conta) {
    	RegrasAtraso r = buscarRegras(conta.getDiasAtraso());
    	BigDecimal multa = conta.getValorOriginal().multiply(new BigDecimal(r.getMulta()/100));
    	BigDecimal juros = conta.getValorOriginal().multiply(new BigDecimal(r.getJurosDia()/100*conta.getDiasAtraso()));
    	return conta.getValorOriginal().add(multa).add(juros);
    	
    }

}
