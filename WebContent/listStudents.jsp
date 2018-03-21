<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listing Students</title>
</head>
<body>
<a href="addStudent.html">Add new Student</a>
<a href="searchStudent.html">Search for Student</a>
<form action="UpdateStudent" method="post">
<table>
    <tr>
        <th>Student ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Address</th>
        <th>City</th>
        <th>Postal Code</th>
        <th>Email</th>
        <th>Program</th>
    </tr>
<c:forEach items="${requestScope.students}" var="student">
    <tr>
        <td>
            <input type="text" name="stdid_${student.getStdid()}" value="${student.getStdid()}"/>
        </td>
        <td>
            <input type="text" name="firstName_${student.getStdid()}" value="${student.getFirstName()}"/>
        </td>
        <td>
            <input type="text" name="lastName_${student.getStdid()}" value="${student.getLastName()}"/>
        </td>
        <td>
            <input type="text" name="address_${student.getStdid()}" value="${student.getAddress()}"/>
        </td>
        <td>
            <input type="text" name="city_${student.getStdid()}" value="${student.getCity()}"/>
        </td>
        <td>
            <input type="text" name="postalCode_${student.getStdid()}" value="${student.getPostalCode()}"/>
        </td>
        <td>
            <input type="text" name="email_${student.getStdid()}" value="${student.getEmail()}"/>
        </td>
        <td>
            <input type="text" name="program_${student.getStdid()}" value="${student.getProgram()}"/>
        </td>
        <td>
            <input type="submit" name="buttonUpdate_${student.getStdid()}" value="Update Student"/>
        </td>
        <td>
            <input type="submit" name="buttonDelete_${student.getStdid()}" value="Delete Student"/>
        </td>
    </tr>
    </c:forEach>
</table>
</form>
</body>
</html>