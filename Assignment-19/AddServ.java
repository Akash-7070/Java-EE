

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypack.StrudentDAO;
import mypack.Student;
import mypack.StudentDAODataImpl;
import mypack.StudentDAOFileImpl;


/**
 * Servlet implementation class AddServ
 */

public class AddServ extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
	
	static void perform(StrudentDAO ref, Student sf)
	{
		ref.addStudent(sf);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		int rollno= Integer.parseInt(request.getParameter("rno"));
		String name= request.getParameter("nm");
		String city= request.getParameter("city");
		String storagefor= request.getParameter("same");
		
		Student st=new Student();
		st.setName(name);
		st.setCity(city);
		
		if(storagefor.equalsIgnoreCase("file"))
		{
			st.setRollno(rollno);
			perform(new StudentDAOFileImpl(),st);		
		}
		
		else if(storagefor.equalsIgnoreCase("database"))
		{
			perform(new StudentDAODataImpl(),st);	
		}
		else
		{
			out.println("plz select appropriciate option");
		}	
		
	}

}
