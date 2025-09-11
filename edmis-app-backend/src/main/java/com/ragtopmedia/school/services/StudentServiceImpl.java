package com.ragtopmedia.school.services;

import com.ragtopmedia.school.dtos.AddressDTO;
import com.ragtopmedia.school.dtos.SchoolAccountDTO;
import com.ragtopmedia.school.entities.Address;
import com.ragtopmedia.school.entities.Contact;
import com.ragtopmedia.school.entities.SchoolAccount;
import com.ragtopmedia.school.enums.RoleEnum;
import com.ragtopmedia.school.repositories.AddressRepository;
import com.ragtopmedia.school.repositories.ContactRepository;
import com.ragtopmedia.school.repositories.SchoolAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentServiceImpl implements StudentService{

    private final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;
    private final SchoolAccountRepository schoolAccountRepository;

    public StudentServiceImpl(AddressRepository addressRepository, ContactRepository contactRepository, SchoolAccountRepository schoolAccountRepository){
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
        this.schoolAccountRepository = schoolAccountRepository;
    }

    @Override
    @Transactional
    public SchoolAccountDTO createStudent(SchoolAccount schoolAccount) {

        if(schoolAccount.getAddresses() == null || schoolAccount.getContact() == null){
            throw new IllegalArgumentException("Address and Contact must not be null");
        }

        log.info("Creating account with contact: {}", schoolAccount.getContact());
        log.info("Creating account with address: {}", schoolAccount.getAddresses());

        SchoolAccount sa = new SchoolAccount(1);
        schoolAccountRepository.save(sa);

        for(Address address : schoolAccount.getAddresses()){
            address.setSchoolAccount(sa);
            addressRepository.save(address);
        }

        Contact contact = schoolAccount.getContact();
        contact.setSchoolAccount(sa);
        contactRepository.save(contact);

        return SchoolAccountDTO.from(contact, schoolAccount.getAddresses());
    }

    @Override
    public List<SchoolAccountDTO> getStudents(){
        List<SchoolAccountDTO> students = new ArrayList<>();
        List<SchoolAccount> results = schoolAccountRepository.findAllByRoleId(RoleEnum.STUDENT_ROLE.getId());

        for(SchoolAccount item : results){
            students.add(SchoolAccountDTO.from(item.getContact(), item.getAddresses()));
        }

        return students;
    }
}
