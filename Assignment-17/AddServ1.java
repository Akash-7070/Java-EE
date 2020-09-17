

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mypack.HibernateUtil;
import mypack.Product;

/**
 * Servlet implementation class AddServ1
 */
public class AddServ1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("nm");
		int qty=Integer.parseInt(request.getParameter("pr").trim());
		int price=Integer.parseInt(request.getParameter("qt").trim());
		
		try 
		{
			
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tra=session.beginTransaction();
		Product p1=new Product();
		p1.setName(name);
		p1.setQty(qty);
		p1.setPrice(price);
	    session.save(p1);
	    tra.commit();
	    RequestDispatcher req=request.getRequestDispatcher("Home.jsp");
	    req.forward(request, response);
		
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

}
