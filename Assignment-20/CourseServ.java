

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mypack.Course;
import mypack.HibernateUtil;
import mypack.Module;

/**
 * Servlet implementation class CourseServ
 */
public class CourseServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cname=request.getParameter("cname");
		String mname[]=request.getParameterValues("module");
		HashSet<Module> mymodule=new HashSet<Module>();
		
		for(int i=0;i<mname.length;i++)
		{
			Module m= new Module();
			m.setMname(mname[i]);
			mymodule.add(m);
		}
		
		Course c= new Course();
		c.setCname(cname);
		c.setSet(mymodule);
		
		try
		{
			Session s=HibernateUtil.getSessionFactory().openSession();
			Transaction tr=s.beginTransaction();
			
			s.save(c);
			tr.commit();
		
			PrintWriter out=response.getWriter();
			out.println("Form Successfully Submit");
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
