 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
 <!-- Navigation -->
 
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                <li id="Home">
                 <c:url value="/home" var="home"/>
                        <a href="${home}"><b style="font-size:large;">Online - Shopping</b></a>
                    </li>
                    <li id="About">
                        <a href="#">About</a>
                    </li>
                    <li id="Services">
                        <a href="#">Services</a>
                    </li>
                    <li id="Contact">
                        <a href="#">Contact</a>
                    </li>
                    
                    <security:authorize access="hasRole('ROLE_ADMIN')">
                    <li id="Category">
                     <c:url value="/admin/categoryTable" var="categoryTable"/>
                    <a href="${categoryTable}">Category</a>
                    </li>
                     <li id="Supplier">
                     <c:url value="/admin/supplierTable" var="supplierTable"/>
                    <a href="${supplierTable}">Supplier</a>
                    </li>
                     <li id="Product">
                     <c:url value="/admin/productTable" var="productTable"/>
                    <a href="${productTable}">Product</a>
                    </li>
                    </security:authorize>
                </ul>
                 <ul class="nav navbar-nav navbar-right">
                  <security:authorize access="hasRole('ROLE_USER')">
                    <li id="Cart">
                     <c:url value="/user/myCart" var="myCart"/>  
                        <a href="${myCart}"><span class="glyphicon glyphicon-shopping-cart"></span>  Cart(${sessionScope.noOfItems})</a>
                    </li>
                    </security:authorize>
                    <c:if test="${pageContext.request.userPrincipal.name==null }">
                    <li id="SignIn">
                     <c:url value="/all/signIn" var="url2"/>  
                        <a href="${url2}">  <span class="glyphicon glyphicon-log-in"></span>   SignIn</a>
                    </li>                    
                     <li id="SignUp">
                     <c:url value="/all/signUp" var="url1"/>  
                        <a href="${url1}"><span class="glyphicon glyphicon-user"></span>   SignUp</a>
                    </li>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name!=null }">
                   
                    <c:url value="/all/signOut" var="url3"/>  
                       <c:url value="/user/history" var="history"/>
                    <c:url value="/user/trackOrder" var="trackOrder"/>
                     <li class="dropdown" id="Account"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span>   ${pageContext.request.userPrincipal.name} <span class="caret"></span></a>
				        <ul class="dropdown-menu">
				          <security:authorize access="hasRole('ROLE_USER')">
				          <li><a href="${history}"><span class="glyphicon glyphicon-time"></span>   Purchase History</a></li>
				          <li><a href="${trackOrder}"><span class="glyphicon glyphicon-map-marker"></span>   Track Order</a></li>
				            </security:authorize>
				          <li> <a href="${url3}"><span class="glyphicon glyphicon-log-out"></span>   SignOut</a></li>
				        </ul>
				      </li>
                    </c:if>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>