
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypack.Person;

/**
 * Servlet implementation class PersonServ1
 */
public class PersonServ1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Person p1=new Person();
		p1.setName("Akash");
		p1.setAge(20);

		Person p2=new Person();
		p2.setName("Ganesh");
		p2.setAge(25);
		
		Person p3=new Person();
		p3.setName("Vaibhav");
		p3.setAge(28);
		
		List<Person> list=new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);

		request.setAttribute("mylist",list);
			
		RequestDispatcher rec=request.getRequestDispatcher("Result.jsp");
		rec.forward(request, response);
	}

}
