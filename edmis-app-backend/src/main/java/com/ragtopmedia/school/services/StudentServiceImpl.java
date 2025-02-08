package com.ragtopmedia.school.services;

import com.ragtopmedia.school.dtos.SchoolAccountDTO;
import com.ragtopmedia.school.entities.Address;
import com.ragtopmedia.school.entities.Contact;
import com.ragtopmedia.school.entities.SchoolAccount;
import com.ragtopmedia.school.repositories.AddressRepository;
import com.ragtopmedia.school.repositories.ContactRepository;
import com.ragtopmedia.school.repositories.SchoolAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    private AddressRepository addressRepository;
    private ContactRepository contactRepository;
    private SchoolAccountRepository schoolAccountRepository;

    public StudentServiceImpl(AddressRepository addressRepository, ContactRepository contactRepository, SchoolAccountRepository schoolAccountRepository){
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
        this.schoolAccountRepository = schoolAccountRepository;
    }

    @Override
    @Transactional
    public SchoolAccountDTO createStudent(SchoolAccountDTO schoolAccount) {

        if(schoolAccount.getAddresses() == null || schoolAccount.getContact() == null){
            throw new IllegalArgumentException("Address and Contact must not be null");
        }

        log.info("Creating account with contact: {}", schoolAccount.getContact());
        log.info("Creating account with address: {}", schoolAccount.getAddresses());

        SchoolAccount newSchoolAccount = new SchoolAccount.Builder()
                .roleId(1)
                .build();
        schoolAccountRepository.save(newSchoolAccount);

        List<Address> addresses = schoolAccount.getAddresses();
        for(Address address : addresses){
            address.setSchoolAccountId(newSchoolAccount.getId());
            addressRepository.save(address);
        }

        Contact contact = contactRepository.save(schoolAccount.getContact());
        contact.setSchoolAccountId(newSchoolAccount.getId());
        contactRepository.save(contact);

        return schoolAccount;
    }
}
