package GitHub;

public class Mainnn	{
	
	public static void main (String[] args) {
		
		
		// Creating library items
		Book book1 = new Book("Charm Academy", "April Avery");
		DVD dvd1 = new DVD("Poseidon", "Wolfgang Petersen");
		
		
		// Creating library users
		Student student1 = new Student();
		Teacher teacher1 = new Teacher();
		
		
		student1.borrowItem(book1);
		teacher1.borrowItem(dvd1);
		
		student1.printItemsBorrowed();
		teacher1.printItemsBorrowed();
		
		student1.returnItem(book1);
		teacher1.returnItem(dvd1);
		
		student1.printItemsBorrowed();
		teacher1.printItemsBorrowed();
	}
}