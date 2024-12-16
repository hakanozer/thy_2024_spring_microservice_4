package com.works.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidn(MethodArgumentNotValidException ex) {
        return new ResponseEntity( parseError(ex.getFieldErrors()), HttpStatus.BAD_REQUEST);
    }

    private List parseError(List<FieldError> fieldErrors) {
        List list = new ArrayList();
        for (FieldError fieldError : fieldErrors) {
            Map map = new LinkedHashMap();
            map.put("field", fieldError.getField());
            map.put("message", fieldError.getDefaultMessage());
            map.put("rejectedValue", fieldError.getRejectedValue());
            list.add(map);
        }
        return list;
    }


}
