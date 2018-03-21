package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Student;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Student> students = Student.getStudents();
		for (Student student : students) {
			if(request.getParameter("buttonUpdate_"+student.getStdid()) != null) {
				// Update Student
				int result = Student.updateStudent(
						Integer.parseInt(request.getParameter("stdid_"+student.getStdid())),
						request.getParameter("firstName_"+student.getStdid()),
						request.getParameter("lastName_"+student.getStdid()),
						request.getParameter("address_"+student.getStdid()),
						request.getParameter("city_"+student.getStdid()),
						request.getParameter("postalCode_"+student.getStdid()),
						request.getParameter("email_"+student.getStdid()),
						request.getParameter("program_"+student.getStdid()));
				if(result == 1) {
					System.out.println("Update Successful");
					response.sendRedirect("ListStudents");
				}
				else {
					System.out.println("Some error occurred");
					response.sendRedirect("ListStudents");
				}
				break;
			}
			if(request.getParameter("buttonDelete_"+student.getStdid()) != null) {
				// Delete Student
				int result = Student.deleteStudent(Integer.parseInt(request.getParameter("stdid_"+student.getStdid())));
				
				if(result == 1) {
					System.out.println("Delete Successful");
					response.sendRedirect("ListStudents");
				}
				else {
					System.out.println("Some error occurred");
					response.sendRedirect("ListStudents");
				}
				break;
			}
		}
	}
}
