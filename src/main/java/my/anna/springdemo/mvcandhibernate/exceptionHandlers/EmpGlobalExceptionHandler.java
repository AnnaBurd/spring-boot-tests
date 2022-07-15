package my.anna.springdemo.mvcandhibernate.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmpGlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<EmpIncorrectID> handleException(NoSuchEmpException e){
		EmpIncorrectID message = new EmpIncorrectID();
		message.setInfo(e.getMessage());
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<EmpIncorrectID> handleException(Exception e){
		EmpIncorrectID message = new EmpIncorrectID();
		message.setInfo(e.getMessage());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

}
