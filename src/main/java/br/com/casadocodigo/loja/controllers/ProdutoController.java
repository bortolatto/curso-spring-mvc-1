package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dominio.model.Produto;
import br.com.casadocodigo.loja.dominio.model.TipoPreco;
import br.com.casadocodigo.loja.infraestrutura.ProdutoDao;

@Controller
@RequestMapping("produtos")
public class ProdutoController {
	@Autowired
	private ProdutoDao dao;
	
	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String cadastrar(Produto produto) {
		System.out.println("Cadastrando produto " + produto);
		dao.gravar(produto);
		return "produtos/ok";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Produto> produtos = dao.getTodosProdutos();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos", produtos);
		
		return modelAndView;
	}
}
