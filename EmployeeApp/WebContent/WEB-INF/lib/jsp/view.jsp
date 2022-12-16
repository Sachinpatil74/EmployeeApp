<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table align="center" border="1px">
<c:forEach var="i" items="${data}">
<tr>
<td><c:out value="${i.getId() }"></c:out></td>
<td><c:out value="${i.getName() }"></c:out></td>
</tr>
</c:forEach>
</table>
</body>
</html>