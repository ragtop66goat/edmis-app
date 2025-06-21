package com.ragtopmedia.school.dtos;

import java.util.HashSet;
import java.util.Set;

import com.ragtopmedia.school.entities.Contact;
import com.ragtopmedia.school.entities.SchoolAccount;
import com.ragtopmedia.school.entities.Subject;


public class SubjectDTO {
    private String title;
    private Set<ContactDTO> enrolledStudents;
    private Set<ContactDTO> teachers;

    public static SubjectDTO from(Subject subject){
        SubjectDTO dto = new SubjectDTO();
        dto.setTitle(subject.gettitle());
        dto.setEnrolledStudents(subject.getEnrolledStudents());
        dto.setTeachers(subject.getTeachers());
        return dto;
    }

    public void setEnrolledStudents(Set<Contact> students){
        Set<ContactDTO> enrolledStudents = new HashSet<>();
        for(Contact student : students){
            enrolledStudents.add(ContactDTO.from(student));
        }
        this.enrolledStudents = enrolledStudents;
    }

    public Set<ContactDTO> getEnrolledStudents(){
        return this.enrolledStudents;
    }

    public void setTeachers(Set<SchoolAccount> teachers){
        Set<ContactDTO> subjectTeachers = new HashSet<>();
        for(SchoolAccount teacher : teachers){
            subjectTeachers.add(ContactDTO.from(teacher.getContact()));
        }
        this.teachers = subjectTeachers;
    }

    public Set<ContactDTO> getTeachers(){
        return this.teachers;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }
}
