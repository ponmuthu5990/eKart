
<h2 style="margin-top: 3em; text-align: center;">Add a Supplier</h2>
 <c:url value="/admin/newSupplier" var="newSupplier" />
<form action="${newSupplier}" method="post">
  <label for="supplierName">Supplier Name</label>
  <input type="text" id="supplierName" name="supplierName" placeholder="supplierName">
  <label for="email">Supplier email</label>
  <input type="text" id="email" name="email"placeholder="supplier email">
   <label for="phone">Supplier phone</label>
  <input type="text" id="phone" name="phone"placeholder="supplier phone">
  
  <button class="button">Blue</button>
</form>
