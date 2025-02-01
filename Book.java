
public class Book {
     private int bookId;
     private String bookName;
     private String author;
     private boolean isAvaialable;
     
     //Constructor to initialize properties
	public Book(int bookId, String bookName, String author) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.isAvaialable = true;
	}
	
	//getters to access our private data from outside of class
	protected int getBookId() {
		return bookId;
	}
	protected String getBookName() {
		return bookName;
	}
	protected String getAuthor() {
		return author;
	}
	protected boolean isAvaialable() {
		return isAvaialable;
	}
	protected void setAvaialable(boolean isAvaialable) {
		this.isAvaialable = isAvaialable;
	}
	
	//method to issue book
    public void issueBook() {
    	if(isAvaialable) {
    		isAvaialable=false;
    		System.out.println(bookName+" book issued");
    	}
    	else {
    		System.out.println("Sorry, "+ bookName+" book is not available");
    	}
    }
    
    //method to return book
    public void returnBook() {
    	isAvaialable=true;
    	System.out.println("You Successfully returned "+bookName+" book");
    }

    //to string method to print the details of the book
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", isAvaialable="
				+ isAvaialable + "]";
	}
}
