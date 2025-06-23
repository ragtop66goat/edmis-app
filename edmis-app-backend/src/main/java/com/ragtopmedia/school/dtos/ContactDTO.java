package com.ragtopmedia.school.dtos;

import com.ragtopmedia.school.entities.Contact;

import io.swagger.v3.oas.annotations.media.Schema;

public class ContactDTO {

    @Schema(description = "First name", example = "Shoto")
    private String firstName;

    @Schema(description = "Last name", example = "Aizawa")
    private String lastName;

    @Schema(description = "Middle name or alias", example = "Eraser Head")
    private String middleName;

    @Schema(description = "Email address", example = "saziawa@class1a.com")
    private String email;

    @Schema(description = "Mobile phone number", example = "123-456-7891")
    private String mobilePhone;

    @Schema(description = "Home phone number", example = "123-456-7890")
    private String homePhone;

    public static ContactDTO from(Contact contact){
        ContactDTO dto = new ContactDTO();
        dto.firstName = contact.getFirstName();
        dto.lastName = contact.getLastName();
        dto.middleName = contact.getMiddleName();
        dto.email = contact.getEmail();
        dto.mobilePhone = contact.getMobilePhone();
        dto.homePhone = contact.getHomePhone();
        return dto;
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
}
