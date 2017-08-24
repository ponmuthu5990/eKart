<h2 style="margin-top:3em; text-align: center;">Select Address</h2>

<h3 style="float: right;cursor: pointer;" data-toggle="modal" data-target="#myModal">New Address?</h3>
<br>
<c:url value="/user/deleteShipping" var="deleteShipping"></c:url>
<c:url value="/user/deleverHere" var="deleverHere"></c:url>
<div ng-controller="ShippingController" class="container1 group" style="margin-top:2em;">
<c:forEach items="${shippings}" var="shipping" varStatus="status">
		<div class="grid-1-5">
		<span style="float: right;"><a href="${deleteShipping}?shippingId=${shipping.id}" style="cursor: pointer;text-decoration: none;">Delete  </a></span>
		<span style="float: right;margin-right: 1em;"><a href="" ng-click="getShipping(${shipping.id})" data-toggle="modal" data-target="#myModal" style="cursor: pointer;text-decoration: none;">Edit</a></span>
		
			<h2>${shipping.username}</h2>
	<!-- 		<h3><span class="uppercase">Free</span></h3> -->
			<p>${shipping.phone}</p>
			<ul>
				<li><span class="uppercase">${shipping.address}</span></li>
				<li>${shipping.zpiCode}</li>
			</ul>
			<a href="${deleverHere}/${shipping.id}" class="button">Deliver Here</a>
		</div>
	</c:forEach>
	
	</div>
	
	<c:url value="/user/newShipping" var="newShipping"></c:url>
	<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
      <form action="${newShipping}" method="post">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">New Address</h4>
        </div>
        <div class="modal-body">
        <!-- for edit using angular js -->
         <div ng-if="shipping.id" class="form-group">
		      <label for="name">Id : </label>
		      <input type="text" class="form-control" id="username" placeholder="Enter name" name="id" ng-model="shipping.id" readonly="true">
    	</div>
    	 
          <div class="form-group">
		      <label for="name">Name : </label>
		      <input type="text" class="form-control" id="username" placeholder="Enter name" name="username" ng-model="shipping.username">
    	</div>
    	 <div class="form-group">
		      <label for="phone">Ph Number :</label>
		      <input type="text" class="form-control" id="phone" placeholder="Enter phone" name="phone" ng-model="shipping.phone">
    	</div>
    	 <div class="form-group">
		      <label for="address">address :</label>
		      <input type="text" class="form-control" id="address" placeholder="Enter address" name="address" ng-model="shipping.address">
    	</div>
    	 <div class="form-group">
		      <label for="zipCode">Zip code :</label>
		      <input type="text" class="form-control" id="zipCode" placeholder="Enter zipCode" name="zpiCode" ng-model="shipping.zpiCode">
    	</div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-default" >Create</button>
        </div>
          </form>
      </div>
    
    </div>
  </div>
  <script type="text/javascript">
  app.controller("ShippingController",function($rootScope,$scope,$http,$q,$filter){
	  
		$scope.getShipping = function(id){
			$http({
				method : 'GET',
				url : '../getShipping/' + id + ''
			}).then(function(data, status ,headers, config){
				$scope.results = data;
				$rootScope.shipping = $scope.results.data;
			
				console.log($rootScope.shipping)
				/* alert("success"); */
			});
		}
	  
  }); 

  </script>