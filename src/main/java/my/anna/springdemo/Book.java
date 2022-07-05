package my.anna.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class Book {
	
	@Value("My book name")
	private String name;
	
	@Value("My authror name")
	private String author;
	
	@Value("1234")
	private int yearOfPublication;
	
}
