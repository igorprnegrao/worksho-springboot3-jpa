package com.educandoweb.course.resourses.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //inteceptar as excxeptions e tratar 
public class ResourceExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(
			ResourceNotFoundException e, HttpServletRequest request){
				String error = "Resource Not Found" ;
				HttpStatus status = HttpStatus.NOT_FOUND;
				StandardError err = new StandardError(Instant.now(),
						status.value(), error, e.getMessage(), request.getRequestURI());
				return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(
			DatabaseException e, HttpServletRequest request){
				String error = "DataBase error" ;
				HttpStatus status = HttpStatus.BAD_REQUEST;
				StandardError err = new StandardError(Instant.now(),
						status.value(), error, e.getMessage(), request.getRequestURI());
				return ResponseEntity.status(status).body(err);
	}
	

}
