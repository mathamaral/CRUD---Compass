package br.com.projeto.produto.error;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public ExceptionResponse handle(NoSuchElementException e) {
		
		return new ExceptionResponse(HttpStatus.NOT_FOUND.value(), "NOT FOUND :(");
	} 
		
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ExceptionResponse handle(Exception e) {
			
		return new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "INTERNAL SERVER ERROR :/");
	} 
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ExceptionResponse handle(MethodArgumentNotValidException e) {
			
		return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), "BAD REQUEST :x");
	}
	
}
