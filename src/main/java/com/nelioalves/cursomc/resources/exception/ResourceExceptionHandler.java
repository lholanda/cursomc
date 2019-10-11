package com.nelioalves.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

/* 
 * Esta classe ira controlar as excecoes nos services
 * utilizará outra classe que controlará as mensagens de erros
 * StandartError
 * é uma classe auxiliar somente para exibir as excecoes
*/

@ControllerAdvice  // colocar esta notificacao
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	// Padrao do ControllerAdvice nao precisa mudar
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);	
	}

}
