<%-- 
    Document   : formtoupdate
    Created on : Jul 6, 2022, 6:04:50 PM
    Author     : Dimitrios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <h1>Please enter elements:</h1>
        
        <form action="trainer/doupdate" method="post"/>
            <input type="hidden" name="id" value="${trainertoupdate.id}"/>
            Firstname:<input type="text" name="firstname"value="${trainertoupdate.firstname}"/>
            LastName:<input type="text" name="lasttname"value="${trainertoupdate.lastname}"/>
            Email:<input type="text" name="email"value="${trainertoupdate.email}"/>
            <input type="submit"/>
        </form>
        
        
    </body>
</html>
