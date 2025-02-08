package com.ragtopmedia.school.entities;

import com.ragtopmedia.school.enums.Role;

import javax.persistence.*;

@Entity
public class SchoolAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "role")
    private int roleId;

    public SchoolAccount(){};

    private SchoolAccount(Builder builder){
        this.roleId = builder. roleId;
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

    public static class Builder{
        private int roleId;

        public Builder roleId(int roleId){
            this.roleId = roleId;
            return this;
        }

        public SchoolAccount build(){
            return new SchoolAccount(this);
        }
    }
}
