package com.ragtopmedia.school.dtos;

import com.ragtopmedia.school.entities.Address;
import com.ragtopmedia.school.entities.Contact;

import java.util.ArrayList;
import java.util.List;

public class SchoolAccountDTO {
    private ContactDTO contact;
    private List<AddressDTO> addressDTOs;

    public static SchoolAccountDTO from(Contact contact, List<Address> addresses){
        SchoolAccountDTO dto = new SchoolAccountDTO();
        List<AddressDTO> addressDTOs = new ArrayList<>();
        dto.contact = ContactDTO.from(contact);
        for(Address address : addresses){
          new AddressDTO();
          addressDTOs.add(AddressDTO.from(address));
        }

        dto.addressDTOs = addressDTOs;

        return dto;
    }

    public void setContact(Contact contact){
        this.contact = ContactDTO.from(contact);
    }

    public void setAddresses(List<AddressDTO> addressDTOs){
        this.addressDTOs = addressDTOs;
    }

    public ContactDTO getContact(){
        return contact;
    }

    public List<AddressDTO> getAddresses(){
        return addressDTOs;
    }
}
