

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServ
 */
@WebServlet("/CartServ")
public class CartServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<String> pro=new ArrayList<String>();
		PrintWriter ref=response.getWriter();
		
		String arr[]=request.getParameterValues("a");
		
		for(int i=0;i<arr.length;i++)
		{
			pro.add(arr[i]);
		}
		
		HttpSession ref1=request.getSession(true);
		ref1.setAttribute("key", pro);
		ref.println("Data Is Added Into the Cart");
	}

}
