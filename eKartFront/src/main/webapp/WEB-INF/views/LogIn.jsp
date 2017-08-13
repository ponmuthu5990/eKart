<div class="container1">
  
  <h2>LogIn<small>Inputs</small></h2>
  <c:url value="/isValidUser" var="action"></c:url>
  <form action="${action}" method="post">
    
    <div class="group">      
      <input type="text" name="username" required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>User Name</label>
    </div>
      
    <div class="group">      
      <input type="password" name="password"  required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Password</label>
    </div>
    			        <c:if test="${not empty error}">
				<div class="error"><b>${error}</b></div>
	 			</c:if> 
				<c:if test="${not empty logout}">
			<div class="msg"><b>${logout}</b></div>
				</c:if>	
    <input type="submit" class="btn btn-success" name="submit" value="Sign  Up">  

  </form>

  
</div>