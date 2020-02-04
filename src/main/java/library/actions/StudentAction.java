package library.actions;

import java.util.ArrayList;
import java.util.List;

import library.beans.Book;
import library.beans.IssueBookVO;
import library.beans.Student;
import library.dao.StudentDao;

import com.opensymphony.xwork2.ActionSupport;
/**
 * @author Rohini Pawar
 */
public class StudentAction extends ActionSupport
{

	private static final long serialVersionUID = 1L;

	private List<Student>  studentList=new ArrayList<Student>();
	
	private List<Book>  bookList=new ArrayList<Book>();
	
	private List<IssueBookVO>  issedBooks=new ArrayList<IssueBookVO>();
	
	private Student student;
	
	private Book book;
	
	public String prepareAddStudent(){
		return SUCCESS;
	}
	public String listStudents(){
		studentList=new StudentDao().listStudents();		
		return SUCCESS;
	}
	public String addEditStudent(){
		
		StudentDao studentDao=new StudentDao();
		if(student!=null && student.getStudentId() ==null){
			// add new student 
			int result= studentDao.addNewStudent(student);
			studentList=studentDao.listStudents();
			addActionMessage("Student Successfully added");
		}else{
			//student edit case 	
		}
		return SUCCESS;
	}
	
	public void validateAddEditStudent(){
		if(student!=null){
			if("".equals(student.getFirstName())){
				addFieldError("student.firstName", "Please enter first name");
			}else if(student.getFirstName().trim().length()==0 ){
				addFieldError("student.firstName", "Please enter valid first name");
			}
			
			if("".equals(student.getLastName())){
				addFieldError("student.lastName", "Please enter last name");
			}else if(student.getLastName().trim().length()==0 ){
				addFieldError("student.lastName", "Please enter valid last name");
			}
			
			if("".equals(student.getEmail())){
				addFieldError("student.email", "Please enter Email Id");
			}else if(student.getEmail().trim().length()==0 ){
				addFieldError("student.email", "Please enter valid Email Id");
			}
			
		}
	}
	public String prepareIssue(){
		return SUCCESS;
	}
	
	public String searchStudent(){
		
		StudentDao studentDao=new StudentDao();
		if(student!=null && student.getStudentId() !=null && student.getStudentId()>0 ){
			// issue book to this student
			return "student";
		}else{
			studentList=studentDao.searchStudent(student);	
		}
		return SUCCESS;
	}
		public String searchBook(){
		
		StudentDao studentDao=new StudentDao();
		if(book!=null && book.getBookId() !=null && book.getBookId() >0){
			// issue book to this student
			studentDao.issueBook(student,book);
			issedBooks=studentDao.issuedBooks();
			addActionMessage("Book Issued successfully");
			return "issued";
		}else{
			bookList=studentDao.searchBook(book);	
		}
		return SUCCESS;
	}
	
		public String issedBooks(){
			issedBooks=new StudentDao().issuedBooks();
			return SUCCESS;
		}
		
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	public List<IssueBookVO> getIssedBooks() {
		return issedBooks;
	}
	public void setIssedBooks(List<IssueBookVO> issedBooks) {
		this.issedBooks = issedBooks;
	}
	
}
