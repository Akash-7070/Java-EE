<%@page import="mypack.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*" isELIgnored="false"%>

<c:forEach var="myval" items="${requestScope.mylist}">
${myval.name}
${myval.age}
<br>
</c:forEach>
