package my.anna.springdemo.mvcandhibernate.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLogginAspect {
	
	
	@Around("execution(* my.anna.springdemo.mvcandhibernate.entities.*DAO.*(..))")
	public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint jp) throws Throwable{
		
		MethodSignature signature = (MethodSignature) jp.getSignature();
		
		String methodName = signature.getName();
		
		System.out.println("MY LOGGING: begin of " + methodName);
		
		Object targetMethodResult = jp.proceed();
		
		System.out.println("MY LOGGING: end of " + methodName);
		
		return targetMethodResult;
		
	}

}
