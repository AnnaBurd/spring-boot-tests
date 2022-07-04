package my.anna.springdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class SecurityAspect {
	
	@Before("Pointcuts.allGetMethods()")
	public void beforeGetAdviceSecond() {
		System.out.println("Advice beforeGetAdviceSecond()");
	}

}
