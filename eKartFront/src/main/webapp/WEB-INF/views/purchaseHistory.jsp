 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<style>

.table-responsive{
margin-top:25px;
}
</style>
  <h2 style="margin-top: 3em; text-align: center;">Purchase History</h2>
   <c:if test="${not empty shipment}">
<div class="container">
	<div class="row">
		<div class="table-responsive">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th>#</th>
            <th>Product Name</th>
           
            <th>Date</th>
            <th>Price</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
           <c:forEach items="${shipment.customerOrderItems}" var="order" varStatus="status">
          <tr>
            <td>${status.count}</td>
             <td><a href="http://www.mirchu.net/mobiles/apple-iphone-6/" target="_blank">${order.product.productName}</a></td>
          <td>${shipment.deliveryDate}</td>
 
              <td>$${order.totalprice}</td>
            <td><span class="label label-primary">Completed</span></td>
          </tr>
         </c:forEach>
        </tbody>
      </table>
    </div>
	</div>
</div>
</c:if>
   <c:if test="${empty shipment}">
   <h2 style="margin-top: 3em; text-align: center;">No history entries found</h2>
   
   </c:if>