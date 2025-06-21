package com.ragtopmedia.school.controllers;

import com.ragtopmedia.school.dtos.SchoolAccountDTO;
import com.ragtopmedia.school.dtos.SubjectDTO;
import com.ragtopmedia.school.entities.Subject;
import com.ragtopmedia.school.services.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody; // for @Operation
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectServiceImpl subjectServiceImpl;

    @GetMapping
    List<SubjectDTO> getSubjects() {

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
    SubjectDTO createSubject(@org.springframework.web.bind.annotation.RequestBody Subject subject) {

        return subjectServiceImpl.createSubject(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    @Operation(
        summary = "Enroll a student into a call",
        parameters = {
            @Parameter(
                name = "subjectId",
                description = "id of the subject",
                required = true,
                example = "1"
            ),
            @Parameter(
                name = "studentId",
                description = "id of the student",
                required = true,
                example = "1"
            )
        },
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Student successfully enrolled",
                content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                        name = "enrolledSubject",
                        value = "{\"id\":\"1\", \"name\":\"math\"}"
                    )
                )
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Student or Class not found"
            )
        }
    )
    SubjectDTO enrollStudent(@PathVariable Long subjectId, @PathVariable Long studentId){
        return subjectServiceImpl.enrollStudent(subjectId, studentId);
    }

    @GetMapping("/{subjectId}/teacher")
    Set<SchoolAccountDTO> getTeacherForSubject(@PathVariable Long subjectId){
        return subjectServiceImpl.getTeacherForSubject(subjectId);

    }
}
