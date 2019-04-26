package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.dominio.model.Produto;
import br.com.casadocodigo.loja.infraestrutura.ProdutoDao;

@Controller
public class ProdutoController {
	@Autowired
	private ProdutoDao dao;
	
	@RequestMapping("/produtos/form")
	public String form() {
		return "produtos/form";
	}
	
	@RequestMapping("/produtos")
	public String cadastrar(Produto produto) {
		System.out.println("Cadastrando produto " + produto);
		dao.gravar(produto);
		return "produtos/ok";
	}
}
