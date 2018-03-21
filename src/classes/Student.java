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
	
	public static Student getStudent(int stdid) {
		try {
			Student student = null;
			Connection db = DatabaseConnector.getConnection();
			Statement statement = db.createStatement();
		    String query = "SELECT * FROM " + tableName + " WHERE stdid =" + " '"+stdid+"' ";
		    ResultSet resultSet = statement.executeQuery(query);
		    while(resultSet.next()) {
		    	student = (new Student(resultSet.getInt("stdid"), resultSet.getString("firstName"),
		    			resultSet.getString("lastName"), resultSet.getString("address"), resultSet.getString("city"),
		    			resultSet.getString("postalCode"), resultSet.getString("email"), resultSet.getString("program")));
		    }
		    db.close();
		    return student;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static int insertStudent(String firstName, String lastName, 
			String address, String city, String postalCode, String email, String program) {
		try {
			Connection db = DatabaseConnector.getConnection();
			Statement statement = db.createStatement();
		    String query = "INSERT INTO " + tableName + ""
		    		+ "(firstName, lastName, address,"
		    		+ " city, postalCode, email, program)"
		    		+ " VALUES"
		    		+ "("+ " '"+firstName+"' ,"
		    		+ ""+ " '"+lastName+"' ,"
		    		+ ""+ " '"+address+"' ,"
		    		+ ""+ " '"+city+"' ,"
		    		+ ""+ " '"+postalCode+"' ,"
		    		+ ""+ " '"+email+"' ,"
		    		+ ""+ " '"+program+"')";
		    int result = statement.executeUpdate(query);
		    db.close();
		    return result;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public static int deleteStudent(int stdid) {
		try {
			Connection db = DatabaseConnector.getConnection();
			Statement statement = db.createStatement();
		    String query = "DELETE FROM " + tableName + 
		    		" WHERE stdid =" + " '"+stdid+"' ";
		    int result = statement.executeUpdate(query);
		    db.close();
		    return result;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public static int updateStudent(int stdid, String firstName, String lastName, 
			String address, String city, String postalCode, String email, String program) {
		try {
			Connection db = DatabaseConnector.getConnection();
			Statement statement = db.createStatement();
		    String query = "UPDATE " + tableName + " SET "
		    		+ "firstName ="+ " '"+firstName+"' ,"
		    		+ "lastName ="+ " '"+lastName+"' ,"
		    		+ "address ="+ " '"+address+"' ,"
		    		+ "city ="+ " '"+city+"' ,"
		    		+ "postalCode ="+ " '"+postalCode+"' ,"
		    		+ "email ="+ " '"+email+"' ,"
		    		+ "program ="+ " '"+program+"' "
		    		+ " WHERE stdid =" + " '"+stdid+"' ";
		    int result = statement.executeUpdate(query);
		    db.close();
		    return result;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
}

