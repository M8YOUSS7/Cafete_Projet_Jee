<%@ include file="header.jsp" %>
<div id="content">
	<h1>Liste des caffées</h1>
	<c:choose>
		<c:when test="${ empty coffees or coffees == null }">
			<h2>Il n'y a pas de cafées pour le moment</h2>
		</c:when>
		<c:when test="${ not empty coffees }">
			<ul id="coffeesView">
			    <c:forEach var="coffee" items="${coffees}">
					<li>
						<a href="Coffee?Id=${ coffee.id }"><c:out value="${coffee.name}"/></a>
					</li>
				</c:forEach>
			</ul>
		</c:when>
	</c:choose>
</div>
<%@ include file="footer.jsp" %>