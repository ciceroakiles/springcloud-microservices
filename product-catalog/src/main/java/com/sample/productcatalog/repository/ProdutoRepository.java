package com.sample.productcatalog.repository;

import com.sample.productcatalog.entity.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    
}
