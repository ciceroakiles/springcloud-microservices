package com.sample.shoppingcart.hashes;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("item")
public class Item {
    
    private int idProd;

    private int qtde;

    public int getIdProd() { return idProd; }
    public int getQtde() { return qtde; }

    public void setIdProd(int idProd) { this.idProd = idProd; }
    public void setQtde(int qtde) { this.qtde = qtde; }
}
