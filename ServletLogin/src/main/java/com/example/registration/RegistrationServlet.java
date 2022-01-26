package com.example.registration;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RegisterUserToDb accessDb = new RegisterUserToDb();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//RegistrationValidator rv = new RegistrationValidator();
		
		String username = request.getParameter("username");
		String passwrod = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String passwordMsg = null;
		
		if(request.getParameter("errorMsg") == null) {
			passwordMsg = RegistrationValidator.validate(passwrod, request.getParameter("errorMsgPassword"));
			request.setAttribute("errorMsgPassword", passwordMsg);
		}
		System.out.print(request.getAttribute("errorMsgPassword"));
		if(passwordMsg == null && username != "") {
			RegisterUser newUser = new RegisterUser();
			newUser.setFirstname(firstname);
			newUser.setUsername(username); 
			newUser.setPassword(passwrod);
			
			try {
				accessDb.registerUser(newUser);
				response.sendRedirect("index.jsp");
			} catch (ClassNotFoundException | SQLException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("errorMsgPassword", "Try a different username");
			}
		}
		//response.sendRedirect("registration.jsp");
		RequestDispatcher reqDis = request.getRequestDispatcher("registration.jsp");
		reqDis.include(request, response);
		System.out.println(request.getAttribute("errorMsgPassword"));
	}

}
