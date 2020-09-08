

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardingServlet
 */
@WebServlet("/Server1")
public class Server1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private Connection con;
	public void init()
	{

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/dept";
			con=DriverManager.getConnection(url,"root","root");
		} 
		
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try
		{
			response.setContentType("text/html");
			PrintWriter pw= response.getWriter();
			List<String> loc=new ArrayList<String>();
			
			PreparedStatement pst=con.prepareStatement("select loc from dept");
			ResultSet res= pst.executeQuery();
			
			while(res.next())
			{
				loc.add(res.getNString("loc"));
			}
		
			    request.setAttribute("location", loc);
			    RequestDispatcher rd=request.getRequestDispatcher("Server2");
			    rd.forward(request,response);
			
		}
		catch(Exception ee)
		{
			System.out.println("in forwarding"+ee);
		}
	}
	}

