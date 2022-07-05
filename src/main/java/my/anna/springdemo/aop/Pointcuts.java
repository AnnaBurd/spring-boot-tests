package my.anna.springdemo.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
	
	@Pointcut("execution(* get*())")
	public void allGetMethods() {}
	
	@Pointcut("execution(* add*(..))")
	public void allAddMethods() {}
	
	
//	@Pointcut("execution(* get*())")
//	private void allGetMethodsSecond() {}

}
