<%@page import="java.util.*" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>List of Registration</h1>
<c:forEach var="str" items="${requestScope.key}">
 ${str}
 <br>
</c:forEach>