<%@ include file="header.jsp" %>
<div id="content">
	<h1>Ajouter un producteur</h1>
	<p>Remplissez le formulaire pour ajouter un producteur</p>

	<form action="AddProductor" method="post">
		<table id="formBody">
			<tr><td><label for="name">Nom :</label></td><td><input type="text" name="name" required></td></tr>
			<tr><td><label for="pays">Pays :</label></td><td><input type="text" name="intensitee" id="intensitee" required></td></tr>
			<tr><td colspan="2"><input type="submit" value="Ajouter" id="Ajouter"></td></tr>
		</table>
	</form>
</div>
<%@ include file="footer.jsp" %>