package com.ragtopmedia.school.controllers;

import com.ragtopmedia.school.entities.SchoolAccount;
import com.ragtopmedia.school.entities.Subject;
import com.ragtopmedia.school.services.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectServiceImpl subjectServiceImpl;

    @GetMapping
    List<Subject> getSubjects() {

        return subjectServiceImpl.getSubjects();
    }

    @PostMapping
    Subject createSubject(@RequestBody Subject subject) {

        return subjectServiceImpl.createSubject(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    Subject enrollStudent(@PathVariable Long subjectId, @PathVariable Long studentId){
        return subjectServiceImpl.enrollStudent(subjectId, studentId);
    }

    @GetMapping("/{subjectId}/teacher")
    SchoolAccount getTeacherForSubject(@PathVariable Long subjectId){
        return subjectServiceImpl.getTeacherForSubject(subjectId);

    }
}
