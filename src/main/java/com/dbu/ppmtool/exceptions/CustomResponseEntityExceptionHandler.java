package com.dbu.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * What is @ControllerAdvice?
 * https://dzone.com/articles/global-exception-handling-with-controlleradvice
 * Centralize your error handling logic in spring by using the @ControllerAdvice annotation. Reduce duplicate code and keep your code clean!
 * @author Dhaivat
 *
 */
@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
  
  @ExceptionHandler
  public final ResponseEntity<Object> handleProjectIdentifierException(ProjectIdentifierException ex, WebRequest request) {
    ProjectIdentifierExceptionResponse exceptionResponse = new ProjectIdentifierExceptionResponse(ex.getMessage());
    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

}
