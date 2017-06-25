package com.propulsion.yelp.web;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Global {@link ControllerAdvice @ControllerAdvice}.
 */
@ControllerAdvice
public class GlobalControllerAdvice {

	@InitBinder
	public void configureBinding(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public void handleDatabaseConstraintViolation() {
		/* no-op */
	}

}
