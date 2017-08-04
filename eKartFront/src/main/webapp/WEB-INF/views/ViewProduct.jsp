
<h2 style="margin-top: 3em; text-align: center;">List Of Products</h2>


<c:url value="/admin/productForm" var="productForm" />
<div ng-app="myApp">
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
			<th ng-click="orderByMe('description')" class="text-left">description</th>
			<th ng-click="orderByMe('url')" class="text-left">url</th>
			<th ng-click="orderByMe('category.categoryId')" class="text-left">Category</th>
			<th ng-click="orderByMe('supplier.supplierId')" class="text-left">Supplier</th>			
			 <th>Edit</th>
             <th>Delete</th>
		</tr>
	</thead>
	<tbody class="table-hover">
		<tr ng-repeat="item in result.data | orderBy:myOrderBy | filter:search">
			<td class="text-left">{{item.id}}</td>
			<td class="text-left">{{item.productName}}</td>
			<td class="text-left">{{item.price}}</td>
			<td class="text-left">{{item.quantity}}</td>
			<td class="text-left">{{item.description}}</td>
			<td class="text-left">{{item.url}}</td>
			<td class="text-left">{{item.category.categoryId}}</td>
			<td class="text-left">{{item.supplier.supplierId}}</td>
			 <td><a href="#">
          <span class="glyphicon glyphicon-pencil"></span>
        </a></td>
        <td><a href="#">
          <span class="glyphicon glyphicon-trash"></span> 
        </a></td>
		</tr>
		
	
	</tbody>
</table>
</div>
<script type="text/javascript">
	var app = angular.module('myApp',[]);
	 app.controller("ProductController",function($scope,$http){
		$scope.getdata = function(){
			$http({
				method : 'GET',
				url : '../viewproductlist'
			}).then(function(data, status ,headers, config){
				$scope.result = data;
				console.log($scope.result)
				/* alert("success"); */
			});
		}
		
		$scope.orderByMe = function(x) {
	        $scope.myOrderBy = x;
	    }
	}); 
		
		
</script> 