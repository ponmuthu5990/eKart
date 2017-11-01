
<h2 style="margin-top: 3em; text-align: center;">List Of Products</h2>


<c:url value="/admin/productForm" var="productForm" />
<div>
<p style="float: left;"><input type="text" ng-model="search"></p>
<h4 style="float: right;">
	<a href="${productForm}">Create New Product?</a>
</h4>
<div style="clear: none;"></div>
<table ng-controller="ProductController" ng-init="getdata()" class="table-fill">
	<thead>
		<tr>
			<th ng-click="orderByMe('id')" class="text-left">id</th>
			<th ng-click="orderByMe('productName')" class="text-left">productName</th>
			<th ng-click="orderByMe('price')" class="text-left">price</th>
			<th ng-click="orderByMe('quantity')" class="text-left">quantity</th>
			<!-- <th ng-click="orderByMe('noOfDesc')" class="text-left">no of desc</th> -->
		<!-- 	<th ng-click="orderByMe('noOfImg')" class="text-left">no of image</th> -->
			<!-- <th ng-click="orderByMe('url')" class="text-left">url</th> -->
			<!-- <th ng-click="orderByMe('category.categoryId')" class="text-left">Category</th> -->
		<!-- 	<th ng-click="orderByMe('supplier.supplierId')" class="text-left">Supplier</th>		 -->	
			<th ng-click="orderByMe('id')" class="text-left">More info</th>		
			<th ng-click="orderByMe('id')" class="text-left">View Images</th>
			 <th>Edit</th>
             <th>Status</th>
		</tr>
	</thead>
	<tbody class="table-hover">
		<tr ng-repeat="item in resultss | orderBy:myOrderBy | filter:search">
			<td class="text-center">{{item.id}}</td>
			<td class="text-center">{{item.productName}}</td>
			<td class="text-center">{{item.price}}</td>
			<td class="text-center">{{item.quantity}}</td>
			<!-- <td class="text-left">{{item.noOfDesc}}</td> -->
			<!-- <td class="text-left">{{item.noOfImg}}</td> -->
		<!-- 	<td class="text-left">{{item.url}}</td> -->
			<!-- <td class="text-left">{{item.category.categoryId}}</td> -->
			<!-- <td class="text-left">{{item.supplier.supplierId}}</td> -->
			<td ng-click="getDesc(item.id)" class="text-center" data-toggle="modal" data-target="#desc"><span class="glyphicon glyphicon-info-sign"></span></td>
			<td ng-click="getImage(item)" class="text-center" data-toggle="modal" data-target="#image" id="btn1"><span class="glyphicon glyphicon-eye-open"></span></td>
			 <td class="text-center"><a href="#"><span class="glyphicon glyphicon-pencil"></span></a></td>
        <td class="text-center">
        
       <!--  <div class="onoffswitch">
    <input ng-click="mySwitch(item)" type="checkbox" class="onoffswitch-checkbox" id="myonoffswitch" ng-model="item.status" />
    <label class="onoffswitch-label" for="myonoffswitch">
        <span class="onoffswitch-inner"></span>
        <span class="onoffswitch-switch"></span>
    </label>
</div> -->
        <div class="switch">
    <label>
     <!--  Off -->
      <input ng-change="mySwitch(item)" type="checkbox" ng-model="item.status">
      <span class="lever"></span>
     <!--  On -->
    </label>
  </div>
        </td>
		</tr>
		
	
	</tbody>
</table>
</div>

 <!-- Modal -->
  <div class="modal fade" id="desc" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" style="text-align: center;"> <b style="color: blue;">Name : </b>{{product.productName}}</h4>
          <br>
         
          <h4 class="modal-title" style="float: left;">Product Code : {{product.productCode}}</h4>
       <h4 class="modal-title" style="float: left;">video URL : <a href="https://www.youtube.com/watch?v={{product.url}}" target="_blank">https://www.youtube.com/watch?v={{productDetails.url}}</a></h4>
       <h4 class="modal-title" style="float: left;">Category : {{product.category.categoryName}}</h4>
       <h4 class="modal-title" style="float: right;">Supplier : {{product.supplier.supplierName}}</h4>
        </div>
        <div class="modal-body"> 
         <h3>Description : </h3>
          <ol>
          <li style="color: #424242;" ng-repeat="de in descrip">
          <b>{{de.description}}</b>
          </li>
          </ol>
          
        
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
  
   <div class="modal fade" id="image" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content" style="background-color:transparent;box-shadow: none;border: none;">
        <div class="modal-body">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        
        </div> 
        <div class="modal-body">
         <div class="container1" id="container">
<div class="gallery">

      <a tabindex="1" ng-repeat="img in images"><img src="${image}/{{singleProduct.productName}}_{{singleProduct.productCode}}/{{singleProduct.productCode}}_{{singleProduct.id}}_{{img}}.jpg"/>
     
      </a>
     

<span class="close"></span>
</div>
</div>
        </div>
       
      </div>
    </div>
  </div>
   <script>
  $("#btn1").click(function() {
 
 $('body').addClass('class1');
});
  </script>
<script type="text/javascript">
	
	 app.controller("ProductController",function($rootScope,$scope,$http,$q,$filter){
		 		 
		 $scope.mySwitch = {};
		$scope.getdata = function(){
			$http({
				method : 'GET',
				url : '../viewproductlist'
			}).then(function(data, status ,headers, config){
				$scope.result = data;
				console.log($scope.result)
				$scope.results = $scope.result.data;
				console.log($scope.results)
				$scope.resultss = $filter('orderBy')($scope.results, 'id');
				console.log($scope.resultss)
				/* alert("success"); */
			});
		}
		$scope.getImage = function(product){
			var noOfImg=[];
			 $rootScope.images = [];
			 $scope.image = {};
			$rootScope.singleProduct = product;
			for (var i = 1; i <= product.noOfImg; i++) {
				noOfImg.push(i)	
			}
			$scope.image = noOfImg;
			$rootScope.images = $scope.image;
		}
		$scope.getProduct = function(productId){
			$http({
				method : 'GET',
				url : '../viewProduct/' + productId + ''
			}).then(function(data, status ,headers, config){
				$scope.resul = data;
				$rootScope.product = $scope.resul.data;
				console.log($scope.product)
				/* alert("success"); */
			});
		}
		$scope.getDesc = function(id){
			$http({
				method : 'GET',
				url : '../getDescription/' + id + ''
			}).then(function(data, status ,headers, config){
				$scope.results = data;
				$rootScope.descrip = $scope.results.data;
				$rootScope.productDetails = $scope.descrip[0].product;
				 $scope.getProduct(id); 
				console.log($scope.descrip)
				console.log($scope.productDetails)
				/* alert("success"); */
			});
		}
		 /* switch */
		$scope.mySwitch = function(product){
			console.log("calling create Blog")
			return $http.post('../active', product) // 1
			.then(function(response) {
				console.log(response.data)
				return response.data;
				
			}, function(errResponse) {
				console.error('Error while creating Blog');
				return $q.reject(errResponse);
			});
		}
		$scope.orderByMe = function(x) {
	        $scope.myOrderBy = x;
	    }
	}); 
		
	 
	 
	
	
	 
	
				
	 
</script> 
 

  