package com.ragtopmedia.school.dtos;

public class AddressDTO {

    private long id;
    private String inCareOfName;
    private String streetAddress;
    private String aptNumber;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String addressType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
