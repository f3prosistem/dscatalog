package com.f3pro.dscatolog.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.f3pro.dscatolog.services.exceptions.DatabaseExeption;
import com.f3pro.dscatolog.services.exceptions.ResourceNotFoundExeption;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundExeption.class)
	public ResponseEntity<StanderdError> entityNotFound(ResourceNotFoundExeption e, HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		StanderdError err = new StanderdError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Recurso não encontrado");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);

	}

	@ExceptionHandler(DatabaseExeption.class)
	public ResponseEntity<StanderdError> database(DatabaseExeption e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StanderdError err = new StanderdError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Exceção de banco de dados");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
