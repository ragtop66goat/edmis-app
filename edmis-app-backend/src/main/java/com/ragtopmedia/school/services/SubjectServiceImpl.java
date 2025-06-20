package com.ragtopmedia.school.services;

import com.ragtopmedia.school.entities.Contact;
import com.ragtopmedia.school.entities.SchoolAccount;
import com.ragtopmedia.school.repositories.ContactRepository;
import com.ragtopmedia.school.entities.Subject;
import com.ragtopmedia.school.repositories.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class SubjectServiceImpl implements SubjectService{

    private final SubjectRepository subjectRepository;
    private final ContactRepository contactRepository;
    private static final Logger log = LoggerFactory.getLogger(SubjectServiceImpl.class);


    public SubjectServiceImpl(SubjectRepository subjectRepository, ContactRepository contactRepository){
        this.subjectRepository = subjectRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public Subject enrollStudent(Long subjectId, Long studentId) {

        if(subjectId == null || studentId == null){
            log.info("subjectId: {}, studentId: {}", subjectId, studentId);
            throw new IllegalArgumentException("Subject id and Student id can not be null");
        }
        Contact student = contactRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("No student found with id: " + studentId));
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new NoSuchElementException("No subject found with id: " + subjectId));

        subject.enrollStudent(student);

        return subjectRepository.save(subject);

    }

    @Override
    public Set<SchoolAccount> getTeacherForSubject(Long subjectId) {
        if(subjectId == null){
            throw new IllegalArgumentException("Subject id can not be null");
        }
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(()-> new NoSuchElementException("No subject found with id: " + subjectId));

        return subject.getTeachers();
    }

    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }

    public Subject createSubject(Subject subject){
        return subjectRepository.save(subject);
    }
}
