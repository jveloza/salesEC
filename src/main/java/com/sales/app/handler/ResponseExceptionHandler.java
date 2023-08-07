package com.sales.app.handler;

import java.time.format.DateTimeParseException;

import javax.persistence.NonUniqueResultException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sales.app.response.ErrorMessageResponse;

@RestControllerAdvice
public class ResponseExceptionHandler {

	@ExceptionHandler(DateTimeParseException.class)
	public ErrorMessageResponse handleDateTimeStatusException(HttpServletResponse response) {
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ErrorMessageResponse("Formato de fecha incorrecto.");
	}
	
	@ExceptionHandler(NonUniqueResultException.class)
	public ErrorMessageResponse handleNonUniqueResultStatusException(HttpServletResponse response) {
		response.setStatus(HttpStatus.CONFLICT.value());
		return new ErrorMessageResponse("Registros similares, revisar prioridad de los registros de producto, marca y fecha inicial de la solicitud");
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorMessageResponse handleMethodNotValidStatusException(MethodArgumentNotValidException m,  HttpServletResponse response) {
		response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
		if(m.getFieldErrors().size()>1) {
			return new ErrorMessageResponse("La solicitud debe contener los campos de producto, fecha de inicio y marca");
		}
		return new ErrorMessageResponse("Verificar Solicitud, hace falta el campo "+m.getFieldError().getField());
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ErrorMessageResponse handleMethodNotValidStatusException(HttpServletResponse response) {
		response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
		return new ErrorMessageResponse("Verifique Body de la solicitud.");
	}
}
