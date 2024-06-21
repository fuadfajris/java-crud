package com.example.learnspringboot.repository;

import com.example.learnspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.Map;

@EnableJpaRepositories
public interface RegistrationRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT mu.email FROM m_user mu WHERE email = :email", nativeQuery = true)
    Map<String, Object> getDataUser(@RequestBody String email);

    @Query(value = "SELECT mu.email FROM m_user mu WHERE email = :email AND is_expired = false AND expired_on >= :now)", nativeQuery = true)
    Map<String, Object> getDataUser2(@RequestBody String email, LocalDateTime now);

    @Query(value = "INSERT INTO t_token(" +
            "email, expired_on, token, used_for, user_id, is_expired" +
            ") VALUES (:email, :expired, :otp, :usefor, '1', false)", nativeQuery = true)
    Map<String, Object> insertToken(@RequestBody String email, String otp, LocalDateTime expired, String usefor);


}
