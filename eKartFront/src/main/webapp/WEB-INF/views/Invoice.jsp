   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
   <style>
.progress {
  width: 100%;
  height: 25px;
}

.progress-wrap {
  background: #f80;
  margin: 20px 0;
  overflow: hidden;
  position: relative;
}
.progress-wrap .progress-bar {
  background: #ddd;
  left: 0;
  position: absolute;
  top: 0;
}

  
  </style>
 <h2 style="margin-top: 3em; text-align: center;">Invoice</h2>
 
<div class="container" ng-controller="InvoiceController" ng-init="getMyOrderBytrackingId(${shipment.shipmentId})">
    <div class="row">
        <div class="col-md-12">
        	<div class="invoice-title">
    			<h2>Order {{res.orderTrackingId}}</h2>
    		<hr>	
    		</div>
    		<div class="row">
    			<div class="col-xs-6">
    				<address>
    				<strong>Billed To:</strong><br>
    					{{shipping.username}}<br>
    					{{shipping.address}}<br>
    					{{shipping.zpiCode}}<br>
    					{{shipping.phone}}
    				</address>
    			</div>
    			<div class="col-xs-6 text-right">
    				<address>
        			<strong>Shipped To:</strong><br>
    					{{shipping.username}}<br>
    					{{shipping.address}}<br>
    					{{shipping.zpiCode}}<br>
    					{{shipping.phone}}
    				</address>
    			</div>
    		</div>
    		
    	</div>
    </div>
    
    <div class="row">
    	<div class="col-md-12">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h3 class="panel-title"><strong>Order placed on 01/23/2017</strong></h3>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<thead>
                                <tr>
        							<td><strong>Product</strong></td>
        							<td class="text-center"><strong>Price</strong></td>
        							<td class="text-center"><strong>Quantity</strong></td>
        							<td class="text-center"><strong>Order Status</strong></td>
                                </tr>
    						</thead>
    						<tbody >
    							<!-- foreach ($order->lineItems as $line) or some such thing here -->
    						
    							<tr ng-repeat="order in res.customerOrderItems">
    								<td class="col-md-3">
    								    <div class="media">
    								         <a class="thumbnail pull-left" href="#"> <img class="media-object" src="${image}/{{order.product.productName}}_{{order.product.productCode}}/{{order.product.productCode}}_{{order.product.id}}_1.jpg" style="width: 72px; height: 72px;"> </a>
    								         <div class="media-body">
    								             <h4 class="media-heading"> {{order.product.productName}}</h4>
    								             <h5 class="media-heading"> {{order.product.productCode}}</h5>
    								         </div>
    								    </div>
    								</td>
    								<td class="text-center">{{order.totalprice}}</td>
    								<td class="text-center">{{order.quantity}}</td>
    								<td>
    								  <div class="col-md-13">
        								 
        								      
        								       
        								         <div class="row" style="width: 100%;">
        								         <div class="progress">
													<div class="progress-bar" role="progressbar" style="width:{{(10-order.days)*10}}%;background-color:blue;">
													{{order.days}}days
           												  </div>
           															 </div>
												 </div>
        								  </div>
        								 
    								    
    								</td>
    							</tr>
    						
                                
    						</tbody>
    					</table>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    
    <div class="row">
         <div class="col-md-12">
            <div class="col-md-4">
            	<h3 class="text-center">Order Summary</h3><hr>
            	<div class="pull-left"><h4>Subtotal</h4> </div>
            	<div class="pull-right"><h4 class="text-right">$${customerOrder.gTotal}</h4></div>
            	<div class="clearfix"></div>
            	<div class="pull-left"><h4>Tax</h4> </div>
            	<div class="pull-right"><h4 class="text-right">$0.00</h4></div>
            	<div class="clearfix"></div>
            	<div class="pull-left"><h4>Order Total</h4> </div>
            	<div class="pull-right"><h4 class="text-right">$${customerOrder.gTotal}</h4></div>
            	<div class="clearfix"></div>
        	</div>
        	<div class="col-md-4 offset-md-1">
            	<h3 class="text-center">Payment Type</h3><hr>
            	<div class="text-center">
            	    <strong>{{res.modeOfPayment}}</strong><br>
            	 </div>
        	</div>
        	<div class="col-md-4 offset-md-2">
            	<h3 class="text-center">Other Info</h3><hr>
            	<address>
            	    <strong>Billed To:</strong><br>
            	  		{{res.shipping.username}}<br>
    					{{res.shipping.address}}<br>
    					{{res.shipping.zpiCode}}<br>
    					{{res.shipping.phone}}
            	 </address>
        	</div>
    	</div>
    </div>
</div>

<script type="text/javascript">

app.controller("InvoiceController",function($rootScope,$scope,$http,$q,$filter){
	
	
  // on page load...
  

    // SIGNATURE PROGRESS
   /*  $scope.moveProgressBar =  function(days) {
      console.log("moveProgressBar");        
        
     
        $(".progress-bar").each(function (index ) {
        	for (var i = 0; i <= index; i++) {
        		var getPercent = ((days) / 10);
        		 var getProgressWrapWidth = $('.progress-wrap').width();
                 var progressTotal = getPercent * getProgressWrapWidth;
                 var animationLength = 2500;
                 $(this).animate({left: progressTotal}, 2500);
			}                
            })
    } */
    $scope.getMyOrder = function(userId){
		$http({
			method : 'GET',
			url : '../viewCartlist/' + userId + ''
		}).then(function(data, status ,headers, config){
			$scope.result = data;
			$scope.resul = $scope.result.data;
			$rootScope.ordered = $scope.result.data;
			console.log($rootScope.ordered)
			/* alert("success"); */
		});
	}
  
    $scope.getMyOrderBytrackingId = function(trackingId){
		$http({
			method : 'GET',
			url : '../viewMyCartlist/' + trackingId + ''
		}).then(function(data, status ,headers, config){
			$scope.resu = data;
			$rootScope.res = $scope.resu.data;
			$rootScope.shipping = $scope.res.shipping;
			$rootScope.myOrder = $scope.resu.data;
			console.log($rootScope.myOrder)
			/* alert("success"); */
		});
	}
    
});
  </script>
  
  