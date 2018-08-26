package br.com.glauco.conta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.glauco.conta.model.Conta;
import br.com.glauco.conta.service.ContaService;

@Controller
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String salvarConta(Conta conta) {
		contaService.salvarConta(conta);
		return "index";
	}
	
	@RequestMapping("lista")
	public ModelAndView listarContas() {
		List<Conta> contas = contaService.listarContas();
		ModelAndView modelAndView = new ModelAndView("lista");
		modelAndView.addObject("contas", contas);
		return modelAndView;
	}

}
