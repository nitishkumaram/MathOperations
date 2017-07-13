package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MathServlet
 */
@WebServlet("/mathServlet.do")
public class MathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MathServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String op=request.getParameter("operation");
		int a=Integer.valueOf(request.getParameter("a"));
		int b=Integer.valueOf(request.getParameter("b"));
		PrintWriter pw=response.getWriter();
		
		response.setContentType("text/html");
		pw.print("<html><body>");
		try{
		if(op.equalsIgnoreCase("add"))
			pw.print("<h1>result is :- "+(a+b)+"</h1>");
		else if(op.equalsIgnoreCase("sub"))
			pw.print("<h1>result is :- "+(a-b)+"</h1>");
		else if(op.equalsIgnoreCase("mul"))
			pw.print("<h1>result is :- "+(a*b)+"</h1>");
		else if(op.equalsIgnoreCase("div"))
			pw.print("<h1>result is :- "+(a/b)+"</h1>");
		else
			pw.print("<h1>result is :- No operations created"+"</h1>");
		}
		catch(Exception e)
		{
			pw.print("<h1>result is :- Exception :-  "+e+"</h1>");
		}
		pw.print("</body></html>");
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
		dispatcher.include(request, response);
	}
}
