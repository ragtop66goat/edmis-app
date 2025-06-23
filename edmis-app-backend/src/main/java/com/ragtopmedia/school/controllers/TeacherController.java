package com.ragtopmedia.school.controllers;

import com.ragtopmedia.school.dtos.SchoolAccountDTO;
import com.ragtopmedia.school.entities.SchoolAccount;
import com.ragtopmedia.school.services.TeacherServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody; // for @Operation

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Teachers", description = "Endpoints for teacher management")
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherServiceImpl teacherServiceImpl;

    @GetMapping
    @Operation(
    summary = "Get all teachers",
    description = "Retrieves a list of all teachers, including their contact and address information."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "List of teachers retrieved successfully",
            content = @Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = SchoolAccountDTO.class))
            )
        )
    })
    List<SchoolAccountDTO> getTeachers() {

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
    SchoolAccountDTO createTeacher(@org.springframework.web.bind.annotation.RequestBody SchoolAccount schoolAccount) {

        return teacherServiceImpl.createTeacher(schoolAccount);
    }

    @PostMapping("/{teacherId}/subjects/{subjectId}")
    @Operation(
        summary = "Assign a subject to a teacher",
        description = "Links an existing teacher (SchoolAccount) to a subject by ID and returns contact and address info."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Subject assigned to teacher successfully", 
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = SchoolAccountDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid teacherId or subjectId supplied", 
            content = @Content),
        @ApiResponse(responseCode = "404", description = "Teacher or Subject not found", 
            content = @Content)
    })
    SchoolAccountDTO assignSubjectToTeacher(@PathVariable Long teacherId, @PathVariable Long subjectId) {

        return teacherServiceImpl.assignSubjectToTeacher(teacherId, subjectId);
    }
}
