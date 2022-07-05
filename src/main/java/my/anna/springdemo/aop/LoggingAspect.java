package my.anna.springdemo.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import my.anna.springdemo.Student;

@Component
@Aspect
@Order(5)
public class LoggingAspect {
	
	@Before("Pointcuts.allAddMethods()")
	public void beforeAddAdvice(JoinPoint joinPoint) {
		System.out.println("Advice beforeAddAdvice()");
		
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		System.out.println(methodSignature);
		
		Object[] args = joinPoint.getArgs();
		for(int i=0;i<args.length; i++) {
			System.out.println("\t" + args[i]);
		}
		
		// The value is not changed 
		if (args.length > 1) {
			args[0] = "NoNONOO";
		}
		
	}
	
	@AfterReturning("Pointcuts.allAddMethods()")
	public void afterAddAdvice() {
		System.out.println("Advice afterAddAdvice()");
		System.out.println();
	}
	
	@Before("Pointcuts.allGetMethods()")
	public void beforeGetAdvice() {
		System.out.println("Advice beforeGetAdvice()");
	}
	
	// After returning advice catches return value and allows to change it
	@AfterReturning(value ="Pointcuts.allGetMethods()", returning =  "returnValue")
	public void afterGetAdvice(JoinPoint joinPoint, Object returnValue) { // List<Student> returnValue also works
																		// JoinPoint parameter is not required
		System.out.println("Advice afterGetAdvice()");
		
		List<Student> returnedStudents = (List<Student>) returnValue;
		
		returnedStudents.add(new Student("sdfsd", 34,2));
		
		System.out.println();
		
		
	}
	
	

}
