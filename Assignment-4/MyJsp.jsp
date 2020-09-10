
<html>
<head>
</head>
<body>

<%@page import="java.util.*" %>
<%
List<String> mylist1=(List<String>)session.getAttribute("Friend");
Iterator itr=mylist1.iterator();
while(itr.hasNext())
{
	out.println(itr.next());
	out.println("<br>");
}
%>


</body>
</html>