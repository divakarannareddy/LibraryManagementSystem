
import com.librarymanagement.BLC.Book;
import com.librarymanagement.BLC.Librarian;
import com.librarymanagement.BLC.Library;
import com.librarymanagement.BLC.Student;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		
		//instance for Library
		Library library = new Library();
		//instance for Librarian
		Librarian librarian = new Librarian(1,"John");
        //instance for Books
		
		Book b1 = new Book(1,"C Programming language","Dennis Richy");
		Book b2 = new Book(2,"Java Programming language","James Gosling");
		Book b3 = new Book(3,"HTML","Tim Berners-Lee");
		Book b4 = new Book(4,"CSS","Håkon Wium Lie");
		Book b5 = new Book(5,"JavaScript","Brendan Eich");
		
		//adding books into library
		librarian.addBook(library.getBooks(), b1);
		librarian.addBook(library.getBooks(), b2);
		librarian.addBook(library.getBooks(), b3);
		librarian.addBook(library.getBooks(), b4);
		librarian.addBook(library.getBooks(), b5);
		
		//adding members into library
		Student m = new Student(101,"smith");
		library.addMembers(m);
		
		//Member takes/issues a book
		Book b = library.searchBook(2);
		if(b!=null) {
			m.issueBook(b);
		}
		
		//Displaying list of books
		library.displayBooks();
		
		//member returned book
		m.returnBook(b);
		
		//Displaying list of books
	    library.displayBooks();
		
		
	}

}
