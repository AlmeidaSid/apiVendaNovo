package com.api_vendinha.api.domain.service;


import com.api_vendinha.api.Infrastructure.repository.ProdutoRepository;
import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto;
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto;
import com.api_vendinha.api.domain.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoServiceInterface {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoResponseDto save(ProdutoRequestDto produtoRequestDto) {
        // Cria uma nova instância de User.
        Produto produto = new Produto();

        // Define o nome do usuário a partir do DTO.
        produto.setName(produtoRequestDto.getName());
        produto.setQuantidade(produtoRequestDto.getQuantidade());
        produto.setPreco(produtoRequestDto.getPreco());


        // Salva o usuário no banco de dados e obtém a entidade persistida com o ID gerado.
        Produto savedProduto = produtoRepository.save(produto);

        // Cria um DTO de resposta com as informações do usuário salvo.
        ProdutoResponseDto produtoResponseDto = new ProdutoResponseDto();
        ProdutoResponseDto.setId(savedProduto.getId());
        ProdutoResponseDto.setName(savedProduto.getName());
        ProdutoResponseDto.setQuantidade(savedProduto.setQuantidade());
        ProdutoResponseDto.setPreco(savedProduto.setPreco());


        // Retorna o DTO com as informações do usuário salvo.
        return produtoResponseDto;
    }

    @Override
    public ProdutoResponseDto getProdutos(Long id) {
        Produto existingProduto = produtoRepository.findById(id).orElseThrow();

        ProdutoResponseDto produtoResponseDto = new ProdutoResponseDto();
        ProdutoResponseDto.setId(existingProduto.getId());
        ProdutoResponseDto.setName(existingProduto.getName());
        ProdutoResponseDto.setQuantidade(existingProduto.getQuantidade());
        ProdutoResponseDto.setPreco(existingProduto.getPreco());


        return produtoResponseDto;
    }

    @Override
    public ProdutoResponseDto update(Long id, ProdutoRequestDto produtoRequestDto) {
        // Get the previously created User
        Produto existingProduto = produtoRepository.findById(id).orElseThrow();

        existingProduto.setName(produtoRequestDto.getName());
        existingProduto.setQuantidade(produtoRequestDto.getQuantidade());
        existingProduto.setPreco(produtoRequestDto.getPreco());


        produtoRepository.save(existingProduto);

        ProdutoResponseDto produtoResponseDto = new ProdutoResponseDto();
        produtoResponseDto.setName(existingProduto.getName());
        produtoResponseDto.setQuantidade(existingProduto.getQuantidade());
        produtoResponseDto.setPreco(existingProduto.getPreco());

        return produtoResponseDto;
    }

}
