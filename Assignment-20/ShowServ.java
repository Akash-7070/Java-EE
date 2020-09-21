

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import mypack.Course;
import mypack.HibernateUtil;

/**
 * Servlet implementation class ShowServ
 */
public class ShowServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try
		{
			Session ss=HibernateUtil.getSessionFactory().openSession();
			
			Query<?> query=ss.createQuery("from Course");
			
			List<Course> mylist=(List<Course>)query.list();
			
			request.setAttribute("key", mylist);
		    RequestDispatcher req=request.getRequestDispatcher("Del.jsp");
			req.forward(request, response);
			
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

}
