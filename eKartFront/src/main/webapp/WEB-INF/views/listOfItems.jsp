 

 <c:url value="/user/productDetails" var="productDetails"/>  
<ul id="movieposters">
  <c:forEach items="${listProduct}" var="product" varStatus="status">
			<li>
				<img src="${image}/${product.productName}_${product.productCode}/${product.productCode}_${product.id}_1.jpg" alt="Iron Man 2">
				<div class="movieinfo">
					<h3>${product.productName}</h3>
					<!-- <p>With the world now aware of his dual life as the armored superhero Iron Man, billionaire inventor Tony...</p> -->
					<a href="${productDetails}/${product.id}" title="${product.productName}">More info</a>
				</div>
			</li>
			</c:forEach>
			<!-- <li>
				<img src="http://demo.marcofolio.net/3d_animation_css3/images/02_the_last_airbender.jpg" alt="The Last Airbender">
				<div class="movieinfo">
					<h3>The Last Airbender</h3>
					<p>The story follows the adventures of Aang, a young successor to a long line of Avatars, who must put his...</p>
					<a href="http://www.imdb.com/title/tt0938283/" title="Iron Man 2">More info</a>
				</div>
			</li> -->
			<li>
			<%-- 	<img src="http://demo.marcofolio.net/3d_animation_css3/images/03_tron_legacy.jpg" alt="Tron Legacy">
				<div class="movieinfo">
					<h3>Tron Legacy</h3>
					<!-- <p>Sam Flynn, the tech-savvy 27-year-old son of Kevin Flynn, looks into his father's disappearance and finds...</p> -->
					<a href="${productDetails}" title="Tron Legacy">More info</a>
				</div>
			</li> --%>
			
		</ul>