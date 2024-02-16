<%@ include file="header.jsp" %>
<div id="content">
	<h1>Description d'un caff�e</h1>
	<c:choose>
		<c:when test="${empty coffee or coffee == null}">
			<p>Le caf� que vous cherchez n'existe pas.</p>
		</c:when>
		<c:otherwise>
			${coffee.toHtml()}
		</c:otherwise>
	</c:choose>
</div>
<%@ include file="footer.jsp" %>