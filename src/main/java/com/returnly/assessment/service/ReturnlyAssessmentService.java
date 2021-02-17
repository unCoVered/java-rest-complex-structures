package com.returnly.assessment.service;

import com.returnly.assessment.model.ReturnlyAssessmentResult;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface ReturnlyAssessmentService {
    public ReturnlyAssessmentResult calculateAssessmentResult() throws IOException;
}
