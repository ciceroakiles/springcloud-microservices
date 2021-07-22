package com.sample.shoppingcart.hashes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("cart")
public class Carrinho {
    
    @Id
    private Integer id;

    private List<Item> itens;

    public Carrinho() {
    }

    public Carrinho(Integer id) {
        this.id = id;
    }

    public List<Item> getItens() {
        if (itens == null) {
            itens = new ArrayList<>();
        }
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }    
}
