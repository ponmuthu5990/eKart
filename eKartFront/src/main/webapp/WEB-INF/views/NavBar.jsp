 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <c:url value="/home" var="home"/>  
                <a class="navbar-brand" href="${home}">Start Bootstrap</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                    <security:authorize access="hasRole('ROLE_ADMIN')">
                    <li>
                     <c:url value="/admin/categoryTable" var="categoryTable"/>
                    <a href="${categoryTable}">Category</a>
                    </li>
                     <li>
                     <c:url value="/admin/supplierTable" var="supplierTable"/>
                    <a href="${supplierTable}">Supplier</a>
                    </li>
                     <li>
                     <c:url value="/admin/productTable" var="productTable"/>
                    <a href="${productTable}">Product</a>
                    </li>
                    </security:authorize>
                </ul>
                 <ul class="nav navbar-nav navbar-right">
                  <security:authorize access="hasRole('ROLE_USER')">
                    <li>
                     <c:url value="/user/myCart" var="myCart"/>  
                        <a href="${myCart}">Cart(${sessionScope.noOfItems})</a>
                    </li>
                    </security:authorize>
                    <c:if test="${pageContext.request.userPrincipal.name==null }">
                    <li>
                     <c:url value="/all/signIn" var="url2"/>  
                        <a href="${url2}">SignIn</a>
                    </li>                    
                     <li>
                     <c:url value="/all/signUp" var="url1"/>  
                        <a href="${url1}">SignUp</a>
                    </li>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name!=null }">
                    <li>
                    <c:url value="/all/signOut" var="url3"/>  
                        <a href="${url3}">SignOut</a>
                    </li>
                    </c:if>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>