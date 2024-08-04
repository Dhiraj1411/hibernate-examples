package com.advanced.hibernate.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StudentValidationException {

    String reason;

    List<String> errors;

    static StudentValidationException badRequest(HandlerMethodValidationException ex){
        StudentValidationException studentValidationException = new StudentValidationException();
        String reason = ex.getReason();
        List<String> errors = new ArrayList<>();
        ex.getAllValidationResults().forEach(item -> {
            item.getResolvableErrors().forEach(err -> {
                errors.add(err.getDefaultMessage());
            });
        });
        studentValidationException.setErrors(errors);
        studentValidationException.setReason(reason);
        return studentValidationException;
    }
}
