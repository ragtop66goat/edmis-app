package com.ragtopmedia.school.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToMany
    @JoinTable(
            name = "student_enrolled",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Contact> enrolledStudents = new HashSet<>();

    @ManyToMany(mappedBy = "subjectsTaught")
    Set<SchoolAccount> teachers = new HashSet<>();

    private String name;


// getters and setters
    public Set<Contact> getEnrolledStudents(){return this.enrolledStudents;}
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void enrollStudent(Contact student){
        enrolledStudents.add(student);
    }

    public Set<SchoolAccount> getTeachers(){
        return this.teachers;
    }

    public void assignTeacher(SchoolAccount teacher){
        this.teachers.add(teacher);
    }

}
