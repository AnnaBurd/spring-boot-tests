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

		Object targetMethodResult = null;

		long begin = System.currentTimeMillis();
		// Manually call method inside the @Around advice

		try {
			targetMethodResult = proceedingJoinPoint.proceed();
			}catch (Exception e) {
				System.out.println("aroundReturnBookSecurityAdvice: exception " + e.getMessage());
				targetMethodResult = "error value default"; // Deal with exception in place
				//throw e; // OR Throw exception further to main
		}

		long end = System.currentTimeMillis();

		System.out.println("aroundReturnBookSecurityAdvice(): end in " + (end-begin) + " Millis");

		// Return parameters of the method inside the @Around advice
		return targetMethodResult;
	}
}
