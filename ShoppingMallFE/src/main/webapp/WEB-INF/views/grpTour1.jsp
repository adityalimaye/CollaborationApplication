<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
	<table id="example" class="table table-responsive table-stripped table-hover"
						cellspacing="0" width="60%">
						<thead>
							<tr
								style="background-color: #595959; color: #FAEBD7; text-align: center;"
								height="40px">


								
								<td>Name</td>
								<td>Description</td>
								<td>Price</td>
								<td>Book Tour</td>

							</tr>
						</thead>

					<tbody>
						<tr class="active" style="background-color: #C0C0C0; color: #1a1a1a; text-align: center;" height="30px">
								
								<td>A weekend Spot</td>
								<td>A chhota break 2 days tour</td>
								<td>46,000/-</td>
								<td><a href="memberShip" value="BookTour">Book Tour</a></td>
						</tr>

					</tbody>
					</table>
	</center>
</body>
</html>