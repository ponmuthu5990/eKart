<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container1">

  
  <h2>SignUp<small>Inputs</small></h2>
   <c:url value="/all/newUser" var="newUser" />
  <form:form action="${newUser}" method="post" modelAttribute="customer">
    <div class="row">
    <div class="group col-sm-5">      
      <input type="text" required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>First Name</label>
    </div>
      
    <div class="group col-sm-4 col-sm-offset-3">      
      <input type="text" required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Last Name</label>
    </div>
    </div>
    <div class="row">
     <div class="group col-sm-5">      
      <input type="text" name="userName" required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>User Name</label>
    </div>
     <div class="group col-sm-4 col-sm-offset-3">      
      <input type="text" name="emailId" required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Email</label>
    </div></div>
    <div class="row">
     <div class="group col-sm-5">      
      <input type="password" name="passWord" required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Password</label>
    </div>
    <div class="group col-sm-4 col-sm-offset-3">      
      <input type="password" required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Password</label>
    </div>
    </div>
    <div class="row">
     <div class="group col-sm-5">      
      <input type="text" name="address" required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Address</label>
    </div>
     <div class="group col-sm-4 col-sm-offset-3">      
      <input type="text" name="zpiCode" required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Zip code</label>
    </div>
    </div>
    <div class="row">
    <input type="submit" class="btn btn-success col-sm-offset-4" name="submit" value="Sign  Up">  
    </div>
  </form:form>

  
</div>