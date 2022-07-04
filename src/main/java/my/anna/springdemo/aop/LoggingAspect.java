package my.anna.springdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(5)
public class LoggingAspect {
	
	@Before("Pointcuts.allGetMethods()")
	public void beforeGetAdvice() {
		System.out.println("Advice beforeGetAdvice()");
	}
}
