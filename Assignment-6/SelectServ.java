/*
 * 2) in Module.jsp create <option> i.e. drop-down list.
values should be java,C++, Oracle.
when user selects, a particular option and click on submit button, 
request should go to servlet.
In servlet u read the request parameter.
if the value is "java" forward to j2se.jsp,
if the value is "C++" forward to cplusplus.jsp
if the value is "oracle" forward to ora.jsp

 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectServ
 */
public class SelectServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String sub=request.getParameter("subject");
		if(sub.equals("Java"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("Java.jsp");
			rd.forward(request,response);
		}
		else if(sub.equals("CPP"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("Cpp.jsp");
			rd.forward(request,response);
		}
		else if(sub.equals("Oracle"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("Oracle.jsp");
			rd.forward(request,response);
		}
		else
		{
			out.println("Please select atleast one subject");
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request,response);
		}
	}

}
