package com.arijeet.projects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent(@PathVariable("id") String id) {
        Student student = new Student(id, "fname", "lname");
        LOGGER.info("Student details with id : {}", id);
        return student;
    }
}
