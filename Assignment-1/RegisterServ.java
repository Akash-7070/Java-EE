

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServ
 */
@WebServlet("/RegisterServ")
public class RegisterServ extends HttpServlet {
	
/**
	 * 
	 */
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter ref=response.getWriter();
		
		String name=request.getParameter("name");
		String address=request.getParameter("Address");
		String email=request.getParameter("email");
		String username=request.getParameter("uname");
		String password=request.getParameter("pass");
		
		ref.println(name);
		
		try 
		{
			PreparedStatement pst=con.prepareStatement("insert into register values(?,?,?,?,?)");
			pst.setString(1,name);
			pst.setString(2,address);
			pst.setString(3,email);
			pst.setString(4,username);
			pst.setString(5,password);
			
			int k=pst.executeUpdate();
			if(k>0)
			{
				ref.println("Record has been added");
			}
			else
			{
				ref.println("cannot add");
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
		
	}

}
