package com.ragtopmedia.school.controllers;

import com.ragtopmedia.school.dtos.SchoolAccountDTO;
import com.ragtopmedia.school.entities.SchoolAccount;
import com.ragtopmedia.school.services.StudentServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody; // for @Operation

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Students", description = "Endpoints for student management")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @GetMapping
    @Operation(
        summary = "Get all students",
        description = "Retrieves a list of all students, including there contacts and addresses"
    )
    @ApiResponses(value ={
        @ApiResponse(
            responseCode = "200",
            description = "List of students retrieved successfully",
            content = @Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = SchoolAccountDTO.class))
            )
        )
    })
    List<SchoolAccountDTO> getStudents(){
        return studentServiceImpl.getStudents();
    }

    @PostMapping
    @Operation(
        summary = "Create a new student",
        requestBody = @RequestBody(
            description = "Student to add",
            required = true,
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                    name = "StudentExample",
                    value = "{\r\n" + //
                                "  \"contact\": {\r\n" + //
                                "    \"firstName\": \"Izuku\",\r\n" + //
                                "    \"lastName\": \"Midoriya\",\r\n" + //
                                "    \"middleName\": \"Deku\",\r\n" + //
                                "    \"email\": \"deku@class1a.com\",\r\n" + //
                                "    \"mobilePhone\": \"123-456-7891\",\r\n" + //
                                "    \"homePhone\": \"123-456-7890\"\r\n" + //
                                "  },\r\n" + //
                                "  \"addresses\": [{\r\n" + //
                                "    \"inCareOfName\": \"Deku\",\r\n" + //
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
                description = "Student created successfully"
            )
        }
    )
    SchoolAccountDTO createStudent(@org.springframework.web.bind.annotation.RequestBody SchoolAccount schoolAccount) {

        return studentServiceImpl.createStudent(schoolAccount);
    }

    // create get students endpoint
}