import java.util.ArrayList;
import java.util.List;

public class Student {

    private int id;
    private String name;
    private List<Book> issuedBooks;
    
    //constructor to initialize properties
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.issuedBooks = new ArrayList<>();
	}
    
	//method to add book into list
	public void issueBook(Book book) {
		if(book.isAvaialable()) {
			book.issueBook();
			issuedBooks.add(book);
		}
		else {
			System.out.println("Sorry, "+book.getBookName()+" not available");
		}
	}
   
	//method to remove book from the list
	public void returnBook(Book book) {
		if(issuedBooks.remove(book)) {
			book.returnBook();
		}
		else {
			System.out.println("Soory, "+book.getBookName()+" is not issued to you please check");
		}
	}
	
    
}
