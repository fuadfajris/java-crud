package com.example.learnspringboot.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="m_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long Id;

    @Column(name = "biodata_id")
    private Long Biodata_Id;

    @OneToOne
    @JoinColumn(name="biodata_id", insertable = false, updatable = false)
    public Biodata biodata;

    @Column(name = "role_id")
    private Long Role_Id;

    @OneToOne
    @JoinColumn(name="role_id", insertable = false, updatable = false)
    public Role role;

    @Column(name="email", length=100)
    private String Email;

    @Column(name="password", length=255)
    private String Password;

    @Column(name="login_attempt")
    private int Login_Attempt;

    @Column(name="is_locked")
    private boolean Is_Locked;

    @Column(name="last_login")
    private LocalDateTime Last_Login;

    @Column(name="created_by")
    private Long Create_By  = (long) 1;

    @CreationTimestamp
    @Column(name="created_on")
    private LocalDateTime Created_On;

    @Column(name="modified_by")
    private Long Modified_By  = (long) 1;

    @UpdateTimestamp
    @Column(name="modified_on")
    private LocalDateTime Modified_On;

    @Column(name="deleted_by")
    private Long Deleted_By  = (long) 1;

    @Column(name="deleted_on")
    private LocalDateTime Deleted_On;

    @Column(name="is_deleted")
    private boolean Is_Deleted;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getBiodata_Id() {
        return Biodata_Id;
    }

    public void setBiodata_Id(Long biodata_Id) {
        Biodata_Id = biodata_Id;
    }

    public Biodata getBiodata() {
        return biodata;
    }

    public void setBiodata(Biodata biodata) {
        this.biodata = biodata;
    }

    public Long getRole_Id() {
        return Role_Id;
    }

    public void setRole_Id(Long role_Id) {
        Role_Id = role_Id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getLogin_Attempt() {
        return Login_Attempt;
    }

    public void setLogin_Attempt(int login_Attempt) {
        Login_Attempt = login_Attempt;
    }

    public boolean isIs_Locked() {
        return Is_Locked;
    }

    public void setIs_Locked(boolean is_Locked) {
        Is_Locked = is_Locked;
    }

    public LocalDateTime getLast_Login() {
        return Last_Login;
    }

    public void setLast_Login(LocalDateTime last_Login) {
        Last_Login = last_Login;
    }

    public Long getCreate_By() {
        return Create_By;
    }

    public void setCreate_By(Long create_By) {
        Create_By = create_By;
    }

    public LocalDateTime getCreated_On() {
        return Created_On;
    }

    public void setCreated_On(LocalDateTime created_On) {
        Created_On = created_On;
    }

    public Long getModified_By() {
        return Modified_By;
    }

    public void setModified_By(Long modified_By) {
        Modified_By = modified_By;
    }

    public LocalDateTime getModified_On() {
        return Modified_On;
    }

    public void setModified_On(LocalDateTime modified_On) {
        Modified_On = modified_On;
    }

    public Long getDeleted_By() {
        return Deleted_By;
    }

    public void setDeleted_By(Long deleted_By) {
        Deleted_By = deleted_By;
    }

    public LocalDateTime getDeleted_On() {
        return Deleted_On;
    }

    public void setDeleted_On(LocalDateTime deleted_On) {
        Deleted_On = deleted_On;
    }

    public boolean isIs_Deleted() {
        return Is_Deleted;
    }

    public void setIs_Deleted(boolean is_Deleted) {
        Is_Deleted = is_Deleted;
    }
}

