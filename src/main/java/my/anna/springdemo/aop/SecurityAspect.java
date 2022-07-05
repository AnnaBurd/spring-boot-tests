package my.anna.springdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class SecurityAspect {
	
	@Before("Pointcuts.allAddMethods()")
	public void beforeAddAdviceSecond() {
		System.out.println("Advice beforeAddAdviceSecond()");
	}
	
	@Around("execution(public String returnBook())")
	public Object aroundReturnBookSecurityAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("aroundReturnBookSecurityAdvice(): start");
		
		// Manually call method inside the @Around advice
		Object targetMethodResult = proceedingJoinPoint.proceed();
		
		System.out.println("aroundReturnBookSecurityAdvice(): end");
		
		// Return parameters of the method inside the @Around advice
		return targetMethodResult;
	}

}
