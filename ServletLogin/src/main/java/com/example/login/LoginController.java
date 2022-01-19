package com.example.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		request.setAttribute("user", username);
		
		try {
			if(LoginDao.validate(username, password)) {
				RequestDispatcher reqdis = request.getRequestDispatcher("welcome");
				reqdis.forward(request, response);
			} else {
				//pw.print("Sorry username or password error");
				String err = "Sorry username or password error";
				request.setAttribute("errorMsg", err);
				RequestDispatcher reqdis = request.getRequestDispatcher("index.jsp");
				reqdis.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(username.equals("admin") && password.equals("admin")) {
//			RequestDispatcher rs = request.getRequestDispatcher("welcome");
//            rs.forward(request, response);
//            response.sendRedirect("welcome");
//			
//		} else {
//			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
//	        rs.include(request, response);
//		}
		
	}

}
