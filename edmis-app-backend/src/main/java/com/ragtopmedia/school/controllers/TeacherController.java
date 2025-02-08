package com.ragtopmedia.school.controllers;

import com.ragtopmedia.school.entities.Contact;
import com.ragtopmedia.school.entities.Teacher;
import com.ragtopmedia.school.services.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherServiceImpl teacherServiceImpl;

    @GetMapping
    List<Contact> getTeachers() {

        return teacherServiceImpl.getTeachers();
    }

    @PostMapping
    Contact createTeacher(@RequestBody Contact teacher) {

        return teacherServiceImpl.createTeacher(teacher);
    }

    @PostMapping("/{teacherId}/subjects/{subjectId}")
    Contact assignSubjectToTeacher(@PathVariable Long teacherId, @PathVariable Long subjectId) {

        return teacherServiceImpl.assignSubjectToTeacher(teacherId, subjectId);
    }
}
