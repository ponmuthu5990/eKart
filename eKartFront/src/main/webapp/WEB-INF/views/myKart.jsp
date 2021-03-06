<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<div class="shopping-cart">
      <!-- Title -->
      <div class="title">
        <div style="float: left;">Shopping Bag</div> 
        <div style="float: right;color: red;">
          <c:if test="${not empty product}">
       	${product}
        </c:if>
        </div> 
        <div style="clear: both;"></div> 
      </div>
 
    <!--heading-->
   
      <!-- Product #1 -->
      <c:if test="${fn:length(cartList.cartitems) > 0}">
        <c:set var = "statusCheck" scope = "session" value = "0"/>
         <c:set var = "grandTotal" scope = "session" value = "0"/>
      <c:forEach items="${cartList.cartitems}" var="cart" varStatus="status">
      
   
    
      <div class="item">
       
 
        <div class="image">
          <img src="${image}/${cart.products.productName}_${cart.products.productCode}/${cart.products.productCode}_${cart.products.id}_1.jpg" alt="" width="75" height="75"/>
        </div>
 
        <div class="description">
          <span><a href="${productDetails}/${cart.products.id}">${cart.products.productName}</a></span>
           <span>${cart.products.category.categoryName}</span>
        <!--  <span>White</span> -->
        </div>
 
 		<c:if test="${cart.products.quantity > 0 && cart.products.status}">
   <c:set var = "grandTotal"  value = "${grandTotal + cart.totalprice}"/>  
        <div class="quantity">
        <c:url value="/user/plus" var="plus"/>  
          <button class="plus-btn" type="button" name="button">
          <a href="${plus}/${cart.id}"><span class="glyphicon glyphicon-plus"></span></a>
          </button>
          <c:url value="/user/minus" var="minus"/>  
          <input type="text" name="name" value="${cart.quantity}">
          <button class="minus-btn" type="button" name="button">
           <a href="${minus}/${cart.id}"> <span class="glyphicon glyphicon-minus"></span></a>
          </button>
        </div>
 
        <div class="total-price">
        <c:if test="${cart.products.offer == 0 }">
        $${cart.products.price}
        </c:if>
        <c:if test="${cart.products.offer > 0 }">
        $${cart.products.price - (cart.products.price * (cart.products.offer)/100)}
        </c:if>
        </div>
          
           <div class="total-price">$${cart.totalprice}</div>
           </c:if>
         <c:if test="${cart.products.quantity == 0 || not cart.products.status}">
          <c:set var = "statusCheck"  value = "${statusCheck + 1}"/>    
          <div class="quantity">
          <h2 style="color: red;">Out Of Stack</h2>
          </div>
         </c:if>
          <c:url value="/remove/cart" var="removeKart"/>
          <div class="total-price"><a href="${removeKart}/${cart.id}" style="text-decoration: none;">Remove</a></div>
      </div>
 </c:forEach>
 
  <c:if test="${fn:length(cartList.cartitems) > 0 && fn:length(cartList.cartitems) != statusCheck }">
  <div style="height: 70px;">
 <h3 style="float: right;margin-right: 7em;">Grand Total : $${grandTotal} </h3>
 </div>
 </c:if>
 
 
    </c:if>
 <c:if test="${fn:length(cartList.cartitems) == 0}">
 <div style="height: 100px;">
<h1 style="color: red; text-align: center;">Your Shopping Cart is empty</h1>
 </div>
 </c:if>
     
    </div>
  <%--   ${statusCheck} --%>
        <c:if test="${fn:length(cartList.cartitems) > 0 && fn:length(cartList.cartitems) != statusCheck }">
  <c:url value="/user/placeOrder" var="order"/>    
    <a href="${order}" class="btn btn-lg btn-success" style="float: right;">Place Order</a>
    </c:if>
