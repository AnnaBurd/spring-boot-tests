package my.anna.springdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class University {
	

	private List<Student> students = new ArrayList<Student>();
	
	public void addStudents() {
		Student st1 = new Student("A", 4, 7.5);
		
		Student st2 = new Student("B", 4, 8.5);
		
		Student st3 = new Student("B", 5, 9.5);
		
		students.add(st1);
		students.add(st2);
		students.add(st3);
		System.out.println("--------------------------------------------------");
		
	}
	
	public List<Student> getStudents(){
		System.out.println("University: get students");
		
//		System.out.println(students.get(3));
		
		try {
			System.out.println(students.get(3));
		} catch (Exception e) {
			System.out.println("Try-catch get students");
		}
		
		System.out.println(students);
		System.out.println("--------------------------------------------------");
		
		return students;
	}
	

}
