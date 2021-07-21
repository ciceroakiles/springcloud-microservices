package com.sample.productcatalog.controller;

import com.sample.productcatalog.entity.Produto;
import com.sample.productcatalog.repository.ProdutoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {
    
    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // POST
    @RequestMapping(method = RequestMethod.POST)
    public Produto criaProd(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    // GET
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Optional<Produto> findById(@PathVariable Long id) {
        return produtoRepository.findById(id);
    }
}
