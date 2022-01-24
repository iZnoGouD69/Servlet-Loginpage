package com.example.notes;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NotesController
 */
//@WebServlet("/NotesController")
@WebServlet("/")

public class NotesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    private NotesDao notesDao;
    
    public void init() {
    	notesDao = new NotesDaoImplementation();
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();
		try {
			switch(action) {
			case "/new":
				showNewForm(request,response);
				break;
				
			case "/insert":
	            insertTodo(request, response);
	            break;
	            
			case "/list":
                listTodo(request, response);
                break;
				
			default:
			    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			    dispatcher.forward(request, response);
			    break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		
	}
	
	private void listTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getSession().getAttribute("user").toString();
		List<NotesModel> listNotes = notesDao.selectAllNotes(username);
		request.setAttribute("listTodo", listNotes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/notes.jsp");
		dispatcher.forward(request, response);
	}

	private void insertTodo(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		// TODO Auto-generated method stub
		 String title = request.getParameter("title");
	     String username = request.getSession().getAttribute("user").toString();
	     String description = request.getParameter("description");

	     /*DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
	     LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"),df);*/

	     boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
	     NotesModel notesModel = new NotesModel(title, username, description, LocalDate.now(), isDone);
	     notesDao.insertNote(notesModel);
	     response.sendRedirect("list");
		
	}	

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("notes_form.jsp");
		        dispatcher.forward(request, response);
		    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
