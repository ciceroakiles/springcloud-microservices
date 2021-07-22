package com.sample.shoppingcart.repository;

import com.sample.shoppingcart.hashes.Carrinho;
import org.springframework.data.repository.CrudRepository;

public interface CarrinhoRepository extends CrudRepository<Carrinho, Integer> {
    
    Carrinho findById(int idCliente);
}
