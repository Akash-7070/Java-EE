

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.*;

import mypack.HibernateUtil;
import mypack.Product;

/**
 * Servlet implementation class ViewServ
 */
public class ViewServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			Session session=HibernateUtil.getSessionFactory().openSession();
			
			Query <?> ref=session.createQuery("from Product");
			
			List<Product> mylist=(List<Product>) ref.list();
			
			request.setAttribute("key", mylist);
			RequestDispatcher res=request.getRequestDispatcher("View.jsp");
			res.forward(request, response);
			
		}
		catch(Exception ee)
		{
			
		}
	}

}
