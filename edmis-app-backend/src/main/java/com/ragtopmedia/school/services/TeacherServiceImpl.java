package com.ragtopmedia.school.services;

import com.ragtopmedia.school.entities.Contact;
import com.ragtopmedia.school.entities.Subject;
import com.ragtopmedia.school.repositories.SubjectRepository;
import com.ragtopmedia.school.repositories.ContactRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeacherServiceImpl implements TeacherService{

    private static final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);
    private final ContactRepository contactRepository;
    private final SubjectRepository subjectRepository;

    TeacherServiceImpl(ContactRepository teacherRepository, SubjectRepository subjectRepository){
        this.contactRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Contact> getTeachers() {
        return contactRepository.findAll();
    }

    @Override
    public Contact createTeacher(Contact teacher) {
        return contactRepository.save(teacher);
    }

    @Override
    @Transactional
    public Contact assignSubjectToTeacher(Long teacherId, Long subjectId) {

        if(teacherId == null || subjectId == null){
            logger.info("teacherId: {}, subjectId: {}", teacherId, subjectId);
            throw new IllegalArgumentException("Teacher id and Subject id can not be null");
        }
        Contact teacher = contactRepository.findById(teacherId)
                .orElseThrow(() -> new NoSuchElementException("No teacher found with id: " + teacherId));
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new NoSuchElementException("No subject found with id: " + subjectId));

//        teacher.assignSubject(subject);
//        subject.assignTeacher(teacher);

        subjectRepository.save(subject);

        return contactRepository.save(teacher);


    }
}
