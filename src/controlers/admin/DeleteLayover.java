package controlers.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jdbc.LayoverDAO;
import dao.jdbc.RouteDAO;

/**
 * Servlet implementation class DeleteLayover
 */
@WebServlet("/delete_layover")
public class DeleteLayover extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("id");
		String r_id = request.getParameter("r_id");
		System.out.println("id is : " + id);
		if(!id.isEmpty()) {
		LayoverDAO dao = new LayoverDAO();
		dao.deleteLayover(id);
		response.sendRedirect("change_route?id="+r_id);
		//pw.println("<p>Layover with id " + id +" was deleted <p>");
		}
	}

}
