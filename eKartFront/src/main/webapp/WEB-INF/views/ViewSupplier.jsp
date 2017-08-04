  <h2 style="margin-top:3em;">List Of Suppliers</h2>
  
  <c:url value="/admin/supplierForm" var="supplierForm"/>
<h4 style="float: right;"><a href="${supplierForm}">Create New Supplier?</a></h4>
  <div class="row">
    <div class="col-xs-12">
      <div class="table-responsive">
        <table summary="This table shows how to create responsive tables using Bootstrap's default functionality" class="table table-bordered table-hover">
          <caption class="text-center">An example of a responsive table based on <a href="https://getbootstrap.com/css/#tables-responsive" target="_blank">Bootstrap</a>:</caption>
          <thead>
            <tr>
              <th>supplierId</th>
              <th>supplierName</th>
              <th>email</th>
              <th>phone</th>
              <th>Edit</th>
             <th>Delete</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach items="${supplierList}" var="supplier" varStatus="status">
            <tr>
              <td>${supplier.supplierId}</td>
              <td>${supplier.supplierName}</td>
              <td>${supplier.email}</td>
              <td>${supplier.phone}</td>
             <td><a href="#">
          <span class="glyphicon glyphicon-pencil"></span>
        </a></td>
        <td><a href="#">
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
