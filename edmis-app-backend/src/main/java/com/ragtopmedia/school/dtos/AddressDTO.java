package com.ragtopmedia.school.dtos;

import com.ragtopmedia.school.entities.Address;

import io.swagger.v3.oas.annotations.media.Schema;

public class AddressDTO {

     @Schema(description = "Name in care of", example = "Shoto")
    private String inCareOfName;

    @Schema(description = "Street address", example = "123 Mulberry St")
    private String streetAddress;

    @Schema(description = "Apartment number", example = "435")
    private String aptNumber;

    @Schema(description = "City", example = "ketsu")
    private String city;

    @Schema(description = "State", example = "UT")
    private String state;

    @Schema(description = "Postal code", example = "84111")
    private String postalCode;

    @Schema(description = "Country", example = "US")
    private String country;

    @Schema(description = "Type of address", example = "mailing")
    private String addressType;;

    public static AddressDTO from(Address address){
        AddressDTO dto = new AddressDTO();
        dto.setInCareOfName(address.getInCareOfName());
        dto.setStreetAddress(address.getStreetAddress());
        dto.setAptNumber(address.getAptNumber());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setCountry(address.getCountry());
        dto.setAddressType(address.getAddressType());
        return dto;
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
