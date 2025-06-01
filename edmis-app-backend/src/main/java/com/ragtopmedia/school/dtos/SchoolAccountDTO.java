package com.ragtopmedia.school.dtos;

import com.ragtopmedia.school.entities.Address;
import com.ragtopmedia.school.entities.Contact;

import java.util.List;

public class SchoolAccountDTO {
    private Contact contact;
    private List<Address> addresses;

    public void setContact(Contact contact){
        this.contact = contact;
    }

    public void setAddresses(List<Address> addresses){
        this.addresses = addresses;
    }

    public Contact getContact(){
        return contact;
    }

    public List<Address> getAddresses(){
        return addresses;
    }
}
