<%@ include file="header.jsp" %>
<div id="content">
	<h1>Description d'un producteur</h1>
	
	<c:choose>
		<c:when test="${ empty producer or producer == null }">
	            <h2>Il n'y a pas de producteur pour le moment</h2>
	    </c:when>

		<c:otherwise>
			<h2>${ producer.name }, est basé en ${ producer.country }</h2>
			<label for="coffeesView">Produit les caffées suivants :</label>
			<ul id="coffeesView">
			    <c:forEach var="coffee" items="${producer.coffees}">
					<li>
						<a href="Coffee?Id=${ coffee.id }"><c:out value="${coffee.name}"/></a>
					</li>
				</c:forEach>
			</ul>
		</c:otherwise>	
	</c:choose>
</div>
<%@ include file="footer.jsp" %>