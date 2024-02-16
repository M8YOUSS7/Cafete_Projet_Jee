<%@ include file="header.jsp" %>
<div id="content">
	<h1>Page D'accueil</h1>
	<p id ="msgBvn"> Bienvenue sur la page d'accueil de notre site de vente en ligne. Vous trouverez ici les derniers produits ajoutés à notre catalogue.</p>
	
	<c:choose>
		<c:when test="${ empty producers or producers == null }">
			<h2>Il n'y a pas de producteur pour le moment</h2>
		</c:when>
		<c:when test="${ not empty producers }">
			<h2>Le classement des Producteurs selon leur note de caffée en moyenne</h2>
			<table id="producers">
				<tr><th>Nom</th><th>Note moyenne</th></tr>
			    <c:forEach var="producer" items="${producers}">
					<tr>
						<td><c:out value="${producer.key}"/></td>
						<td class="moyenne"><c:out value="${producer.value}"/></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test="${ empty coffeeDegustedNb or coffeeDegustedNb == 0 }">
                <h2>Il n'y a pas de caffée dégustée pour le moment</h2>
        </c:when>

	    <c:when test="${ not empty coffeeDegustedNb }">        
			<h2>
				Nombre de caffée dégustée :
				<c:out value="${ coffeeDegustedNb }" />
			</h2>
			<br>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test="${ empty coffeeConsumed or coffeeConsumed == null }">
	            <h2>Il n'y a pas de caffée consommée pour le moment</h2>
	    </c:when>

		<c:when test="${ not empty coffeeConsumed }">
			<h2>Voici nos caffées les plus consommées :</h2>
	
			<table id="coffees">
			    <tr><th>Id</th><th>Nom</th><th>Producteur</th><th>Intensité</th><th>Amertume</th><th>Acidité</th><th>Corps</th><th>Torréfaction</th><th>Description</th><th>Note</th></tr>
				<c:forEach var="coffee" items="${coffeeConsumed}">
					<tr>
						<td><c:out value="${coffee.id}" /></td>
						<td><c:out value="${coffee.name}" /></td>
						<td><c:out value="${coffee.productor.name}" /></td>
						<td><c:out value="${coffee.intensity}" /></td>
						<td><c:out value="${coffee.amertume}" /></td>
						<td><c:out value="${coffee.acidite}" /></td>
						<td><c:out value="${coffee.body}" /></td>
						<td><c:out value="${coffee.torrefaction}" /></td>
						<td><c:out value="${coffee.description}" /></td>
						<td><c:out value="${coffee.note}" /></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>	
	</c:choose>
</div>
<%@ include file="footer.jsp" %>