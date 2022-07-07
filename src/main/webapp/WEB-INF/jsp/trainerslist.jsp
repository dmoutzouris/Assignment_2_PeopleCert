<%-- 
    Document   : trainerlist
    Created on : Jul 6, 2022, 10:06:14 AM
    Author     : Dimitrios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainer List</title>
    </head>
    <body>
        <h1>All Trainers</h1>

      


        

<table class="table table-dark table-hover">
  <thead>
    <tr >
     
      <th scope="col-4">id</th>
      <th scope="col-4">First Name</th>
      <th scope="col-2">Last Name</th>
      <th scope="col-1">Email</th>
      <th scope="col-1">Actions</th>
      <th scope="col-1">Download</th>
    </tr>
  </thead>
  <tbody>
      <c:forEach items="${alltrainers}"  var="trainer">
          
          <tr>
      
      <td>${trainer.id}</td>
      <td>${trainer.firstname}</td>
      <td>${trainer.lastname}</td>
      <td>${trainer.email}</td>
      <td><a class="btn btn-outline-danger"
             href="trainer/update/${trainer.id}">Update</a></td>
      <td><a class="btn btn-outline-warning"
             href="trainer/delete/${trainer.id}">Delete</a></td>
             <td><a class="btn btn-outline-warning"
             href="trainer/download/${trainer.id}"target="_blank"> ${trainer.insurancefilename}</a></td>
    </tr> 
      </c:forEach>
   
    
  </tbody>
</table>


    </body>
</html>
