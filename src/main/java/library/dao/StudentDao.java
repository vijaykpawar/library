package library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import library.beans.Book;
import library.beans.IssueBookVO;
import library.beans.Student;
/**
 * 
 * @author Rohini Pawar
 *
 */
public class StudentDao {
	
	/**
	 * 
	 * @param student
	 * @return 
	 * Add new student into database 
	 * 
	 */
	public int addNewStudent(Student student) {
		int result = 0;
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			String sql = "insert into tbl_student"
					+ "(first_name, last_name,student_class,address, mobile, email, date_created) "
					+ " values(?,?,?,?,?,?,?)";
			if (connection != null) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, student.getFirstName());
				statement.setString(2, student.getLastName());
				statement.setString(3, student.getStudentClass());
				statement.setString(4, student.getStudentAddress());
				statement.setString(5, student.getMobile());
				statement.setString(6, student.getEmail());
				statement.setTimestamp(7,
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
	
	private List<Student> getStudentList(String sql){
		List<Student> students = new ArrayList<Student>();
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement(sql);
				ResultSet result = statement.executeQuery();
				Student student = null;
				while (result.next()) {
					student = new Student();
					student.setStudentId(result.getLong("student_id"));
					student.setFirstName(result.getString("first_name"));
					student.setLastName(result.getString("last_name"));
					student.setStudentClass(result.getString("student_class"));
					student.setStudentAddress(result.getString("address"));
					student.setMobile(result.getString("mobile"));
					student.setEmail(result.getString("email"));
					student.setDateCreated(new Date(result.getTimestamp("date_created").getTime()));
					students.add(student);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return students;
	}
	/**
	 * 
	 * @return
	 * 
	 * 
	 * gets list of students present in database 
	 */
	public List<Student> listStudents() {
		String sql ="select * from tbl_student";
		return getStudentList(sql);
	}
	
	public static void main(String[] args) {
		Student student=new Student();
		student.setFirstName("vijay");
		System.out.println(new StudentDao().searchStudent(student));
		
	}
	private String getUpper(String s){
		if(s!=null && !"".equals(s.trim()))
			return s.toUpperCase();
	return null;
	}
	public List<Student> searchStudent(Student search) {
		String sql="select * from tbl_student where upper(first_name) like ? or upper(last_name) like ?";

		List<Student> students = new ArrayList<Student>();
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement(sql);
			
				statement.setString(1, getUpper(search.getFirstName())+"%");
				statement.setString(2, getUpper(search.getLastName())+"%");
				ResultSet result = statement.executeQuery();
				Student student = null;
				while (result.next()) {
					student = new Student();
					student.setStudentId(result.getLong("student_id"));
					student.setFirstName(result.getString("first_name"));
					student.setLastName(result.getString("last_name"));
					student.setStudentClass(result.getString("student_class"));
					student.setStudentAddress(result.getString("address"));
					student.setMobile(result.getString("mobile"));
					student.setEmail(result.getString("email"));
					student.setDateCreated(new Date(result.getTimestamp("date_created").getTime()));
					students.add(student);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return students;	
	}

	public List<Book> searchBook(Book search) {
		String sql="select * from tbl_book where upper(book_name) like ?";
		List<Book> books = new ArrayList<Book>();
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement(sql);
			
				statement.setString(1, getUpper(search.getBookName())+"%");
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

	public int  issueBook(Student student, Book book) {

		int result = 0;
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			String sql = "insert into tbl_issue"
					+ "(book_id, student_id, date_issue) "
					+ " values(?,?,?)";
			if (connection != null) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setLong(1, book.getBookId());
				statement.setLong(2, student.getStudentId());
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
	public List<IssueBookVO> issuedBooks(){
		String sql="select i.issue_id,b.book_name,s.first_name,s.last_name,s.mobile,s.email,i.date_issue "
				+ "from tbl_book b, tbl_student s, tbl_issue i "+ 
				" where "+ 
				" b.book_id=i.book_id and "+ 
				" s.student_id=i.student_id";
		List<IssueBookVO> issuedBooks = new ArrayList<IssueBookVO>();
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement(sql);
			
				ResultSet result = statement.executeQuery();
				IssueBookVO issuedBook = null;
				while (result.next()) {
					issuedBook = new IssueBookVO();
					issuedBook.setIssueId(result.getLong("issue_id"));
					issuedBook.setBookName(result.getString("book_name"));
					issuedBook.setFirstName(result.getString("first_name"));
					issuedBook.setLastName(result.getString("last_name"));
					issuedBook.setMobile(result.getString("mobile"));
					issuedBook.setEmail(result.getString("email"));
					issuedBook.setDateIssue(new Date(result.getTimestamp("date_issue").getTime()));
					issuedBooks.add(issuedBook);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return issuedBooks;	

	}
	
	
}
