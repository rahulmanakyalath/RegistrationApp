package com.example.RegistrationApp.Entity;

import javax.persistence.*;

@Entity(name = "usertbl")
@Table(name = "usertbl", schema = "public")
public class UserDetailsTbl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "emailid")
    private String emailId;
    @Column(name = "password")
    private String password;
    @Column(name = "gender")
    private String gender;

    public UserDetailsTbl() {
    }

    public UserDetailsTbl(Long id, String name, String emailId, String password, String gender) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserDetailsTbl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

}
