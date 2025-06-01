package com.ragtopmedia.school.entities;

import jakarta.persistence.*;

@Entity
public class SchoolAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "role")
    private int roleId;

    public SchoolAccount(){};

    public SchoolAccount(int roleId){
        this.roleId = roleId;
    }

    public int getRole() {
        return roleId;
    }

    public void setRole(int roleId) {
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }
}
