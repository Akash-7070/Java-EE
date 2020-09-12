

import java.io.IOException;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypack.LoginBean;

/**
 * Servlet implementation class LoginServ
 */
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("nm");
		String pass=request.getParameter("pass");
		
		LoginBean ref= new LoginBean();
		boolean res=ref.validate(name,pass);
		
		if(res)
		{
			request.setAttribute("key", name);
			RequestDispatcher rd= request.getRequestDispatcher("Success.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd= request.getRequestDispatcher("Fail.jsp");
			rd.forward(request, response);	
		}
	}

}
