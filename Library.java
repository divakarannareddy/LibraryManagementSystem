
import java.util.ArrayList;
import java.util.List;

public class Library {

	private List<Student> students;
	private List<Book> books;
	
	//constructor to initialize properties
	public Library() {
		super();
		this.students = new ArrayList<>();
		this.books = new ArrayList<>();
	}
	
	//method to add books
	public void addBooks(Book book) {
		getBooks().add(book);
	}
	
	//method to add members
	public void addMembers(Student student) {
		students.add(student);
	}
	
	//method to search for books
	public Book searchBook(int id) {
		for(Book b:getBooks()) {
			if(b.getBookId()==id) {
				return b;
			}
		}
		return null;
	}
	
	//method to display books
	   public void displayBooks() {
	        for (Book b : getBooks()) {
	            System.out.println(b);
	        }
	    }

	public List<Book> getBooks() {
		return books;
	}

	
}
