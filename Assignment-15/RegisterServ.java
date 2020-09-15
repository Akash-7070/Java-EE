

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import mypack.Register;
import mypack.HibernateUtil;
import org.hibernate.*;
/**
 * Servlet implementation class RegisterServ
 */
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			PrintWriter out=response.getWriter();
			
			String name = request.getParameter("nm");
			String city =request.getParameter("city");
			String email = request.getParameter("em");
			String uname = request.getParameter("um");
			String pass= request.getParameter("pass");
			try
			{
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction trans = session.beginTransaction();
				
				Register r=new Register();
				r.setCity(city);
				r.setName(name);
				r.setEmail(email);
				r.setPassword(pass);
				r.setUname(uname);
				
				session.save(r);
				trans.commit();
				
				out.println("done");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
	}

}
