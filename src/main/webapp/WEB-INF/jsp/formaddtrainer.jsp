<%-- 
    Document   : formaddtrainer
    Created on : Jul 5, 2022, 8:25:43 PM
    Author     : Dimitrios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainers Elements</title>
    </head>
    <body>
        <h1>Trainers Form</h1>
        <form enctype="multipart/form-data" action="addTrainerController" method="post">
            
            FirstName:<input type="text" name="firstname"><!-- comment --><br>
            LastName:<input type="text" name="lastname"><!-- comment --><br>
            Email:<input type="text" name="email"><!-- comment --><br><!-- comment -->
            Insurance<input type="file" name="insurance">
            <input type="submit"><!-- comment -->
            
            
            
            
        </form>
    </body>
</html>
