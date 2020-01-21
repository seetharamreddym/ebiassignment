package com.ebi.person;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebi.person.exception.ApplicationException;
import com.ebi.person.model.ApplicationError;

@ControllerAdvice
public class GlobalExceptionHandler {
	  
	protected static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	  
	

	  @ExceptionHandler(NoSuchElementException.class)
	  @ResponseBody
	  public ResponseEntity<ApplicationError> noSuchElementException(
	      final NoSuchElementException exception) {
	    LOGGER.error("NoSuchElementException exception while processing request: ", exception);
	    final ApplicationError applicationError = new ApplicationError("Internal Server Error", exception.getMessage(), "Excpetion while fetching person details", HttpStatus.NOT_FOUND.value());
	
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(applicationError);
	  }
	  
	  @ExceptionHandler(RuntimeException.class)
	  @ResponseBody
	  public ResponseEntity<ApplicationError> runtimeException(
	      final RuntimeException exception) {
	    LOGGER.error("RuntimeException exception while processing request: ", exception);
	    final ApplicationError applicationError = new ApplicationError("Internal Server Error", exception.getMessage(), "Excpetion while procesing request ", HttpStatus.INTERNAL_SERVER_ERROR.value());
	
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
	  }
	  
	  @ExceptionHandler(ApplicationException.class)
	  @ResponseBody
	  public ResponseEntity<ApplicationError> applicationException(
	      final ApplicationException exception) {
	    LOGGER.error("ApplicationException exception while processing request: ", exception);
	    final ApplicationError applicationError = new ApplicationError("Application Error", exception.getTitle(), exception.getDescription(), exception.getStatus().value());
	
	    return ResponseEntity.status(exception.getStatus()).body(applicationError);
	  }

}
