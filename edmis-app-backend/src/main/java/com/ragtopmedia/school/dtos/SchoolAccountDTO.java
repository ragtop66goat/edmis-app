package com.ragtopmedia.school.dtos;

import com.ragtopmedia.school.entities.Address;
import com.ragtopmedia.school.entities.Contact;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

public class SchoolAccountDTO {

    @Schema(description = "The teacher's contact info")
    private ContactDTO contact;

    @Schema(description = "List of addresses associated with the teacher")
    private List<AddressDTO> addresses;

    public static SchoolAccountDTO from(Contact contact, List<Address> addresses){
        SchoolAccountDTO dto = new SchoolAccountDTO();
        List<AddressDTO> addressDTOs = new ArrayList<>();
        dto.contact = ContactDTO.from(contact);
        for(Address address : addresses){
          new AddressDTO();
          addressDTOs.add(AddressDTO.from(address));
        }

        dto.addresses = addressDTOs;

        return dto;
    }

    public void setContact(Contact contact){
        this.contact = ContactDTO.from(contact);
    }

    public void setAddresses(List<AddressDTO> addressDTOs){
        this.addresses = addressDTOs;
    }

    public ContactDTO getContact(){
        return contact;
    }

    public List<AddressDTO> getAddresses(){
        return addresses;
    }
}
