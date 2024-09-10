package com.api_vendinha.api.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produtos") // Especifica o nome da tabela no banco de dados que será associada a esta entidade.
@NoArgsConstructor // Gera um construtor sem argumentos, necessário para a criação de instâncias da entidade pelo JPA.
@AllArgsConstructor
// Gera um construtor que aceita argumentos para todos os campos, útil para criar instâncias com todos os dados.
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor do ID será gerado automaticamente pelo banco de dados (auto-incremento).
    private Long id;

    @Column(nullable = false) // Especifica que a coluna no banco de dados não pode ser nula.
    private String name;

    @Column(name = "quantidade", nullable = false)
    private String quantidade;

    @Column(name = "preco", nullable = false)
    private String preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

