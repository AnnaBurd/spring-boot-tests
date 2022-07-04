package my.anna.springdemo;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component("libraryBean")
@NoArgsConstructor
public class Library {

	public void getBook() {
		System.out.println("Library: get book");
	}
	
	public void getJournal() {
		System.out.println("Library: get journal");
	}
}
