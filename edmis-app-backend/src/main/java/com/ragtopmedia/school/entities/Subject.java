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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="teacher_id", referencedColumnName = "id")
    private SchoolAccount teacher;

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

    public SchoolAccount getTeacher(){
        return this.teacher;
    }

    public void assignTeacher(SchoolAccount teacher){
        this.teacher = teacher;
    }

}
