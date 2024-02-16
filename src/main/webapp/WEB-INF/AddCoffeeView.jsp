<%@ include file="header.jsp" %>
<div id="content">
	<h1>Ajouter un café</h1>
	<p>Remplissez le formulaire pour ajouter un café</p>

	<form action="AddCoffee" method="post">
		<table id="formBody">
			<tr><td><label for="name">Nom</label></td><td><input type="text" name="name" required></td></tr>
			<tr>
				<td><label for="producer">Producteur</label></td>
				<td><select name ="producer" id="selectProducer" required>
					<c:forEach var="producer" items="${producers}">
							<option id="${producer.id}" value="${producer.id}">${producer.name}</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr><td><label for="intensitee">Intensitée</label></td><td><input type="number" name="intensitee" id="intensitee" min="1" max="10" required></td></tr>
			<tr><td><label for="amertume">Amertume</label></td><td><input type="number" name="amertume" id="amertume" min="1" max="5" required></td></tr>
			<tr><td><label for="acidite">Acidité</label></td><td><input type="number" name="acidite" id="acidite" min="1" max="5" required></td></tr>
			<tr><td><label for="corps">Corps</label></td><td><input type="number" name="corps" id="corps" min="1" max="5" required></td></tr>
			<tr><td><label for="torrefaction">Torréfaction</label></td><td><input type="number" name="torrefaction" id="torrefaction" min="1" max="5" required></td></tr>
			<tr><td><label for="description">Texte libre décrivant l'expérience de dégustation</label></td><td><input type="text" name="description" id="description" required></td></tr>
			<tr><td><label for="note">Note</label></td><td><input type="number" name="note" id="note" min="0" max="5" required></td></tr>
			<tr><td colspan="2"><input type="submit" value="Ajouter" id="Ajouter"></td></tr>
		</table>
	</form>
</div>
<%@ include file="footer.jsp" %>