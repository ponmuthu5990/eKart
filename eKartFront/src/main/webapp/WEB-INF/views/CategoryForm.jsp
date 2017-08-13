<h2 style="margin-top:3em; text-align: center;">Add a Category</h2>
<section>
  <div>
   <c:url value="/admin/newCategory" var="newCategory" />
   
    <form:form action="${newCategory}" method="post" modelAttribute="category">
     
    <form:hidden path="categoryId" />
      <label for="nome">Category Name</label>     
      <form:input type="text" path="categoryName" id="name"/>
      <label for="email">Description</label>
      <form:input type="text" path="desc" id="email" />
   
      <button type="submit">Submit</button>
    </form:form>
  </div>
</section>