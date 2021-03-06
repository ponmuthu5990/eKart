<%@include file="/WEB-INF/views/Header.jsp"%>
<%@include file="/WEB-INF/views/NavBar.jsp"%>


<c:choose>

	<c:when test="${logInClicked == 'true'}">
		<%@include file="/WEB-INF/views/LogIn.jsp"%>
	</c:when>
	<c:when test="${SignUpInClicked == 'true'}">
		<%@include file="/WEB-INF/views/SignUp.jsp"%>
	</c:when>
	<c:when test="${userClickedProduct == 'true'}">
		<%@include file="/WEB-INF/views/ProductDetails.jsp"%>
	</c:when>

	<c:when test="${adminClickedAddCategory == 'true'}">
		<%@include file="/WEB-INF/views/CategoryForm.jsp"%>
	</c:when>
	<c:when test="${adminClickedAddSupplier == 'true'}">
		<%@include file="/WEB-INF/views/SupplierForm.jsp"%>
	</c:when>
	<c:when test="${adminClickedAddProduct == 'true'}">
		<%@include file="/WEB-INF/views/ProductForm.jsp"%>
	</c:when>
	<c:when test="${adminClickedViewCategory == 'true'}">
		<%@include file="/WEB-INF/views/ViewCategory.jsp"%>
	</c:when>
	<c:when test="${adminClickedViewSupplier == 'true'}">
		<%@include file="/WEB-INF/views/ViewSupplier.jsp"%>
	</c:when>
	<c:when test="${adminClickedViewProduct == 'true'}">
		<%@include file="/WEB-INF/views/ViewProduct.jsp"%>
	</c:when>
				
	
	<c:when test="${userClickedMyKart == 'true'}">
		<%@include file="/WEB-INF/views/myKart.jsp"%>
	</c:when>
	<c:when test="${placeOrderClicked == 'true'}">
		<%@include file="/WEB-INF/views/Shipping.jsp"%>
		</c:when>
	<c:when test="${orderItemList == 'true'}">
		<%@include file="/WEB-INF/views/Ordered.jsp"%>
	</c:when>
	<c:when test="${paymentPage == 'true'}">
		<%@include file="/WEB-INF/views/Payment.jsp"%>
	</c:when>
	<c:when test="${invoicePage == 'true'}">
		<%@include file="/WEB-INF/views/Invoice.jsp"%>
	</c:when>
	<c:when test="${orderTrackPage == 'true'}">
		<%@include file="/WEB-INF/views/TrackOrder.jsp"%>
	</c:when>
	<c:when test="${purchaseHistoryPage == 'true'}">
		<%@include file="/WEB-INF/views/purchaseHistory.jsp"%>
	</c:when>
	<c:otherwise>
		<%@include file="/WEB-INF/views/Carousel.jsp"%>
		<%@include file="/WEB-INF/views/listOfItems.jsp"%>
	</c:otherwise>
</c:choose>


<%@include file="/WEB-INF/views/Footer.jsp"%>

