package com.sample.productcatalog.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "produto", type = "catalogo")
public class Produto {
    
    @Id
    private Long id;

    private String name;

    private int qtde;

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getQtde() { return qtde; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setQtde(int qtde) { this.qtde = qtde; }
}
