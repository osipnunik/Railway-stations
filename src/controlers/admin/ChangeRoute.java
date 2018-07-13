package controlers.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jdbc.RouteDAO;
import entity.Route;

/**
 * Servlet implementation class UpdateRoute
 */
@WebServlet("/change_route")
public class ChangeRoute extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("cp1251");
		response.setContentType("text/html;charset=cp1251");
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("id");
		System.out.println("id is : " + id);
		RouteDAO dao = new RouteDAO();
		Route route = dao.getRouteById(Integer.parseInt(id));
		route.setGeneralStation(dao.getCountOfStationFromRoutes(route.getId()));
		request.setAttribute("route", route);
		RequestDispatcher rd = request.getRequestDispatcher("admin_views/update_route.jsp");
		rd.forward(request, response);
	}

}
