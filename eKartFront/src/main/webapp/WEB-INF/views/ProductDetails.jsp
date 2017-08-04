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
<body>

 
  <button  type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" id="btn1">Open Small Modal</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-body">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        
        </div>
        <div class="modal-body">
          <iframe width="825" height="345" style="border:none;" src="https://www.youtube.com/embed/nO1ROKMjPqI?autoplay=1">
</iframe>
        </div>
       
      </div>
    </div>
  </div>

<div class="product">
  <div class="product--title">
    <h2>My Awesome Product</h2>
  </div>
  <div class="product--body">
  <div class="product--image">
    <div class="icon-images">
      <img src="http://stalkbuylove.com/media/catalog/product/cache/1/image/393x502/9df78eab33525d08d6e5fb8d27136e95/i/n/in1335avv-167-front.jpg"/>
      <img src="http://stalkbuylove.com/media/catalog/product/cache/1/image/393x502/9df78eab33525d08d6e5fb8d27136e95/i/n/in1335avv-167-detail.jpg"/>
      <img src="http://stalkbuylove.com/media/catalog/product/cache/1/image/393x502/9df78eab33525d08d6e5fb8d27136e95/i/n/in1335avv-167-back.jpg"/>
    </div>
    <img src="http://stalkbuylove.com/media/catalog/product/cache/1/image/393x502/9df78eab33525d08d6e5fb8d27136e95/i/n/in1335avv-167-back.jpg" class="display-img">
  </div>
  <div class="product--details">
  <div class="product--price">
    <span class="product--price_price">Rs. 800</span>
    <span class="product--price_offer">new arrivel !</span>
  </div>
    <div class="product--desc"><p>This is my awesome product. Its comfortable to wear, and nice to look.</p></div>
  <div class="product--size">
    <span>s</span>
    <span class="active">m</span>
    <span>l</span>
    <span>xl</span>
  </div>
  <div class="product--quantity">
    <input class="quantity" type="number" placeholder="quantity" min="1" max="10" value="1"></input>
  </div>
    <div class="add-to-cart">
      <button class="btn btn--cart">Shop it!</button>
         <button class="btn btn--cart" data-toggle="modal" data-target="#myModal" id="btn1">Watch Trailer</button>
    </div>
  </div>
  </div>
</div>
    
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
</body>
</html>