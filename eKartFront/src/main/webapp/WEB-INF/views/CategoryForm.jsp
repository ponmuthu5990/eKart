<h2 style="margin-top:3em; text-align: center;">Add a Category</h2>
<section>
  <div>
   <c:url value="/admin/newCategory" var="newCategory" />
    <form action="${newCategory}" method="post">
      <label for="nome">Category Name</label>
     
      <input type="text" name="categoryName" id="name" value="${category.categoryName}"/>
      <label for="email">Description</label>
      <input type="text" name="desc" id="email" value="${category.desc}"/>
   
      <button type="submit">Submit</button>
    </form>
  </div>
</section>