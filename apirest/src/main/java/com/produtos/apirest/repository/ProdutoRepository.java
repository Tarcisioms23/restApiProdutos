package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Produto findById(long id);
	
	
		//Pq que extender jpaRepository? Para fazer persistencias no banco de dados Insert delete etc....
}
