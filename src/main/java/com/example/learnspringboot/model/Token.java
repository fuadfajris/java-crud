package com.example.learnspringboot.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="t_token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long Id;

    @Column(name="email", length=100)
    private String Email;

    @Column(name="user_id")
    private Long User_Id;

    @ManyToOne
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    public User user;

    @Column(name="token", length=50)
    private String Token;

    @Column(name="expired_on")
    private LocalDateTime Expired_On;

    @Column(name="is_expired")
    private boolean is_expired ;

    @Column(name="used_for", length=20)
    private String Used_For;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Long getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(Long user_Id) {
        User_Id = user_Id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public LocalDateTime getExpired_On() {
        return Expired_On;
    }

    public void setExpired_On(LocalDateTime expired_On) {
        Expired_On = expired_On;
    }

    public boolean isIs_expired() {
        return is_expired;
    }

    public void setIs_expired(boolean is_expired) {
        this.is_expired = is_expired;
    }

    public String getUsed_For() {
        return Used_For;
    }

    public void setUsed_For(String used_For) {
        Used_For = used_For;
    }
}