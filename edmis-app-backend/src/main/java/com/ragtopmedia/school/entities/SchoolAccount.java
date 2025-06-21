package com.ragtopmedia.school.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class SchoolAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "role")
    private int roleId;

    @ManyToMany
    @JoinTable(
        name = "subjects_taught",
        joinColumns = @JoinColumn(name = "school_account_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjectsTaught = new HashSet<>();

    @OneToMany(mappedBy = "schoolAccount")
    private List<Address> addresses;

    @OneToOne(mappedBy = "schoolAccount")
    private Contact contact;

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

    public Set<Subject> getSubjectsTaught() {
        return subjectsTaught;
    }

    public void setSubjectsTaught(Set<Subject> subjectsTaught) {
        this.subjectsTaught = subjectsTaught;
    }

    public Contact getContact(){
        return this.contact;
    }

    public List<Address> getAddresses(){
        return this.addresses;
    }
}
