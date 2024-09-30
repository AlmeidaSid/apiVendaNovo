package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.Infrastructure.repository.ProdutoRepository;
import com.api_vendinha.api.Infrastructure.repository.UserRepository;
import com.api_vendinha.api.domain.dtos.request.UserRequestActiveDto;
import com.api_vendinha.api.domain.dtos.request.UserRequestDto;
import com.api_vendinha.api.domain.dtos.response.UserResponseDto;
import com.api_vendinha.api.domain.entities.Produto;
import com.api_vendinha.api.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Implementação do serviço de usuários.
 *
 * Esta classe fornece a implementação dos métodos definidos na interface UserServiceInterface,
 * lidando com a lógica de negócios relacionada aos usuários, como criar e atualizar usuários.
 */
@Service
public class UserServiceImpl implements UserServiceInterface {

    // Repositório para a persistência de dados de usuários.
    private final UserRepository userRepository;
    private final ProdutoRepository produtoRepository;

    /**
     * Construtor para injeção de dependência do UserRepository.
     *
     * @param userRepository O repositório de usuários a ser injetado.
     */
    @Autowired
    public UserServiceImpl(UserRepository userRepository, ProdutoRepository produtoRepository) {
        this.userRepository = userRepository;
        this.produtoRepository = produtoRepository;
    }

    /**
     * Salva um novo usuário ou atualiza um usuário existente.
     * <p>
     * Cria uma nova entidade User a partir dos dados fornecidos no UserRequestDto, persiste essa
     * entidade no banco de dados, e retorna um UserResponseDto com as informações do usuário salvo.
     *
     * @param userRequestDto DTO contendo os dados do usuário a ser salvo ou atualizado.
     * @return DTO com as informações do usuário salvo, incluindo o ID gerado e o nome.
     */
    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        // Cria uma nova instância de User.
        User user = new User();

        // Define o nome do usuário a partir do DTO.
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setActive(userRequestDto.getActive());
        user.setDocument(userRequestDto.getDocument());


        User savedUser = userRepository.save(user);

        List<Produto> produtos = userRequestDto.getProdutoRequestDtos().stream().map(dto ->{
            Produto produto = new Produto();
            produto.setUser(savedUser);
            produto.setName(dto.getName());
            produto.setQuantidade(dto.getQuantidade());
            produto.setPreco(dto.getPreco());
            produto.setIsActive(dto.getIsActive());
            return produto;



        }).collect(Collectors.toList());

        produtoRepository.saveAll(produtos);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(savedUser.getId());
        userResponseDto.setName(savedUser.getName());
        userResponseDto.setEmail(savedUser.getEmail());
        userResponseDto.setPassword(savedUser.getPassword());
        userResponseDto.setActive(savedUser.getActive());
        userResponseDto.setDocument(savedUser.getDocument());


        return userResponseDto;
    }

    @Override
    public UserResponseDto getUsers(Long id) {
        User existingUser = userRepository.findById(id).orElseThrow();

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(existingUser.getId());
        userResponseDto.setName(existingUser.getName());
        userResponseDto.setEmail(existingUser.getEmail());
        userResponseDto.setPassword(existingUser.getPassword());
        userResponseDto.setActive(existingUser.getActive());
        userResponseDto.setDocument(existingUser.getDocument());

        return userResponseDto;
    }

    @Override
    public UserResponseDto update(Long id, UserRequestDto userRequestDto) {
        // Get the previously created User
        User existingUser = userRepository.findById(id).orElseThrow();

        existingUser.setName(userRequestDto.getName());
        existingUser.setEmail(userRequestDto.getEmail());
        existingUser.setPassword(userRequestDto.getPassword());
        existingUser.setActive(userRequestDto.getActive());
        existingUser.setDocument(userRequestDto.getDocument());

        userRepository.save(existingUser);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(existingUser.getName());
        userResponseDto.setEmail(existingUser.getEmail());
        userResponseDto.setPassword(existingUser.getPassword());
        userResponseDto.setActive(existingUser.getActive());
        userResponseDto.setDocument(existingUser.getDocument());

        return userResponseDto;
    }

    @Override
    public UserResponseDto updateStatus(Long id, UserRequestActiveDto userRequestActiveDto) {
        User existingUser = userRepository.findById(id).orElseThrow();

        existingUser.setActive(userRequestActiveDto.getActive());

        userRepository.save(existingUser);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(existingUser.getId());
        userResponseDto.setName(existingUser.getName());
        userResponseDto.setEmail(existingUser.getEmail());
        userResponseDto.setPassword(existingUser.getPassword());
        userResponseDto.setActive(existingUser.getActive());
        userResponseDto.setDocument(existingUser.getDocument());

        return userResponseDto;
    }

}
