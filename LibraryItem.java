package GitHub;

import java.util.*;

interface LibraryItem {

	void  borrowItem();
	void returnItem();
	boolean isBorrowed();	
}


class Book implements LibraryItem {
	
	private String title;
	private String author;
	private boolean borrowed;
	
	public Book(String title, String author) {
		
		this.title = title;
		this.author = author;
		this.borrowed = false;
	}
	
	public String toString() {
		return "Book: " + title + " by " + author;
	}
	
	@Override
	public void borrowItem() {
		 
		if (!isBorrowed()) {
			borrowed = true;
			System.out.println("The book '" + title + "' is borrowed successfully!");
		} else {
			System.out.println("The book'" + title + "' is already borrowed.\n");
		}
	}
	
	@Override
	public void returnItem() {
		
		if(!isBorrowed()) {
			borrowed = false;
			System.out.println("The book '" + title + "' is returned successfully!");
		} else {
			System.out.println("\n\nThe book '" + title + "' is not borrowed.");
		}
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Book)) {
			return false;
		}
		
		Book otherBook = (Book) obj;
		return this.title.equals(otherBook.title);
	}
	
	@Override
	public boolean isBorrowed() {
		return borrowed;
	}
	
}


class DVD implements LibraryItem {
	
	private String title;
	private String director;
	private boolean borrowed;
	
	public DVD(String title, String director) {
		
		this.title = title;
		this.director = director;
		this.borrowed  = false;
	}
	
	public String toString() {
		return "DVD: " + title + " directed by " + director;
	}
	
	@Override
	public void borrowItem() {
		
		if(!isBorrowed()) {
			borrowed = true;
			System.out.println("The DVD '" + title + "' is borrowed successfully!");
		} else {
			System.out.println("The DVD '" + title + "' is already borrowed.");
		}
	}
	
	@Override
	public void returnItem() {
		
		if(!isBorrowed()) {
			borrowed = false;
			System.out.println("\nThe DVD '" + title + "' is returned successfully!");
		} else {
			System.out.println("The DVD '" + title + "' is not borrowed.\n\n");
		}
	}
	
	@Override
	public boolean isBorrowed() {
		return borrowed;
	}
}
	
	
abstract class LibraryUser {
	
	abstract void borrowItem(LibraryItem item);
	abstract void returnItem(LibraryItem item);
	abstract void printItemsBorrowed();
}
	
	
class Student extends LibraryUser {
	
	private List<LibraryItem> borrowedItems;
	
	public Student() {
		borrowedItems = new ArrayList<>();
	}
	
	@Override
	public void borrowItem(LibraryItem item) {
		item.borrowItem();
		borrowedItems.add(item);
	}
	
	@Override
	public void returnItem(LibraryItem item) {
		item.returnItem();
		borrowedItems.removeIf(borrowItem -> borrowItem.equals(item));
	}
	
	@Override
	public void printItemsBorrowed() {
		System.out.print("\nStudent: Harper \nBorrowed Items: \n");
		for (LibraryItem item : borrowedItems) {
			System.out.print("- " + item);
		}
	}
}
	
	
class Teacher extends LibraryUser{
	
	private List<LibraryItem> borrowedItems;
	
	public Teacher() {
		borrowedItems = new ArrayList<>();
	}
	
	@Override
	public void borrowItem(LibraryItem item) {
		item.borrowItem();
		borrowedItems.add(item);
	}

	@Override
	public void returnItem(LibraryItem item) {
		item.returnItem();
		borrowedItems.removeIf(borrowItem -> borrowItem.equals(item));
	}

	@Override
	public void printItemsBorrowed() {
		System.out.print("\n\nTeacher: Ms Rosielie \nBorrowed Items: ");
		for (LibraryItem item : borrowedItems) {
			System.out.print("\n- " + item);
		}
	}	
}

