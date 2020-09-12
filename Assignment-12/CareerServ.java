

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypack.CareerExpert;

/**
 * Servlet implementation class CareerServ
 */
public class CareerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String s=request.getParameter("ql");
		
		CareerExpert rs=new CareerExpert();
		String advice=rs.getAdvice(s);
		//out.println(advice);
		
		request.setAttribute("key", advice);
		RequestDispatcher re=request.getRequestDispatcher("CareerDetails.jsp");
		re.forward(request, response);
		
	}

}
