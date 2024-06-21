package com.example.learnspringboot.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="m_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long Id;

    @Column(name = "name", length = 20)
    private String Name;

    @Column (name="code", length = 20)
    private String Code;

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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
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
