package com.example.registration;

import java.io.IOException;

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
	
	private UserDao userDao = new UserDao();
       
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
		String temp = null;
		
		if(request.getParameter("errorMsg") == null) {
			temp = RegistrationValidator.validate(passwrod, request.getParameter("errorMsgPassword"));
			request.setAttribute("errorMsgPassword", temp);
		}
		System.out.print(request.getAttribute("errorMsgPassword"));
		if(temp == null) {
			UserRegistration newUser = new UserRegistration();
			newUser.setFirstname(firstname);
			newUser.setUsername(username); 
			newUser.setPassword(passwrod);
			
			try {
				userDao.registerUser(newUser);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		//response.sendRedirect("registration.jsp");
		RequestDispatcher reqdis = request.getRequestDispatcher("registration.jsp");
		reqdis.include(request, response);
	}

}
