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
    <h1>Формирование отчета</h1>
</body>

<div>
<form action="${pageContext.request.contextPath}/" method="POST" >
<p> Выберете организации: </p>
<p>
   <select size="5" multiple name="orgs[]" required>
      <c:forEach  items="${orgs}" var ="org">
         <option value="${org.id}">${org.name}</option>
      </c:forEach>
   </select></p>
   
<p> Выберете счета: </p>
<p> 
   <select size="5" multiple name="bills[]" required>
      <c:forEach  items="${bills}" var ="bill">
         <option value="${bill.id}">${bill.name}</option>
      </c:forEach>
   </select></p>


<p> Выберете показатели: </p>
<p> 
   <select size="5" multiple name="inds[]" required>
      <c:forEach  items="${inds}" var ="ind">
         <option value="${ind}">${ind}</option>
      </c:forEach>
   </select></p>


<p> 
   <label>Каталог отчета</label> 
   <input type="text" name="dirPath" value="D:"> 
   <input type="submit" value="Создать отчет">
</p>
</form> 

<form enctype="multipart/form-data" method="post">
   <p><input type="file" name="f" value="D:">
   <input type="submit" value="Отправить"></p>
</form> 
</div>

 
</html>