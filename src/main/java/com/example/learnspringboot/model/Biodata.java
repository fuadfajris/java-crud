package com.example.learnspringboot.model;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name="m_biodata")
public class Biodata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
    @Column(name = "id")
    private Long Id;

    @Column(name="fullname", length=255)
    private String FullName;

    @Column(name="mobile_phone", length=15)
    private String Mobile_Phone;

    @Column(name="image", length=40)
    private Blob Image;

    @Column(name="image_path", length=40)
    private String Image_Path;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getMobile_Phone() {
        return Mobile_Phone;
    }

    public void setMobile_Phone(String mobile_Phone) {
        Mobile_Phone = mobile_Phone;
    }

    public Blob getImage() {
        return Image;
    }

    public void setImage(Blob image) {
        Image = image;
    }

    public String getImage_Path() {
        return Image_Path;
    }

    public void setImage_Path(String image_Path) {
        Image_Path = image_Path;
    }

}