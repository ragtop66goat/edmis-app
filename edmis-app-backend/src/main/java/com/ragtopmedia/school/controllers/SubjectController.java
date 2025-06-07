package com.ragtopmedia.school.controllers;

import com.ragtopmedia.school.entities.SchoolAccount;
import com.ragtopmedia.school.entities.Subject;
import com.ragtopmedia.school.services.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody; // for @Operation
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
    @Operation(
        summary = "Create a new Subject",
        requestBody = @RequestBody(
            description = "subject to add",
            required = true,
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                    name = "SubjectExample",
                    value = "{\"name\":\"Math\"}"
                )
            )

        ),
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Subject created successfuly"
            )
        }
    )
    Subject createSubject(@org.springframework.web.bind.annotation.RequestBody Subject subject) {

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
