<%@ page  isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="2">
<c:forEach var="myvar" items="${requestScope.key}">
<tr>

<td>
${myvar.cname}
</td>

<td>
<a href="DelServ?id=${myvar.cId}"> delete </a>
</td>

</tr>

</c:forEach>

</table>
</body>
</html>



