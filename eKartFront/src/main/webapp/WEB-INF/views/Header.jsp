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
		<title>${title}</title>
	   <c:url value="/resources/assets/css" var="css"/>  
	    <c:url value="/resources/assets/js" var="js"/> 
	      <c:url value="/resources/assets/images/products" var="image"/>   
	   
		<link rel="stylesheet" type="text/css" href="${css}/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="${css}/bootstrap.min.css" />
		
		<link rel="stylesheet" type="text/css" href="${css}/jquery.dataTables.min.css" />
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 
 
 <script type="text/javascript">
 
 window.menu = '${title}';
 
 $(function() {
 	
 	switch(menu){
 		case 'Home':
 				$('#Home').addClass('active');
 				break;
 		case 'Product Details':
	 			$('#Home').addClass('active');
	 			break;		
 		case 'SignIn':
 			$('#SignIn').addClass('active');
 			break;
 			
 		case 'SignUp':
 			$('#SignUp').addClass('active');
 			break;
 			
 		case 'MyCart':
 			$('#Cart').addClass('active');
 			break;
 		case 'My Order':
 			$('#Cart').addClass('active');
 			break;	
 		case 'AddCategory':
 			$('#Category').addClass('active');
 			break;
 			
 		case 'ListOfCategory':
 			$('#Category').addClass('active');
 			break;
 			
 		case 'EditCategory':
 			$('#Category').addClass('active');
 			break;
 		
 			
 		case 'TrackOrder':
 			$('#Account').addClass('active');
 			break;
 		case 'Purchase History':
 			$('#Account').addClass('active');
 			break;
 			
 		case 'Mode Of Payment':
 			$('#Cart').addClass('active');
 			break;
 		case 'Invoice':
 			$('#Cart').addClass('active');
 			break;
 		case 'Product Table':
 			$('#Product').addClass('active');
 			break;
 		case 'Product Form':
 			$('#Product').addClass('active');
 			break;
 		case 'Supplier Form':
 			$('#Supplier').addClass('active');
 			break;
 		case 'Supplier Table':
 			$('#Supplier').addClass('active');
 			break;
 		default:
 			$('#Home').addClass('active');
 			break;
 	}
 	
 });
 	

 
 </script>
		
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
		
		<c:if test="${userClickedMyKart == 'true' || orderItemList == 'true'}">
		<link rel="stylesheet" type="text/css" href="${css}/myKart.css" />
		</c:if>
		
		
		<c:if test="${placeOrderClicked == 'true'}">
		<link rel="stylesheet" type="text/css" href="${css}/shipping.css" />
		</c:if>
		
		<c:if test="${not empty RecentlyViewed}">
		<link rel="stylesheet" type="text/css" href="${css}/recentlyViewed.css" />
		</c:if>
		
		<c:if test="${paymentPage == 'true'}">
		<link rel="stylesheet" type="text/css" href="${css}/payment.css" />
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