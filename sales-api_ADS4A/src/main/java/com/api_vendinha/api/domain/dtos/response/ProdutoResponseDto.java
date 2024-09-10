package com.api_vendinha.api.domain.dtos.response;

import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    public class ProdutoResponseDto {
        private Long id;
        private String name;
        private String quantidade;
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
