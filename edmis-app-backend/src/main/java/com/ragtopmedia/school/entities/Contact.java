package com.ragtopmedia.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "contact_info")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "home_phone")
    private String homePhone;
    @ManyToOne
    @JoinColumn(name = "school_account_id", nullable = false)
    @JsonIgnore
    SchoolAccount schoolAccount;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getMiddleName() {

        return middleName;
    }

    public void setMiddleName(String middleName) {

        this.middleName = middleName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getMobilePhone() {

        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {

        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {

        return homePhone;
    }

    public void setHomePhone(String homePhone) {

        this.homePhone = homePhone;
    }

    public Long getSchoolAccountId() {
        return schoolAccount.getId();
    }

    public void setSchoolAccount(SchoolAccount schoolAccount){
        this.schoolAccount = schoolAccount;
    }

    @Override
    public String toString() {
        return "Contact{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", email='" + email + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                '}';
    }
}
