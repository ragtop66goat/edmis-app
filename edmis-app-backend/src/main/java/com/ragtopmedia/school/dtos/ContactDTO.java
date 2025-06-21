package com.ragtopmedia.school.dtos;

import com.ragtopmedia.school.entities.Contact;

public class ContactDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String mobilePhone;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
