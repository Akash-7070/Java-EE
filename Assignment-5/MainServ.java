
/*
 index.jsp
accept user name and password
on submit control should go to "MainServ"
"MainServ" will check if user name and password is "scott" and "tiger" respectively , 
it will forward to "Welcome.jsp" which will display welcome message.
if user name and password is not correct, "MainServ" will forward to "index.jsp".
*/

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServ
 */
public class MainServ extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		if(name.equals("scott") && pass.equals("tiger"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
		}	
	}

}
