package com.ironhack.bank.models;

import com.ironhack.bank.enums.AccountStatus;
import com.ironhack.bank.enums.Roles;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Roles role;

    public User() {
    }

    public User(Integer id, String name, String userName, String password, Roles role) {
        this.setId(id);
        this.setName(name);
        this.setUserName(userName);
        this.setPassword(password);
        this.setRole(role);
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}