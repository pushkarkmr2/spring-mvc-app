<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en" >
  <head>
    <meta charset="UTF-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0" />
    <title>Users List</title>
    <link
      href="css/bootstrap.min.css"
      rel="stylesheet"
      type="text/css" />
  </head>
  <body>
    <div class="d-block px-3 py-2 text-center text-bold skippy purple-200">
      <a
        href="#"
        class="text-white text-decoration-none">
        User Management
      </a>
    </div>
    <div class="container">
      <table class="table table-success table-striped">
        <thead>
          <tr>
            <th scope="col">User Id</th>
            <th scope="col">Name</th>
            <th scope="col">Age</th>
            <th scope="col">Salary</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach
            var="user"
            items="${users}"
            varStatus="theCount">
            <tr>
              <td><c:out value="${user.id}" /></td>
              <td><c:out value="${user.name}" /></td>
              <td><c:out value="${user.age}" /></td>
              <td><c:out value="${user.salary}" /></td>
              <c:url var="editUser" value="/users/edit/${user.id}" ></c:url>
              <c:url var="deleteUser" value="/users/delete/${user.id}" ></c:url>
              <td>
  			  	<form action="${editUser}" method="get">
  			  	  <button type="submit">Edit</button>
  			  	</form>
  		      </td>
              <td>
			  	<form action="${deleteUser}" method="post">
			  	  <button type="submit">Delete</button>
			  	</form>
		      </td>
             </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

    <div class="container p-3 m-3" >
      <c:if test="${not empty errorMessage}">
        <div style="color: red">${errorMessage}</div>
      </c:if>

    <c:url var="addAction" value="/users/add/" ></c:url>
    <br>
      <p class="h2">Add User</p>
      <br>
      <form action="${addAction}" method="post"  style="background-color: lightblue;">
        <div class="mb-3">
          Name : <input type="text" name="name"><br><br>
          Age &nbsp; &nbsp; : <input type="number" name="age"><br><br>
          Salary : <input type="number" name="salary"><br>
        </div>
        <input
          type="submit"
          value="Add User" />
      </form>
    </div>
  </body>
</html>