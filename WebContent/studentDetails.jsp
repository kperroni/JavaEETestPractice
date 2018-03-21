<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="ListStudents">List Students</a>
<form action="UpdateStudent" method="post">
<input type="text" name="stdid_${student.getStdid()}" value="${student.getStdid()}"/>
<input type="text" name="firstName_${student.getStdid()}" value="${student.getFirstName()}"/>
<input type="text" name="lastName_${student.getStdid()}" value="${student.getLastName()}"/>
<input type="text" name="address_${student.getStdid()}" value="${student.getAddress()}"/>
<input type="text" name="city_${student.getStdid()}" value="${student.getCity()}"/>
<input type="text" name="postalCode_${student.getStdid()}" value="${student.getPostalCode()}"/>
<input type="text" name="email_${student.getStdid()}" value="${student.getEmail()}"/>
<input type="text" name="program_${student.getStdid()}" value="${student.getProgram()}"/>
<input type="submit" name="buttonUpdate_${student.getStdid()}" value="Update Student"/>
<input type="submit" name="buttonDelete_${student.getStdid()}" value="Delete Student"/>
</form>
</body>
</html>