<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Line Menu Styles</title>
	   <c:url value="/resources/assets/css" var="css"/>  
	    <c:url value="/resources/assets/js" var="js"/> 
	      <c:url value="/resources/assets/images/products" var="image"/>   
	   
		<link rel="stylesheet" type="text/css" href="${css}/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="${css}/bootstrap.min.css" />
		
		<link rel="stylesheet" type="text/css" href="${css}/jquery.dataTables.min.css" />
		
		
		
		<!-- Slider -->
		 <c:url value="/resources/engine1" var="slider"/>
		<link rel="stylesheet" type="text/css" href="${slider}/style.css" />
		<script type="text/javascript" src="${slider}/jquery.js"></script>		
		<!-- Navbar -->
		<!-- <link rel="stylesheet" type="text/css" href="resources/assets/css/demo.css" />
		<link rel="stylesheet" type="text/css" href="resources/assets/css/component.css" />
		 -->
		<!--listOFItems -->
		<link rel="stylesheet" type="text/css" href="${css}/moviePoster.css" />
		
		<!-- login and singUp -->
		<c:if test="${logInClicked == 'true' || SignUpInClicked == 'true'}">
		<link rel="stylesheet" type="text/css" href="${css}/login.css" />
		</c:if>
		
		<!-- supplier form style -->
		<c:if test="${adminClickedViewSupplier == 'true' || adminClickedAddSupplier == 'true'}">
		<link rel="stylesheet" type="text/css" href="${css}/supplierForm.css" />
		</c:if>
		
		
		<!-- category form style -->
		<c:if test="${adminClickedAddCategory == 'true'}">
		
		<link rel="stylesheet" type="text/css" href="${css}/categoryForm.css" />
		</c:if>
		
		<!-- category form style -->
		<c:if test="${adminClickedViewProduct == 'true'}">
		
		<link rel="stylesheet" type="text/css" href="${css}/productTable.css" />
		</c:if>
		
		<!-- product details form style -->
		<c:if test="${userClickedProduct == 'true'}">
	<%-- 	<link rel="stylesheet" type="text/css" href="${css}/productDetails.css" /> --%>		
		</c:if>
		
		<c:if test="${userClickedMyKart == 'true'}">
		<link rel="stylesheet" type="text/css" href="${css}/myKart.css" />
		</c:if>
		
		
		<c:if test="${placeOrderClicked == 'true'}">
		<link rel="stylesheet" type="text/css" href="${css}/shipping.css" />
		</c:if>
		
		<c:if test="${not empty RecentlyViewed}">
		<link rel="stylesheet" type="text/css" href="${css}/recentlyViewed.css" />
		</c:if>
		<!-- AngularJs -->
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
		
		<script type="text/javascript">
		var app = angular.module('myApp',[]);
		</script>
		
		<!--[if IE]>
			<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
	</head>
	<body  ng-app="myApp" style="padding: 2px 30px 0px 30px;">
	 <c:url value="/all/productDetails" var="productDetails"/>  