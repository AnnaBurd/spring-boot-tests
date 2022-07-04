package my.anna.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "Hello World!" );

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(MyConfig.class);
		
		
		
		Library myLib = context.getBean("libraryBean", Library.class);
		
		myLib.getBook();
		myLib.getJournal();
	}
}
