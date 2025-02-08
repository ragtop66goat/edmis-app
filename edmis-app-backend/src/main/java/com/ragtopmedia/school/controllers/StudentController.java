package com.ragtopmedia.school.controllers;

import com.ragtopmedia.school.dtos.SchoolAccountDTO;
import com.ragtopmedia.school.entities.SchoolAccount;
import com.ragtopmedia.school.entities.Student;
import com.ragtopmedia.school.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @PostMapping
    SchoolAccountDTO createStudent(@RequestBody SchoolAccountDTO schoolAccount) {

        return studentServiceImpl.createStudent(schoolAccount);
    }
}