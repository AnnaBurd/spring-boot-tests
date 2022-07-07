package my.anna.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


																// Annotation, data value datatype
public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String> {
	
	private String validEndOfEmail;
	

	@Override
	public void initialize(CheckEmail constraintAnnotation) {
		System.out.println("Initialized annotation");
		validEndOfEmail = constraintAnnotation.value();
		System.out.println("Annotation" + constraintAnnotation + "/n" + validEndOfEmail);
		
		
	}

	@Override
	public boolean isValid(String enteredEndOfEmail, ConstraintValidatorContext context) {

		System.out.println("Testing if valid");
		
		return enteredEndOfEmail.endsWith(validEndOfEmail);
	}

}
