package controlers.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jdbc.RouteDAO;

/**
 * Servlet implementation class DeleteRoute
 */
@WebServlet("/delete_route_redirect")
public class DeleteRouteRedirect extends HttpServlet {
	
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			PrintWriter pw = response.getWriter();
			String id = request.getParameter("id");
			System.out.println("id is : " + id);
			if(!id.isEmpty()) {
			RouteDAO dao = new RouteDAO();
			dao.deleteRoute(id);
			response.sendRedirect("routes");
			}
	}

}
