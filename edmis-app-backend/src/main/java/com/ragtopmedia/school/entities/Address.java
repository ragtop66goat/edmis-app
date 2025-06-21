package com.ragtopmedia.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "in_care_of")
    private String inCareOfName;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "apt_no")
    private String aptNumber;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "country")
    private String country;
    @Column(name = "address_type")
    private String addressType;
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

    public String getInCareOfName() {
        return inCareOfName;
    }

    public void setInCareOfName(String inCareOfName) {
        this.inCareOfName = inCareOfName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(String aptNumber) {
        this.aptNumber = aptNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public Long getSchoolAccountId() {
        return schoolAccount.getId();
    }

    public void setSchoolAccount(SchoolAccount schoolAccount) {
        this.schoolAccount = schoolAccount;
    }

    @Override
    public String toString() {
        return "Address{" +
                ", inCareOfName='" + inCareOfName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", aptNumber='" + aptNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", addressType='" + addressType + '\'' +
                '}';
    }
}
