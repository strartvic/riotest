<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 50%;
}
 
td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}
 
tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>
    <h1>${name}</h1>
</body>

<div>
   <table border="1">
      <tr>
         <th>Точки проката</th>
         <th>Действия</th>
      </tr>
      <c:forEach  items="${orgs}" var ="org">
         <tr>
             <td><a href="${pageContext.request.contextPath}/point-page/${point.name}">${org.name}</a></td>
             <td><a href="${pageContext.request.contextPath}/delete-point/${point.name}">Удалить</a></td>
         </tr>
      </c:forEach> 
   </table>
</div>
 
</html>