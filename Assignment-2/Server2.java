
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardedServlet
 */
@WebServlet("/Server2")
public class Server2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{
			response.setContentType("text/html");
			PrintWriter pw= response.getWriter();
			
			List<String> loc1=(List<String>) request.getAttribute("location");
			
			Iterator itr=loc1.iterator();
			
			while(itr.hasNext())
			{
				pw.println(itr.next());
			}		
			
	    }
		
		catch(Exception ee)
		{
			System.out.println("in forwarding"+ee);
		}
	}
	}
