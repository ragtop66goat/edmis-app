package com.ragtopmedia.school.services;

import com.ragtopmedia.school.dtos.SchoolAccountDTO;
import com.ragtopmedia.school.entities.Address;
import com.ragtopmedia.school.entities.Contact;
import com.ragtopmedia.school.entities.SchoolAccount;
import com.ragtopmedia.school.entities.Subject;
import com.ragtopmedia.school.repositories.SubjectRepository;
import com.ragtopmedia.school.repositories.AddressRepository;
import com.ragtopmedia.school.repositories.ContactRepository;
import com.ragtopmedia.school.repositories.SchoolAccountRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeacherServiceImpl implements TeacherService{

    private static final Logger log = LoggerFactory.getLogger(TeacherServiceImpl.class);
    private final ContactRepository contactRepository;
    private final SubjectRepository subjectRepository;
    private final SchoolAccountRepository schoolAccountRepository;
    private final AddressRepository addressRepository;

    TeacherServiceImpl(ContactRepository teacherRepository, SubjectRepository subjectRepository, SchoolAccountRepository schoolAccountRepository, AddressRepository addressRepository){
        this.contactRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
        this.schoolAccountRepository = schoolAccountRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Contact> getTeachers() {
        return contactRepository.findAll();
    }

    @Override
    @Transactional
    public SchoolAccountDTO createTeacher(SchoolAccount schoolAccount){

        if(schoolAccount.getAddresses() == null || schoolAccount.getContact() == null){
            throw new IllegalArgumentException("Address and Contact must not be null");
        }

        log.info("Creating account with contact: {}", schoolAccount.getContact());
        log.info("Creating accoutn with address: {}", schoolAccount.getAddresses());

        SchoolAccount sa = new SchoolAccount(2);
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
    @Transactional
    public SchoolAccountDTO assignSubjectToTeacher(Long teacherId, Long subjectId) {

        if(teacherId == null || subjectId == null){
            log.info("teacherId: {}, subjectId: {}", teacherId, subjectId);
            throw new IllegalArgumentException("Teacher id and Subject id can not be null");
        }
        SchoolAccount teacher = schoolAccountRepository.findById(teacherId)
                .orElseThrow(() -> new NoSuchElementException("No teacher found with id: " + teacherId));
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new NoSuchElementException("No subject found with id: " + subjectId));

       teacher.getSubjectsTaught().add(subject);
       subject.assignTeacher(teacher);

       schoolAccountRepository.save(teacher);
       subjectRepository.save(subject);

       Contact contact = contactRepository.findBySchoolAccount_Id(teacherId);
       List<Address> addresses = addressRepository.findAllBySchoolAccount_Id(teacherId);

        return SchoolAccountDTO.from(contact, addresses);

    }
}
