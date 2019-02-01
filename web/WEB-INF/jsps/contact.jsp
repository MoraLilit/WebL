<%--
  Created by IntelliJ IDEA.
  User: Mora Lilit
  Date: 1/31/2019
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Class.WorkWithDB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ListContact" value="<%=WorkWithDB.getData()%>"/>

<html>
<head>
    <title>Contact</title>
</head>
<body>
<table border="1">
    <tr><td>ID</td><td>Name</td><td>Number</td><td>Action</td></tr>
    <c:forEach var="row" items="${ListContact}">
        <tr>
            <c:forEach var="col" items="${row}">
                <td>${col}</td>
            </c:forEach>
            <td>
                <form>
                    <button name="par" value="${row.get(0)}">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<form method="get">
    <p></p>
    <input type="submit" name="par" value="add"/>
</form>
</body>
</html>
