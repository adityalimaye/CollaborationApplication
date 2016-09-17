<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 <%-- <div style="color: teal; font-size: 30px">Product Details</div>

   <c:if test="${!empty productList}"> 
   <table border="1" bgcolor="black" width="600px">
    <tr
     style="background-color: teal; color: white; text-align: center;"
     height="40px">
     
     <td>Id</td>
     <td>Name</td>
     <td>Description</td>
     <td>Price</td>
     <td>Edit</td>
     <td>Delete</td>
    </tr>
    <c:forEach items="${productList}" var="product">
     <tr
      style="background-color: white; color: black; text-align: center;"
      height="30px">
      
      <td><c:out value="${product.id}" />
      </td>
      <td><c:out value="${product.name}" />
      </td>
      <td><c:out value="${product.description}" />
      </td>
      <td><c:out value="${product.price}" />
      </td>
      <td><a href="Edit?id=${product.id}">Edit</a></td>
      <td><a href="Delete?id=${product.id}">Delete</a></td>
     </tr>
    </c:forEach>
   </table>
   </c:if> --%>


  <a href="AddProduct">Click Here to add new Product</a>


</body>
</html>