package com.nb.dev.todo_list.handlers;

import com.nb.dev.todo_list.exceptions.DefaultErrorBody;
import com.nb.dev.todo_list.exceptions.TodoNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<DefaultErrorBody> todoNotFoundException(TodoNotFoundException ex){
        DefaultErrorBody exBody = new DefaultErrorBody(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "todo not found",
                ex.getMessage()
        ); return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exBody);

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<DefaultErrorBody> constraintViolationException(ConstraintViolationException ex) {
        String errorMsg = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage).collect(Collectors.joining(" "));

        DefaultErrorBody exBody = new DefaultErrorBody(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                errorMsg
        );
        return new ResponseEntity<DefaultErrorBody>(exBody, HttpStatus.BAD_REQUEST);
    }


}
