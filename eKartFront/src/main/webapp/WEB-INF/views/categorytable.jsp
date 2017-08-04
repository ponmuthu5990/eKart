<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<link
	href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	$(document).ready(function(){
		var searchCondition=  '${searchCondition}';
		$('.table').DataTable({
			"lengthMenu" :[ [ 3, 5, 7, -1 ], [ 3, 5, 7, "All" ] ],
			"oSearch" : {
				"sSearch" : searchCondition
			}
		})
	});
</script>
</head>
<body style="margin-top: 10em;">

	<table>
		<tr>
			<td>Category Name</td>
			<td>Category Desc</td>
			<td>Category id</td>
		</tr>
		<c:forEach items="${categoryList}" var="category" varStatus="status">
			<tr>
				<td>${category.categoryName}</td>
				<td>${category.desc}</td>
				<td>${category.categoryId}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>