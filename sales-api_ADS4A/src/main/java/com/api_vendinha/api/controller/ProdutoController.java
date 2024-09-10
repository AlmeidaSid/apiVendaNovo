package com.api_vendinha.api.controller;


import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto;
import com.api_vendinha.api.domain.dtos.request.UserRequestDto;
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto;
import com.api_vendinha.api.domain.dtos.response.UserResponseDto;
import com.api_vendinha.api.domain.service.ProdutoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final ProdutoServiceInterface produtoService;

    @Autowired
    public ProdutoController(ProdutoServiceInterface produtoService) {
        this.produtoService = produtoService;
    }


    @PostMapping // Define que este método lida com requisições HTTP POST.
    public ProdutoResponseDto save(@RequestBody ProdutoRequestDto produtoRequestDto) {
        // Chama o serviço para salvar o usuário e retorna a resposta.
        System.out.println(produtoRequestDto);
        return produtoService.save(produtoRequestDto);
    }

    @GetMapping("/{id}")
    public ProdutoResponseDto getProdutos(
            @PathVariable Long id) {
        return produtoService.getProdutos(id);
    }
    @PutMapping("/{id}") // Define que este método lida com requisições HTTP PUT.
    public ProdutoResponseDto update(
            @PathVariable Long id,
            @RequestBody ProdutoRequestDto produtoRequestDto
    ) {
        // Chama o serviço para salvar o usuário e retorna a resposta.
        return produtoService.update(id, produtoRequestDto);
    }


}
