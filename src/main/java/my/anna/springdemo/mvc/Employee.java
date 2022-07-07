package my.anna.springdemo.mvc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
	@NonNull
	@Size(min=3, max=20, message="The name must be at least 2 symbols")
	private String name;
	
	
	@NonNull
	//@NotNull(message="The surname must be")
	//@NotEmpty(message="The surname must be and not ""  ")
	@NotBlank(message="The surname must be and not blank")
	private String surname;
	
	
	@NonNull
	@Min(value=100, message="must be greater than 100")
	@Max(value=1000, message="must be lower than 1000")
	private int salary;
	
	
	@NonNull
	private String department;
	
	@Pattern(regexp="\\d{3}-\\d{2}-\\d{2}", message="must be a phone number xxx-xx-xx")
	private String phoneNumber;
	
	private String level;
	
	private String[] languages; //= new String[10]; // Who creates array?
	
	// How to add list of the same options - better rewrite constructor... :)	
	private Map<String,String> departmentOptions = Stream.of(new String[][] { 
	    { "dep1", "D1" }, 
	    { "D2", "D2" },
	}).collect(Collectors.collectingAndThen(
	    Collectors.toMap(data -> data[0], data -> data[1]), 
	    Collections::<String, String> unmodifiableMap));
	
	private Map<String,String> levelOptions = Stream.of(new String[][] { 
	    { "level 1", "LVL1" }, 
	    { "level 2", "LVL2" },
	}).collect(Collectors.collectingAndThen(
	    Collectors.toMap(data -> data[0], data -> data[1]), 
	    Collections::<String, String> unmodifiableMap));
	
	private Map<String,String> languageOptions = Stream.of(new String[][] { 
	    { "English", "EN" }, 
	    { "Russian", "Ru" },
	}).collect(Collectors.collectingAndThen(
	    Collectors.toMap(data -> data[0], data -> data[1]), 
	    Collections::<String, String> unmodifiableMap));
}
