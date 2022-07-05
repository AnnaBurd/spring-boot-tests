package my.anna.springdemo;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component("libraryBean")
@NoArgsConstructor
public class Library {

	public void getBook() {
		System.out.println("Library: get book");
		System.out.println("--------------------------------------------------");
	}
	
	public void getJournal() {
		System.out.println("Library: get journal");
		System.out.println("--------------------------------------------------");
	}
	
	public void addBook(String personName, Book book) {
		System.out.println("Library: add book");
		System.out.println("Arguments inside addBook method: " + personName + " " + book);
		System.out.println("--------------------------------------------------");
	}
	
	public void addJournal() {
		System.out.println("Library: add journal");
		System.out.println("--------------------------------------------------");
	}
	
	public String returnBook() {
		System.out.println("returnBook()");
		return "Book name";
		
	}
}
