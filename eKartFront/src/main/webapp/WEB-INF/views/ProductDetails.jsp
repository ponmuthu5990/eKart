<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
  <style>
  
  @charset "UTF-8";
*, *:before, *:after {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

.product img {
  max-width: 100%;
  height: auto;
}

.product--title {
  color: #008080;
  font-weight: bold;
  font-size: 1.5em;
  font-family: serif;
  padding: 20px 0;
  text-align: center;
}
.product--title h2 {
  display: inline-block;
  border-bottom: 2px dashed;
}

.product--image, .product--details {
  float: left;
  width: 45%;
}

.product--image {
  padding-right: 3%;
}
.product--image .icon-images img {
  height: 80px;
  margin: 0 10px;
  cursor: pointer;
  border: 1px solid #e5e5e5;
}

.product--price .product--price_price {
  color: rgba(20, 180, 180, 0.9);
  font-size: 1.2em;
  padding-right: 10px;
}
.product--price .product--price_offer {
  color: indianred;
  border: 1px solid #952e2e;
  border-radius: 5px 5px;
  padding: 1px 3px;
  font-size: .7em;
}

.product--desc {
  font-family: sans;
}
.product--desc p {
  margin: 20px 0px;
}

.product--size {
  margin: 20px 0;
}
.product--size span {
  display: inline-block;
  width: 35px;
  border: 1px solid #999;
  border-radius: 4px 4px;
  text-align: center;
  padding: 1px 2px;
  text-transform: uppercase;
  cursor: pointer;
}
.product--size span.active {
  color: #fff;
  background: #008080;
}

.product--quantity input {
  border: 0;
  outline: 0;
  border-left: 1px dotted;
  border-right: 1px dotted;
  border-bottom: 1px dashed;
  padding: 1px 3px;
  text-align: center;
}
.product--quantity input::-webkit-inner-spin-button, .product--quantity input::-webkit-outer-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

.add-to-cart {
  margin: 10px 10px 10px 0;
}

.btn {
  background: none;
  border: 0;
  outline: 0;
  -webkit-appearance: none;
}
.btn.btn--cart {
  border: 1px solid indianred;
  border-radius: 4px;
  padding: 3px 30px 3px 5px;
  box-shadow: 0px 0px 3px 0px indianred;
  position: relative;
  overflow: hidden;
  text-align: left;
  font-size: 1.5em;
}
.btn.btn--cart:after {
  content: ">>";
  padding-left: 2px;
  position: absolute;
  right: 150%;
  transition: all .4s;
  color: #fff;
}
.btn.btn--cart:hover, .btn.btn--cart:focus {
  background: indianred;
  color: #fff;
  text-shadow: 2px 2px 3px #666;
  transition: all .4s;
}
.btn.btn--cart:hover:after, .btn.btn--cart:focus:after {
  right: 2%;
}

@media screen and (max-width: 500px) {
  .product--image, .product--details {
    float: none;
    width: 100%;
    padding: 10px 5px;
    margin: 5px 10px;
  }
}

  .container1 {
background:#ddd;
margin:20px auto;
padding:20px;
position:relative;
width:700px;
/* height:400px; */
border-radius:5px;
-moz-border-radius:5px;
-webkit-border-radius:5px;
box-shadow:1px 1px 5px #111;
-moz-box-shadow:1px 1px 5px #111;
-webkit-box-shadow:1px 1px 5px #111;
}
  /* css3 photo gallery styles */
.gallery {
width:610px;
margin:0 auto;
}
.gallery a {
display:inline-block;
height:150px;
position:relative;
width:200px;
}
.gallery a img {
border:5px solid #fff;
cursor:pointer;
display:block;
height:100%;
left:0px;
position:absolute;
top:0px;
width:100%;
z-index:1;
-moz-user-select: none;
-khtml-user-select: none;
user-select: none;
-moz-box-sizing:border-box;
-webkit-box-sizing:border-box;
box-sizing:border-box;
-webkit-transition-property:width, height, top, bottom, left, right, z-index, border;
-webkit-transition-duration:0.5s;
-moz-transition-property:width, height, top, bottom, left, right, z-index, border;
-moz-transition-duration:0.5s;
-o-transition-property:width, height, top, bottom, left, right, z-index, border;
-o-transition-duration:0.5s;
transition-property:width, height, top, bottom, left, right, z-index, border;
transition-duration:0.5s;
}
.gallery a:focus img {
border:15px solid #fff;
cursor:default;
height:250%;
position:absolute;
width:250%;
z-index:25;
box-shadow:1px 1px 5px #888;
-moz-box-shadow:1px 1px 5px #888;
-webkit-box-shadow:1px 1px 5px #888;
-webkit-transition-property:width, height, top, bottom, left, right, z-index, border;
-webkit-transition-duration:0.5s;
-moz-transition-property:width, height, top, bottom, left, right, z-index, border;
-moz-transition-duration:0.5s;
-o-transition-property:width, height, top, bottom, left, right, z-index, border;
-o-transition-duration:0.5s;
transition-property:width, height, top, bottom, left, right, z-index, border;
transition-duration:0.5s;
}
/* custom focus rules */
.gallery a:focus:nth-child(3n+1) img {
left:150px;
}
.gallery a:focus:nth-child(3n+2) img {
left:-50px;
}
.gallery a:focus:nth-child(3n+3) img {
left:-250px;
}
.gallery a:focus:nth-child(-n+3) img {
top:140px;
}
.gallery a:focus:nth-child(n+7) img {
top:-150px;
}
.gallery a:focus:nth-child(n+10) img {
top:-295px;
}
/* extra close layer */
.gallery .close {
background:transparent;
cursor:pointer;
display:none;
height:352px;
left:170px;
position:absolute;
top:160px;
width:500px;
z-index:30;
}
.gallery a:focus ~ .close {
display:block;
}
  
  /* recently viewed */
  div.recent {
    margin: 5px;
    border: 1px solid #ccc;
    float: left;
    width: 180px;
}

div.recent:hover {
    border: 1px solid #777;
}

div.recent img {
    width: 100%;
    height: auto;
}

div.description {
    padding: 15px;
    text-align: center;
}
  </style>
     <style>
.modal-content{
 background-color:transparent;
box-shadow: none;
    border: none;
}
body.class1 {
background: black;
}
      .container button{
          color: darkblue;
      }
</style>
</head>
<body style="margin-top: 2em;">

 
  <button  type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" id="btn1">Open Small Modal</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-body">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        
        </div>
        <div class="modal-body">
          <iframe width="825" height="345" style="border:none;" src="https://www.youtube.com/embed/${product.url}?autoplay=1">
</iframe>
        </div>
       
      </div>
    </div>
  </div>
  <!-- Modal -->
  <div class="modal fade" id="myModal1" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-body">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        
        </div>
        <div class="modal-body">
         <div class="container1" id="container">
<div class="gallery">
<c:forEach items="${noOfImg}" var="Img" varStatus="status">
      <a tabindex="1"><img src="${image}/${product.productName}_${product.productCode}/${product.productCode}_${product.id}_${status.count}.jpg"/></a>
      </c:forEach>

<span class="close"></span>
</div>
</div>
        </div>
       
      </div>
    </div>
  </div>

<div class="product col-lg-12">
  <div class="product--title">
    <h2>${product.productName}</h2>
  </div>
  <div class="product--body">
  <div class="product--image">
    <div class="icon-images">
    <c:forEach items="${noOfImg}" var="Img" varStatus="status">
      <img src="${image}/${product.productName}_${product.productCode}/${product.productCode}_${product.id}_${status.count}.jpg"/>
      </c:forEach>
      <!-- <img src="http://stalkbuylove.com/media/catalog/product/cache/1/image/393x502/9df78eab33525d08d6e5fb8d27136e95/i/n/in1335avv-167-detail.jpg"/>
      <img src="http://stalkbuylove.com/media/catalog/product/cache/1/image/393x502/9df78eab33525d08d6e5fb8d27136e95/i/n/in1335avv-167-back.jpg"/> -->
    </div>
    <img src="${image}/${product.productName}_${product.productCode}/${product.productCode}_${product.id}_1.jpg" data-toggle="modal" data-target="#myModal1" id="btn1" class="display-img" width="70%" height="30%">
  </div>
  <div class="product--details">
  <div class="product--price">
  <c:if test="${product.offer == 0 }">
    <span class="product--price_price">Rs. ${product.price }</span>
    </c:if>
    <c:if test="${product.offer > 0 }">
    <div class="row">
    <span class="product--price_price" style="font-size: x-large;;"> Rs. ${product.price - (product.price * (product.offer)/100)}  <s style="font-size: medium;">Rs. ${product.price}</s></span>    
    <span class="product--price_offer">${product.offer}% off</span></div><br>
    
    </c:if>
    <span style="color: lightblue;">${product.views} views</span>
  </div>
    <div class="product--desc">
    <p>${product.category.categoryName}</p>
   <ul>
    <c:forEach items="${productDesc}" var="desc">
   
    <li>${desc.description}
    </li></c:forEach></ul>
    
    
   
    </div>
  <!-- <div class="product--size">
    <span>s</span>
    <span class="active">m</span>
    <span>l</span>
    <span>xl</span>
  </div> 
  <div class="product--quantity">
    <input class="quantity" type="number" placeholder="quantity" min="1" max="10" value="1"></input>
  </div>-->
  <c:url value="/user/addToCart" var="addToCart"/>  
    <div class="add-to-cart">
     <c:if test="${productAltreadyAdded != 'true'}">
      <a href="${addToCart}/${product.id}" class="btn btn--cart">Shop it!</a>
      </c:if>
      <c:if test="${productAltreadyAdded == 'true'}">
      <a href="${myCart}" class="btn btn--cart">Go to cart</a>
      </c:if>
         <button class="btn btn--cart" data-toggle="modal" data-target="#myModal" id="btn1">Watch Trailer</button>
    </div>
  </div>
  </div>
</div>

      <c:if test="${fn:length(RecentlyViewed) > 0}">
    <div style="text-align: center;">
    
    <h2 style="color: blue;">Recently Viewed</h2>
    <c:forEach items="${RecentlyViewed}" var="view" varStatus="status">
    <c:if test="${view.product.id != product.id}">
 
 
    <div class="recent">
  <a href="${productDetails}/${view.product.id}">
    <img src="${image}/${view.product.productName}_${view.product.productCode}/${view.product.productCode}_${view.product.id}_1.jpg" alt="${view.product.productCode}" width="300" height="200">
  </a>
  <div class="description">${view.product.productName}</div>
</div>
    
    
		<%-- 	<section class="demo-2 col-lg-4">
				<div class="grid">
					<div class="box">
						<svg xmlns="http://www.w3.org/2000/svg" width="100%" height="100%">
							<line class="top" x1="0" y1="0" x2="900" y2="0"/>
							<line class="left" x1="0" y1="460" x2="0" y2="-920"/>
							<line class="bottom" x1="300" y1="460" x2="-600" y2="460"/>
							<line class="right" x1="300" y1="0" x2="300" y2="1380"/>
						</svg>
						  <img src="${image}/${view.product.productName}_${view.product.productCode}/${view.product.productCode}_${view.product.id}_1.jpg"/>
						<span>2012</span>
						<span>  ${view.product.productName}</span>
					</div>
					
					
				</div><!-- /grid -->
			</section> --%>
			</c:if>
    
    </c:forEach>
    </div>
    </c:if>
</body>
<script>
  $("#btn1").click(function() {
 
 $('body').addClass('class1');
});
  </script>
 
<script>
var sizes = jQuery(".product--size").find("span");
sizes.click(function() {
  sizes.removeClass("active");
  $(this).addClass("active");
});

// Change image on thumbnail click.
var thumbs = $(".icon-images").find("img");
thumbs.click(function() {
  var src = $(this).attr("src");
  var dp = $(".display-img");
  dp.attr("src", src);
});
</script>
</html>