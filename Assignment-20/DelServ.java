

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import mypack.Course;
import mypack.HibernateUtil;

/**
 * Servlet implementation class DelServ
 */
public class DelServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try
		{
			int id=Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
            
			Session ss=HibernateUtil.getSessionFactory().openSession();
			Transaction t=ss.beginTransaction();
			
			
			Query<?> query=ss.createSQLQuery("delete from module where cid=?");
			query.setParameter(1,id);
			int k=query.executeUpdate();
			
			
			query=ss.createQuery("delete from Course c where c.cId=:val");
			query.setParameter("val",id);
			int d=query.executeUpdate();
			
			PrintWriter out=response.getWriter();
			out.println("Delete Successfully");
	            
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
