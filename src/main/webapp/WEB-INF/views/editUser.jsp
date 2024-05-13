<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en" >
<head>
<title>Edit User</title>
 <link
      href="css/bootstrap.min.css"
      rel="stylesheet"
      type="text/css" />
</head>
<body>
    <h2>Edit User</h2>
     <c:url var="updateUser" value="/users/update/" ></c:url>
    <form action="${updateUser}" method="post">
        Id : <input name="id" value="${user.id}" disabled> <br><br>
            <input name="id" value="${user.id}" type="hidden">
        Name : <input name="name" value="${user.name}" > <br><br>
        Age : <input name="age" value="${user.age}" > <br><br>
        Salary : <input name="salary" value="${user.salary}" > <br><br>

        <input type="submit" value="Update User"/>
    </form>
</body>
</html>