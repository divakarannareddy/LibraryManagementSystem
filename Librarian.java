
import java.util.List;

public class Librarian {

	private int id;
	private String name;
	
	//constructor to initialize properties
	public Librarian(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	//method to add book
	public void addBook(List<Book>books,Book book) {
		books.add(book);
		//System.out.println();
	}
	
	//method to remove book
	public void removeBook(List<Book>books,Book book){
		books.remove(book);
	}
}
