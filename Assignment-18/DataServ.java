

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.query.*;
import org.hibernate.Session;

import mypack.Dept;
import mypack.HibernateUtil;

/**
 * Servlet implementation class DataServ
 */
public class DataServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String ss = request.getParameter("loc");
		
		try
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query<?> query = session.createQuery("from Dept where loc=:val");
			query.setParameter("val",ss);
			List<Dept> mylist = (List<Dept>)query.list();
			
			request.setAttribute("key",mylist);
			RequestDispatcher rd = request.getRequestDispatcher("Data.jsp");
			rd.forward(request, response);
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	

	}

}
