package classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnector;

public class Student {
	
	private int stdid;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String postalCode;
	private String email;
	private String program;
	private static final String tableName = "student";
	
	public Student(String firstName, String lastName, String address, String city, String postalCode, String email,
			String program) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.email = email;
		this.program = program;
	}
	public Student(int stdid, String firstName, String lastName, String address, String city, String postalCode, String email,
			String program) {
		this.stdid = stdid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.email = email;
		this.program = program;
	}
	public Student(int stdid) {
		this.stdid = stdid;
	}

	public int getStdid() {
		return this.stdid;
	}

	public void setStdid(int stdid) {
		this.stdid = stdid;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}
	
	public static List<Student> getStudents() {
		try {
			List<Student> students = new ArrayList<Student>();
			Connection db = DatabaseConnector.getConnection();
			Statement statement = db.createStatement();
		    String query = "SELECT * FROM " + tableName;
		    ResultSet resultSet = statement.executeQuery(query);
		    while(resultSet.next()) {
		    	students.add(new Student(resultSet.getInt("stdid"), resultSet.getString("firstName"),
		    			resultSet.getString("lastName"), resultSet.getString("address"), resultSet.getString("city"),
		    			resultSet.getString("postalCode"), resultSet.getString("email"), resultSet.getString("program")));
		    }
		    db.close();
		    return students;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static Student getStudent(Student student) {
		try {
			Connection db = DatabaseConnector.getConnection();
			Statement statement = db.createStatement();
		    String query = "SELECT * FROM " + tableName + " WHERE stdid =" + " '"+student.getStdid()+"' ";
		    ResultSet resultSet = statement.executeQuery(query);
		    while(resultSet.next()) {
		    	student.setStdid(resultSet.getInt("stdid"));
		    	student.setFirstName(resultSet.getString("firstName"));
		    	student.setLastName(resultSet.getString("lastName"));
		    	student.setAddress(resultSet.getString("address"));
		    	student.setCity(resultSet.getString("city"));
		    	student.setPostalCode(resultSet.getString("postalCode"));
		    	student.setEmail(resultSet.getString("email"));
		    	student.setProgram(resultSet.getString("program"));		    	
		    }
		    db.close();
		    return student;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static int insertStudent(Student student) {
		try {
			Connection db = DatabaseConnector.getConnection();
			Statement statement = db.createStatement();
		    String query = "INSERT INTO " + tableName + ""
		    		+ "(firstName, lastName, address,"
		    		+ " city, postalCode, email, program)"
		    		+ " VALUES"
		    		+ "("+ " '"+student.getFirstName()+"' ,"
		    		+ ""+ " '"+student.getLastName()+"' ,"
		    		+ ""+ " '"+student.getAddress()+"' ,"
		    		+ ""+ " '"+student.getCity()+"' ,"
		    		+ ""+ " '"+student.getPostalCode()+"' ,"
		    		+ ""+ " '"+student.getEmail()+"' ,"
		    		+ ""+ " '"+student.getProgram()+"')";
		    int result = statement.executeUpdate(query);
		    db.close();
		    return result;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public static int deleteStudent(Student student) {
		try {
			Connection db = DatabaseConnector.getConnection();
			Statement statement = db.createStatement();
		    String query = "DELETE FROM " + tableName + 
		    		" WHERE stdid =" + " '"+student.getStdid()+"' ";
		    int result = statement.executeUpdate(query);
		    db.close();
		    return result;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public static int updateStudent(Student student) {
		try {
			Connection db = DatabaseConnector.getConnection();
			Statement statement = db.createStatement();
		    String query = "UPDATE " + tableName + " SET "
		    		+ "firstName ="+ " '"+student.getFirstName()+"' ,"
		    		+ "lastName ="+ " '"+student.getLastName()+"' ,"
		    		+ "address ="+ " '"+student.getAddress()+"' ,"
		    		+ "city ="+ " '"+student.getCity()+"' ,"
		    		+ "postalCode ="+ " '"+student.getPostalCode()+"' ,"
		    		+ "email ="+ " '"+student.getEmail()+"' ,"
		    		+ "program ="+ " '"+student.getProgram()+"' "
		    		+ " WHERE stdid =" + " '"+student.getStdid()+"' ";
		    int result = statement.executeUpdate(query);
		    db.close();
		    return result;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
}

