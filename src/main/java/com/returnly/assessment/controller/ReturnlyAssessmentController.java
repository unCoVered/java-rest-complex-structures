package com.returnly.assessment.controller;

import com.returnly.assessment.model.ReturnlyAssessmentResult;
import com.returnly.assessment.service.ReturnlyAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController("/results")
public class ReturnlyAssessmentController {

    @Autowired private ReturnlyAssessmentService service;

    @GetMapping
    public ResponseEntity<ReturnlyAssessmentResult> getTryout() throws IOException {
        return ResponseEntity.ok().body(service.calculateAssessmentResult());
    }
}
