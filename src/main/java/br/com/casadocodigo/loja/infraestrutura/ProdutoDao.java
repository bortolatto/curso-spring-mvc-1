package br.com.casadocodigo.loja.infraestrutura;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.dominio.model.Produto;

@Repository
@Transactional
public class ProdutoDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Produto produto) {
		manager.persist(produto);
	}

	public List<Produto> getTodosProdutos() {
		return manager.createQuery("select p from Produto p",Produto.class).getResultList();
	}
}
