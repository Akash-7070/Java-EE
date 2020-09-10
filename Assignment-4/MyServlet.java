

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	PrintWriter pw=response.getWriter();
	
	List<String> mylist=new ArrayList<String>();
	mylist.add("Ganesh");
	mylist.add("Akash");
	mylist.add("Vaibhav");
	mylist.add("Anand");
	
	HttpSession session=request.getSession();
	session.setAttribute("Friend", mylist);
	pw.println("session successfully created");
	
}
}