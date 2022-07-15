package my.anna.springdemo.mvcandhibernate.exceptionHandlers;

public class NoSuchEmpException extends RuntimeException{
	
	public NoSuchEmpException(String message) {
		super(message);
	}

}
