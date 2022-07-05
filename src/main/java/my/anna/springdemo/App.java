package my.anna.springdemo;

import java.util.List;

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
		
		
		
//		Library myLib = context.getBean("libraryBean", Library.class);
//		
//		myLib.getBook();
//		myLib.getJournal();
//		myLib.addBook("randname", context.getBean("book", Book.class));
//		myLib.addJournal();
		
		// Get bean from context by name
		University university = context.getBean("university", University.class);
		university.addStudents();
		
		List<Student> students = university.getStudents();
		System.out.println(students);
		
		context.close();
	}
}
