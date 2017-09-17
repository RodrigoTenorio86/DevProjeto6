package br.com.pucsp.devProjeto.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.pucsp.devProjeto.error.ResourceNotFoundDetails;
import br.com.pucsp.devProjeto.error.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<?>handleResourceNotFoundException(ResourceNotFoundException rnfException){
	ResourceNotFoundDetails rnfDetails=ResourceNotFoundDetails.Builder
			                                     .newBuilder()
			                                     .timestamp(new Date().getTime())
			                                     .status(HttpStatus.NOT_FOUND.value())
			                                     .title("Resource not Found")
			                                     .detail(rnfException.getMessage())
			                                     .developerMessage(rnfException.getClass().getName())
			                                     .build();
	return new ResponseEntity<>(rnfDetails,HttpStatus.NOT_FOUND);
}

}
