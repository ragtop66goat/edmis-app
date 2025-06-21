package com.ragtopmedia.school.services;

import com.ragtopmedia.school.dtos.SchoolAccountDTO;
import com.ragtopmedia.school.dtos.SubjectDTO;
import com.ragtopmedia.school.entities.Address;
import com.ragtopmedia.school.entities.Contact;
import com.ragtopmedia.school.entities.SchoolAccount;
import com.ragtopmedia.school.repositories.AddressRepository;
import com.ragtopmedia.school.repositories.ContactRepository;
import com.ragtopmedia.school.entities.Subject;
import com.ragtopmedia.school.repositories.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class SubjectServiceImpl implements SubjectService{

    private final SubjectRepository subjectRepository;
    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;
    private static final Logger log = LoggerFactory.getLogger(SubjectServiceImpl.class);


    public SubjectServiceImpl(SubjectRepository subjectRepository, ContactRepository contactRepository, AddressRepository addressRepository){
        this.subjectRepository = subjectRepository;
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public SubjectDTO enrollStudent(Long subjectId, Long studentId) {

        if(subjectId == null || studentId == null){
            log.info("subjectId: {}, studentId: {}", subjectId, studentId);
            throw new IllegalArgumentException("Subject id and Student id can not be null");
        }
        Contact student = contactRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("No student found with id: " + studentId));
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new NoSuchElementException("No subject found with id: " + subjectId));

        subject.enrollStudent(student);

        subjectRepository.save(subject);

        SubjectDTO subjectDTO = SubjectDTO.from(subject);

        return subjectDTO;

    }

    @Override
    public Set<SchoolAccountDTO> getTeacherForSubject(Long subjectId) {
        Set<SchoolAccountDTO> teachers = new HashSet<>();
        if(subjectId == null){
            throw new IllegalArgumentException("Subject id can not be null");
        }
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(()-> new NoSuchElementException("No subject found with id: " + subjectId));

        for( SchoolAccount teacher : subject.getTeachers()){
            Contact contact = contactRepository.findBySchoolAccount_Id(teacher.getId());
            List<Address> addresses = addressRepository.findAllBySchoolAccount_Id(teacher.getId());
            SchoolAccountDTO dto = SchoolAccountDTO.from(contact, addresses); 
            teachers.add(dto);
        }

        return teachers;
    }

    public List<SubjectDTO> getSubjects(){
        List<SubjectDTO> subjectDTOs = new ArrayList<>();
        List<Subject> subjects = subjectRepository.findAll();

        for(Subject subject : subjects){
            subjectDTOs.add(SubjectDTO.from(subject));
        }

        return subjectDTOs;
    }

    public SubjectDTO createSubject(Subject subject){
        subjectRepository.save(subject);

        return SubjectDTO.from(subject);
    }
}
