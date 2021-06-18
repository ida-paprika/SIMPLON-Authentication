package fr.formation.authentication.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomAdvice extends ResponseEntityExceptionHandler {

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//	    MethodArgumentNotValidException ex, HttpHeaders headers,
//	    HttpStatus status, WebRequest request) {
//	HttpStatus badRequest = HttpStatus.BAD_REQUEST;
//	List<ObjectError> errors = ex.getAllErrors();
//	return handleExceptionInternal(ex, errors, headers, badRequest,
//		request);
//    }

    /*
     * @Override protected ResponseEntity<Object> handleMethodArgumentNotValid(
     * MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus
     * status, WebRequest request) {
     * 
     * Map<String, Object> body = new LinkedHashMap<>(); body.put("timestamp",
     * new Date()); body.put("status", status.value());
     * 
     * // Get all errors List<String> errors =
     * ex.getBindingResult().getFieldErrors().stream() .map(x ->
     * x.getDefaultMessage()).collect(Collectors.toList());
     * 
     * body.put("errors", errors);
     * 
     * return new ResponseEntity<>(body, headers, status);
     * 
     * }
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
	    MethodArgumentNotValidException ex, HttpHeaders headers,
	    HttpStatus status, WebRequest request) {

	HttpStatus badRequest = HttpStatus.BAD_REQUEST;
	List<ObjectError> errors = ex.getAllErrors();
	return handleExceptionInternal(ex, errors, headers, badRequest,
		request);

    }
}
