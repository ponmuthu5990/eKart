<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<h2 style="margin-top:3em; text-align: center;">Add a Product</h2>
 <c:url value="/admin/newProduct" var="newProduct" />
<form:form class="form-horizontal" action="${newProduct}" method="post" modelAttribute="product" enctype="multipart/form-data">
<fieldset>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="productName">product name</label>  
  <div class="col-md-4">
    <form:input path = "productName" class="form-control" placeholder="product Name"/>
    <form:errors path="productName" cssStyle="color:red"></form:errors>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">price</label>  
  <div class="col-md-4">
     <form:input path = "price" class="form-control"/>
     <form:errors path="price" cssStyle="color:red" ></form:errors>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="quantity">quantity</label>  
  <div class="col-md-4">
    <form:input path = "quantity" class="form-control"/>
     <form:errors path="quantity" cssStyle="color:red" ></form:errors>
  </div>
</div>

<!-- Text input-->
<%-- <div class="form-group">
  <label class="col-md-4 control-label" for="description">description</label>  
  <div class="col-md-4">
    <form:input path = "description" class="form-control" placeholder="description"/>
    <form:errors path="quantity" cssStyle="color:red" ></form:errors>
  </div>
</div> --%>
<div class="form-group">
	 <label class="col-md-4 control-label" for="price">description</label>  
	 <div class="col-md-4">  
 	<div id="productDesc">    
    </div>
    <input type="button" id="desc" value="Add Desc">
      </div>
    </div>
<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Category">Category</label>
  <div class="col-md-4">
  
    <form:select path="category.categoryId" class="form-control">
       <c:forEach items="${categoryList}" var="category">
      <form:option value="${category.categoryId}">${category.categoryName}</form:option>
      </c:forEach>
    </form:select>
  </div>
  
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="Supplier">Supplier</label>
  <div class="col-md-4">
    <form:select path="supplier.supplierId" class="form-control input-md">
       <c:forEach items="${supplierList}" var="supplier">
      <form:option value="${supplier.supplierId}">${supplier.supplierName}</form:option>
      </c:forEach>
    </form:select>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Video Url</label>  
  <div class="col-md-4">  
     <form:input path = "url" class="form-control" placeholder="video url"/>
   
  </div>
</div>

	<!-- multiple files -->
	<div class="form-group">
	 <label class="col-md-4 control-label" for="price">Product Image</label>  
	 <div class="col-md-4">  
 	<div id="petsContainer">    
    </div>
    <input type="button" id="addPet" value="Add">
      </div>
    </div>
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 col-md-offset-1 control-label" for="submit"></label>
  <div class="col-md-4">
    <button id="submit" name="submit" class="btn btn-primary">SUBMIT</button>
  </div>
</div>

</fieldset>
</form:form>
<script>
document.getElementById("addPet").onclick=function() {
var inputCount = document.getElementById('petsContainer').getElementsByTagName('input').length;
if(inputCount<3){
				var div = document.getElementById("petsContainer");
				var input = document.createElement("input");
				input.type = "file";
                input.name = "image";
                input.setAttribute("multiple", "");
				div.appendChild(document.createElement("br"));
                div.appendChild(document.createElement("br"));
				div.appendChild(input);
        }
        else
        {
        alert("Image limit is Over");
        }
			}
</script>
<script>
document.getElementById("desc").onclick=function() {
var inputCount = document.getElementById('productDesc').getElementsByTagName('input').length;
if(inputCount<5){
				var div = document.getElementById("productDesc");
				var input = document.createElement("input");
				input.type = "text";
                input.name = "description";              
				div.appendChild(document.createElement("br"));
                div.appendChild(document.createElement("br"));
				div.appendChild(input);
        }
        else
        {
        alert("Desc limit is Over");
        }
			}
</script>