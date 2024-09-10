package com.api_vendinha.api.Infrastructure.repository;

import com.api_vendinha.api.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<User, Long> {

}
