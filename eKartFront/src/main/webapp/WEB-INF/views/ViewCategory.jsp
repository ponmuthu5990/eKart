<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<style>

h2 {
  text-align: center;
}

table caption {
	padding: .5em 0;
}

@media screen and (max-width: 767px) {
  table caption {
    border-bottom: 1px solid #ddd;
  }
}

.p {
  text-align: center;
  padding-top: 140px;
  font-size: 14px;
}
</style>
<h2 style="margin-top:3em;">List Of Categories</h2>

   <c:url value="/admin/categoryForm" var="categoryForm"/>
    <c:url value="/admin/getEditCategory" var="editCategory"/>  
    <c:url value="/admin/deleteCategory" var="deleteCategory"/>
   
<h4 style="float: left;"><a href="${categoryForm}">Create New Category?</a></h4>
  <div class="row">
    <div class="col-xs-12">
      <div class="table-responsive">
        <table summary="This table shows how to create responsive tables using Bootstrap's default functionality" class="table table-bordered table-hover">
          <caption class="text-center">An example of a responsive table based on <a href="https://getbootstrap.com/css/#tables-responsive" target="_blank">Bootstrap</a>:</caption>
          <thead>
            <tr>
            <th>S. No</th>
              <th>categoryId</th>
              <th>categoryName</th>
              <th>desc</th>
             <th>Edit</th>
             <th>Delete</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach items="${categoryList}" var="category" varStatus="status">
            <tr>
            <td>${status.count}</td>
              <td>${category.categoryId}</td>
              <td>${category.categoryName}</td>
              <td>${category.desc}</td>
              <td><a href="${editCategory}/${category.categoryId}">
          <span class="glyphicon glyphicon-pencil"></span>
        </a></td>
        <td><a href="${deleteCategory}/${category.categoryId}">
          <span class="glyphicon glyphicon-trash"></span> 
        </a></td>
              </tr>
              
</c:forEach>
          </tbody>
          <tfoot>
            <tr>
              <td colspan="5" class="text-center">Data retrieved from <a href="http://www.infoplease.com/ipa/A0855611.html" target="_blank">infoplease</a> and <a href="http://www.worldometers.info/world-population/population-by-country/" target="_blank">worldometers</a>.</td>
            </tr>
          </tfoot>
        </table>
      </div><!--end of .table-responsive-->
    </div>
  </div>

  <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<link
	href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css"
	rel="stylesheet">
	<script>
	$(document).ready(function(){
		var searchCondition=  '${searchCondition}';
		$('.table').DataTable({
			"lengthMenu" :[ [ 3, 5, 7, -1 ], [ 3, 5, 7, "All" ] ],
			"oSearch" : {
				"sSearch" : searchCondition
			}
		})
	});
</script>
