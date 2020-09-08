

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection  con;
	public void init()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mydb";
			con=DriverManager.getConnection(url,"root","root");
		}
		catch (Exception e) 
		{

			e.printStackTrace();
		}	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter ref=response.getWriter();
		response.setContentType("text/html");
		
		try 
		{
			
			String um=request.getParameter("uname");
			String pass=request.getParameter("pass");
			
			PreparedStatement pst=con.prepareStatement("select * from register");
		  // pst.setNString(4,um );
		  // pst.setNString(5,pass);
			ResultSet res= pst.executeQuery();
		   
		    while(res.next())
		    {
		    	 if(um.equals(res.getNString(4))&&pass.equals(res.getNString(5)))
		    	 {
		    	ref.println(res.getString(1));
		    	ref.println(res.getString(2));
		    	ref.println(res.getString(3));
		    	ref.println(res.getString(4));
		    	ref.println(res.getString(5));
		    	ref.println("<br>");
		    	 }
		    }
				   
		    	
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
