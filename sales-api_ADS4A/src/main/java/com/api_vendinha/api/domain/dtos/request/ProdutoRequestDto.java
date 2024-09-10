package com.api_vendinha.api.domain.dtos.request;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Gera automaticamente métodos getters, setters, toString, equals e hashCode.
@NoArgsConstructor
public class ProdutoRequestDto {

    private String name;
    private String quantidade;
    private String preco;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
