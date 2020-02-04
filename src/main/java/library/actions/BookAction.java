package library.actions;

import java.util.ArrayList;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import library.beans.Book;

import library.dao.BookDao;

public class BookAction extends ActionSupport {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private List<Book>  bookList=new ArrayList<Book>();
	
	private Book book; 
	
	
	public String addBook(){
		return SUCCESS;
	}
	
	public String listBooks(){
		
		bookList=new BookDao().getBookList();
				
		return SUCCESS;
	}
	public String addNewBook(){
	BookDao bookDao=new BookDao();
	if(book!=null && book.getBookId() ==null){
		// add new book 
		int result= bookDao.addNewBook(book);
		bookList=bookDao.getBookList();
		addActionMessage("Book Successfully added");
	}else{
		//book edit case 	
	}
	return SUCCESS;
}

public void validateAddNewBook(){
	if(book!=null){
		if("".equals(book.getBookName())){
			addFieldError("book.bookName", "Please enter book name");
		}
		else if(book.getBookName().trim().length()==0 ){
			addFieldError("book.bookName", "Please enter valid book name");
		}
		
		
	}
		
}
		
	

public List<Book> getBookList() {
	return bookList;
}

public Book getBook() {
	return book;
}

public void setBook(Book book) {
	this.book = book;
}

public void setBookList(List<Book> bookList) {
	this.bookList = bookList;
}
}
	
	