package strunk.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import strunk.services.EventService;
import strunk.services.RequestService;

public class FormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public FormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Form controller reached - Served at: ").append(request.getContextPath());
//		HttpSession session=request.getSession(); 
//		System.out.println("service sess username: " + session.getAttribute("username"));
//		System.out.println("service sess password: " + session.getAttribute("password"));
//		System.out.println(request.getParameter("firstName"));
//		System.out.println(request.getParameter("lastName"));
//		System.out.println(request.getParameter("description"));
//		System.out.println(request.getParameter("startDate"));
		
		EventService eService = new EventService();
		eService.addEvent(request);
		
		RequestService rService = new RequestService();
		rService.addRequest(request);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
