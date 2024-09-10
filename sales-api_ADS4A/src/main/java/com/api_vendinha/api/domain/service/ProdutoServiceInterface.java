package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto;
import com.api_vendinha.api.domain.dtos.request.UserRequestActiveDto;
import com.api_vendinha.api.domain.dtos.request.UserRequestDto;
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto;
import com.api_vendinha.api.domain.dtos.response.UserResponseDto;

public interface ProdutoServiceInterface {
    ProdutoResponseDto update(Long id, ProdutoRequestDto produtoRequestDto);
    ProdutoResponseDto getProdutos(Long id);
    ProdutoResponseDto save(ProdutoRequestDto produtoRequestDto);
}
