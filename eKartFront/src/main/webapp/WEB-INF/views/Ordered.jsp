
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<div class="shopping-cart">
      <!-- Title -->
      <div class="title">
        <div style="float: left;">Order Bag</div> 
        <div style="float: right;color: red;">
          <c:if test="${not empty order}">
       	${order}
        </c:if>
        </div> 
        <div style="clear: both;"></div> 
      </div>
 
    <!--heading-->
   
      <!-- Product #1 -->
        <c:if test="${fn:length(customerOrder.customerOrderItems) > 0}">
         <c:forEach items="${customerOrder.customerOrderItems}" var="order" varStatus="status">
         <c:if test="${order.status == 'PENDING'}">
      <div class="item">
       
 
        <div class="image">
           <img src="${image}/${order.product.productName}_${order.product.productCode}/${order.product.productCode}_${order.product.id}_1.jpg" alt="" width="75" height="75"/>
        </div>
 
        <div class="description">
          <span><a href="${productDetails}/${order.product.id}">${order.product.productName}</a></span>
           <span>${order.product.category.categoryName}</span>
        <!--  <span>White</span> -->
        </div>
 
         <div class="quantity">
        <c:url value="/user/order/plus" var="plus"/>  
          <button class="plus-btn" type="button" name="button">
          <a href="${plus}/${order.id}"><span class="glyphicon glyphicon-plus"></span></a>
          </button>
          <c:url value="/user/order/minus" var="minus"/>  
          <input type="text" name="name" value="${order.quantity}">
          <button class="minus-btn" type="button" name="button">
           <a href="${minus}/${order.id}"> <span class="glyphicon glyphicon-minus"></span></a>
          </button>
        </div>
 
 
         <div class="total-price">
        <c:if test="${order.product.offer == 0 }">
        $${order.product.price}
        </c:if>
        <c:if test="${order.product.offer > 0 }">
        $${order.product.price - (order.product.price * (order.product.offer)/100)}
        </c:if>
        </div>
        
        
           <div class="total-price">$${order.totalprice}</div>
          
           <c:url value="/remove/order" var="removeOrder"/>
          <div class="total-price"><a href="${removeOrder}/${order.id}" style="text-decoration: none;">Remove</a></div>
      </div>
 </c:if>
     </c:forEach>
      <div style="height: 70px;">
 <h3 style="float: right;margin-right: 7em;">Grand Total : $${customerOrder.gTotal} </h3>
 </div>
     
     </c:if>
      <c:if test="${fn:length(customerOrder.customerOrderItems) == 0}">
 <div style="height: 100px;">
<h1 style="color: red; text-align: center;">Your Order Bag is empty</h1>
 </div>
  <div style="height: 70px;">
 <h3 style="float: right;margin-right: 7em;">Go To Cart</h3>
 </div>
 </c:if>
     

    </div>
    
    <c:if test="${fn:length(customerOrder.customerOrderItems) > 0 }">
  <c:url value="/user/payment" var="payment"/>    
    <a href="${payment}" class="btn btn-lg btn-success" style="float: right;">Payment</a>
    </c:if>