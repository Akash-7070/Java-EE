<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*" isELIgnored="false"%>

<c:forEach var="str" items="${requestScope.RollNum}">
	${str}
	<br>
</c:forEach>

