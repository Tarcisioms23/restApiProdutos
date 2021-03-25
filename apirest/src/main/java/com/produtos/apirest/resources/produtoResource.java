package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins="*") // Posso colocar o dominio para acessar no swagger 	
public class produtoResource {

	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value = "Esse metodo Retorna uma lista de produtos.")
	public List<Produto> listaProduto(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Esse metodo busca um unico produto")
	public Produto BuscaProdutoUnico(@PathVariable(value="id") long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto")
	@ApiOperation(value = "Esse metodo salva um produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto")
	@ApiOperation(value = "Esse metodo deleta um produto")
	public String deleteProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
		return "Delete realizado com sucesso";
	}
	
	@PutMapping("/produto")
	@ApiOperation(value = "Esse metodo altera um produto")
	public Produto  alteraProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
