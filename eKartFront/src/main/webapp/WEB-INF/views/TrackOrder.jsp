 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  <c:url value="/user/checkOrderStatus" var="orderStatus"/>  
  <h2 style="margin-top: 3em; text-align: center;">Track Your Order</h2>
  <div class="form-horizontal">
  <form action="${orderStatus}" method="post">
                <div class="form-group">
                    <label for="inputOrderTrackingID" class="col-sm-2 control-label">Order id</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputOrderTrackingID" name="orderTrackingID" value="" placeholder="# put your order id here">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10" style="text-align: center;">
                        <button type="submit" id="shopGetOrderStatusID" class="btn btn-success">Get status</button>
                    </div>
                </div>
  </form>
  </div>
  <style>
  .table-responsive{
  margin-top:25px;
  }
  ol.progtrckr {
    margin: 0;
    padding: 0;
    list-style-type none;
}

ol.progtrckr li {
    display: inline-block;
    text-align: center;
    line-height: 3.5em;
}

ol.progtrckr[data-progtrckr-steps="2"] li { width: 49%; }
ol.progtrckr[data-progtrckr-steps="3"] li { width: 33%; }
ol.progtrckr[data-progtrckr-steps="4"] li { width: 24%; }
ol.progtrckr[data-progtrckr-steps="5"] li { width: 19%; }
ol.progtrckr[data-progtrckr-steps="6"] li { width: 16%; }
ol.progtrckr[data-progtrckr-steps="7"] li { width: 14%; }
ol.progtrckr[data-progtrckr-steps="8"] li { width: 12%; }
ol.progtrckr[data-progtrckr-steps="9"] li { width: 11%; }

ol.progtrckr li.progtrckr-done {
    color: black;
    border-bottom: 4px solid yellowgreen;
}
ol.progtrckr li.progtrckr-todo {
    color: silver; 
    border-bottom: 4px solid silver;
}

ol.progtrckr li:after {
    content: "\00a0\00a0";
}
ol.progtrckr li:before {
    position: relative;
    bottom: -2.5em;
    float: left;
    left: 50%;
    line-height: 1em;
}
ol.progtrckr li.progtrckr-done:before {
    content: "\2713";
    color: white;
    background-color: yellowgreen;
    height: 2.2em;
    width: 2.2em;
    line-height: 2.2em;
    border: none;
    border-radius: 2.2em;
}
ol.progtrckr li.progtrckr-todo:before {
    content: "\039F";
    color: silver;
    background-color: white;
    font-size: 2.2em;
    bottom: -1.2em;
}

  
  </style>
  
  <c:if test="${not empty shipment}">
    <h2 style="text-align: center;">Order Id : ${shipment.orderTrackingId}</h2>
    <div class="row">
    <h3 style="float: left;">Date of Purchased : ${shipment.addDate}</h3>
     <h3 style="float: right;">Delivery Date : On or Before ${shipment.deliveryDate}</h3>
     <div style="clear: both;"></div>
    </div>
    
  <div class="container">
	<div class="row">
		<div class="table-responsive">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th>#</th>
            <th>Product Name</th>
            <th>Full Name</th>
          <!--  <th>Days Left</th>
            <th>Expected Date</th> -->
            <th>Price</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${shipment.customerOrderItems}" var="order" varStatus="status">
          <tr>
            <td>${status.count}</td>
            <td><a href="http://www.mirchu.net/mobiles/apple-iphone-6/" target="_blank">${order.product.productName}</a></td>
            <td>${order.customerOrder.customer.user.username}</td>
           <%-- <td>${shipment.days}</td>
            <td>${shipment.deliveryDate}</td> --%>
            <td>$${order.totalprice}</td>
            <c:if test="${order.status == 'MOVETOSHIPPED'}">
            <td><span class="label label-info">Processing</span></td>
            </c:if>
             <c:if test="${order.status == 'DELIVERED'}">
             <td><span class="label label-success">Shipped</span></td>
             </c:if>
          </tr>
          </c:forEach>
         <!--  <tr>
            <td>2</td>
            <td><a href="http://www.mirchu.net/mobiles/lg-g3/" target="_blank">LG G3</a></td>
            <td>Basit Raza</td>
            <td>example@bugpluss.com</td>
            <td>10/6/2014</td>
            <td>$621.00</td>
            <td><span class="label label-success">Shipped</span></td>
          </tr>
          <tr>
            <td>3</td>
            <td><a href="http://www.mirchu.net/mobiles/samsung-galaxy-s5/" target="_blank">Samsung Galaxy S5</a></td>
            <td>Raza Ahmed</td>
            <td>example@therazz.net</td>
            <td>11/9/2013</td>
            <td>$640.00</td>
            <td><span class="label label-info">Processing</span></td>
          </tr>
          <tr>
            <td>4</td>
            <td><a href="http://www.mirchu.net/rook-bootstrap-app-landing-page/" target="_blank">Rook Landing Page</a></td>
            <td>Mirchu net</td>
            <td>example@mirchu.net</td>
            <td>11/6/2014</td>
            <td>$12.00</td>
            <td><span class="label label-primary">Completed</span></td>
          </tr> -->
        </tbody>
      </table>
    </div>
	</div>
</div>

<ol class="progtrckr" data-progtrckr-steps="5" style="margin-top: 3em;margin-bottom: 10em;">
<c:if test="${shipment.days == 6}">
		<li class="progtrckr-done">Confirmed Order</li>
		<li class="progtrckr-todo">Processing Order</li>
		<li class="progtrckr-todo">Quality Check</li>
		<li class="progtrckr-todo">Dispatched Item</li>
		<li class="progtrckr-todo">Product Delivered</li>
</c:if>
<c:if test="${shipment.days == 5 || shipment.days == 4}">
		<li class="progtrckr-done">Confirmed Order</li>
		<li class="progtrckr-done">Processing Order</li>
		<li class="progtrckr-todo">Quality Check</li>
		<li class="progtrckr-todo">Dispatched Item</li>
		<li class="progtrckr-todo">Product Delivered</li>
</c:if>

<c:if test="${shipment.days == 3 || shipment.days == 2}">
		<li class="progtrckr-done">Confirmed Order</li>
		<li class="progtrckr-done">Processing Order</li>
		<li class="progtrckr-done">Quality Check</li>
		<li class="progtrckr-todo">Dispatched Item</li>
		<li class="progtrckr-todo">Product Delivered</li>
</c:if>

<c:if test="${shipment.days == 1 || shipment.days == 0}">
		<li class="progtrckr-done">Confirmed Order</li>
		<li class="progtrckr-done">Processing Order</li>
		<li class="progtrckr-done">Quality Check</li>
		<li class="progtrckr-done">Dispatched Item</li>
		<li class="progtrckr-todo">Product Delivered</li>
</c:if>

<c:if test="${shipment.days == -1}">
		<li class="progtrckr-done">Confirmed Order</li>
		<li class="progtrckr-done">Processing Order</li>
		<li class="progtrckr-done">Quality Check</li>
		<li class="progtrckr-done">Dispatched Item</li>
		<li class="progtrckr-done">Product Delivered</li>
</c:if>
	</ol>



<%-- <div class="row">
         <div class="col-md-12">
            <div class="col-md-4">
            	<h3 class="text-center">Order Summary</h3><hr>
            	<div class="pull-left"><h4>Subtotal</h4> </div>
            	<div class="pull-right"><h4 class="text-right">$${shipment.totalAmount}</h4></div>
            	<div class="clearfix"></div>
            	<div class="pull-left"><h4>Tax</h4> </div>
            	<div class="pull-right"><h4 class="text-right">$0.00</h4></div>
            	<div class="clearfix"></div>
            	<div class="pull-left"><h4>Order Total</h4> </div>
            	<div class="pull-right"><h4 class="text-right">$${shipment.totalAmount}</h4></div>
            	<div class="clearfix"></div>
        	</div>
        	<div class="col-md-4 offset-md-1">
            	<h3 class="text-center">Payment Type</h3><hr>
            	<div class="text-center">
            	    <strong>${shipment.modeOfPayment}</strong><br>
            	 </div>
        	</div>
        	<div class="col-md-4 offset-md-2">
            	<h3 class="text-center">Other Info</h3><hr>
            	<address>
            	    <strong>Billed To:</strong><br>
            	  		${shipment.shipping.username}<br>
    					${shipment.shipping.address}<br>
    					${shipment.shipping.zpiCode}<br>
    					${shipment.shipping.phone}
            	 </address>
        	</div>
    	</div>
    </div> --%>
</c:if>