package library.beans;

import java.util.Date;

public class Book {

	private Long bookId;
	private String bookName;
	private String bookDesc;
	private Date bookCreated;

	public Book(Long bookid, String bookname, String bookdesc) {
		this.bookId = bookid;
		this.bookName = bookname;
		this.bookDesc = bookdesc;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public Date getBookCreated() {
		return bookCreated;
	}

	public void setBookCreated(Date bookCreated) {
		this.bookCreated = bookCreated;
	}

}
