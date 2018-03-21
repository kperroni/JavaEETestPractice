<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateStudent" method="post">
<input type="text" name="stdid" value="${selectedStudent.getStdid()}"/>
<input type="text" name="firstName" value="${selectedStudent.getFirstName()}"/>
<input type="text" name="lastName" value="${selectedStudent.getLastName()}"/>
<input type="text" name="address" value="${selectedStudent.getAddress()}"/>
<input type="text" name="city" value="${selectedStudent.getCity()}"/>
<input type="text" name="postalCode" value="${selectedStudent.getPostalCode()}"/>
<input type="text" name="email" value="${selectedStudent.getEmail()}"/>
<input type="text" name="program" value="${selectedStudent.getProgram()}"/>
<input type="submit" value="Update Student"/>
<input type="submit" value="Delete Student"/>
</form>
</body>
</html>