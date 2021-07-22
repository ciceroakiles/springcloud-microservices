package com.sample.shoppingcart.controller;

import com.sample.shoppingcart.hashes.Carrinho;
import com.sample.shoppingcart.hashes.Item;
import com.sample.shoppingcart.repository.CarrinhoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/carrinho")
public class CarrinhoController {
    
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    // POST
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Carrinho addItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        Optional<Carrinho> salvo = carrinhoRepository.findById(id);
        Carrinho carrinho;
        if (salvo.equals(Optional.empty())) {
            carrinho = new Carrinho(id);
        } else {
            carrinho = salvo.get();
        }
        carrinho.getItens().add(item);
        return carrinhoRepository.save(carrinho);
    }

    // GET
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Carrinho> findById(@PathVariable("id") Integer id) {
        return carrinhoRepository.findById(id);
    }

    // DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") Integer id) {
        carrinhoRepository.deleteById(id);
    }
}
