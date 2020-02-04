package library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import library.beans.Book;


public class BookDao {

	public List<Book> getBookList() {
		List<Book> books = new ArrayList<Book>();
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement("select * from tbl_book");
				ResultSet result = statement.executeQuery();
				Book book = null;
				while (result.next()) {
					book = new Book();
					book.setBookId(result.getLong("book_id"));
					book.setBookName(result.getString("book_name"));
					book.setBookDesc(result.getString("book_desc"));
					book.setBookCreated(new Date(result.getTimestamp("date_created").getTime()));
					books.add(book);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return books;
	}
	
	public int addNewBook(Book book) {
		int result = 0;
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			String sql = "insert into tbl_book"
					+ "(book_name, book_desc,date_created) "
					+ " values(?,?,?)";
			if (connection != null) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, book.getBookName());
				statement.setString(2, book.getBookDesc());
				statement.setTimestamp(3,
						new java.sql.Timestamp(System.currentTimeMillis()));
				result = statement.executeUpdate();
			}
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return result;
	}

	

}
