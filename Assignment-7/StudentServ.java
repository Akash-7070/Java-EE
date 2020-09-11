
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServ extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static Connection con;
	
	public void init()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		    String ss="jdbc:mysql://localhost:3305/mydb";
		    con=DriverManager.getConnection(ss,"root","root");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		List<Integer> mylist=new ArrayList<Integer>();
		
		int rn=Integer.parseInt(request.getParameter("rollno"));
		String nm=request.getParameter("name");
		int ag=Integer.parseInt(request.getParameter("age"));
		String add=request.getParameter("address");
		
		try 
		{
			PreparedStatement pst= con.prepareStatement("insert into students values(?,?,?,?)");
		    pst.setInt(1, rn);
			pst.setString(2, nm);
			pst.setInt(3, ag);
			pst.setString(4, add);
			
			int res= pst.executeUpdate();
			
			if(res>0)
			{
				out.println("Record Successfully Added");
			}
			else
			{
				out.println("Record Not Added");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		try
		{
			PreparedStatement pst= con.prepareStatement("select rollno from students");
			ResultSet res=pst.executeQuery();
			
			while(res.next())
			{
				mylist.add(res.getInt("rollno"));
			}
		
			request.setAttribute("RollNum", mylist);
			
			RequestDispatcher rec=request.getRequestDispatcher("Request.jsp");
			rec.forward(request, response);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();	
		}
		
	}

}
