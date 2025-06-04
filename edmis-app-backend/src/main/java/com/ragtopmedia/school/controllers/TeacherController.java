package com.ragtopmedia.school.controllers;

import com.ragtopmedia.school.dtos.SchoolAccountDTO;
import com.ragtopmedia.school.entities.Contact;
import com.ragtopmedia.school.services.TeacherServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody; // for @Operation

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
    @Operation(
        summary = "Create a new teacher",
        requestBody = @RequestBody(
            description = "teacher to add",
            required = true,
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                    name = "teacherExample",
                    value = "{\r\n" + //
                                "  \"contact\": {\r\n" + //
                                "    \"firstName\": \"Shoto\",\r\n" + //
                                "    \"lastName\": \"Aizawa\",\r\n" + //
                                "    \"middleName\": \"Eraser Head\",\r\n" + //
                                "    \"email\": \"saziawa@class1a.com\",\r\n" + //
                                "    \"mobilePhone\": \"123-456-7891\",\r\n" + //
                                "    \"homePhone\": \"123-456-7890\"\r\n" + //
                                "  },\r\n" + //
                                "  \"addresses\": [{\r\n" + //
                                "    \"inCareOfName\": \"Shoto\",\r\n" + //
                                "    \"streetAddress\": \"123 Mulberry St\",\r\n" + //
                                "    \"aptNumber\": \"435\",\r\n" + //
                                "    \"city\": \"ketsu\",\r\n" + //
                                "    \"state\": \"UT\",\r\n" + //
                                "    \"postalCode\": \"12345\",\r\n" + //
                                "    \"country\": \"US\",\r\n" + //
                                "    \"addressType\": \"mailing\"\r\n" + //
                                "    },\r\n" + //
                                "    {\r\n" + //
                                "    \"streetAddress\": \"456 Elm St\",\r\n" + //
                                "    \"aptNumber\": \"006\",\r\n" + //
                                "    \"city\": \"diama\",\r\n" + //
                                "    \"state\": \"AZ\",\r\n" + //
                                "    \"postalCode\": \"98765\",\r\n" + //
                                "    \"country\": \"US\",\r\n" + //
                                "    \"addressType\": \"physical\"\r\n" + //
                                "  }]\r\n" + //
                                "    \r\n" + //
                                "}"
                )
            )
        ),
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "teacher created successfully"
            )
        }
    )
    SchoolAccountDTO createTeacher(@org.springframework.web.bind.annotation.RequestBody SchoolAccountDTO schoolAccount) {

        return teacherServiceImpl.createTeacher(schoolAccount);
    }

    @PostMapping("/{teacherId}/subjects/{subjectId}")
    Contact assignSubjectToTeacher(@PathVariable Long teacherId, @PathVariable Long subjectId) {

        return teacherServiceImpl.assignSubjectToTeacher(teacherId, subjectId);
    }
}
