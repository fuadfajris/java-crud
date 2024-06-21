package com.example.learnspringboot.repository;

import com.example.learnspringboot.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface TokenRepository extends JpaRepository<Token, Long> {
}
