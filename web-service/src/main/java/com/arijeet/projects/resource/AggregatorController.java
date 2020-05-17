package com.arijeet.projects.resource;

import com.arijeet.projects.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/class")
public class AggregatorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AggregatorController.class);

    @Autowired
    private WebClient webClient;

    @GetMapping(value = "/student/{id}")
    public StudentDetails getStudentDetails(@PathVariable("id") String id) {
        LOGGER.info("Fetching student details for student with id : {}", id);
        String studentEndpoint = "/student";

        Mono<Student> studentMono = webClient.get()
                .uri(studentEndpoint+"/"+id)
                .retrieve()
                .bodyToMono(Student.class);
        Optional<Student> studentOptional = studentMono.blockOptional();
        StudentDetails studentDetails = studentOptional
                .map(student -> student.getFirstName()+" "+student.getLastName())
                .map(name -> new StudentDetails(name))
                .orElse(null);
        return studentDetails;
    }
}
