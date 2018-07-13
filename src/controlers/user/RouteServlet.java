package controlers.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jdbc.RouteDAO;
import entity.Route;

/**
 * Servlet implementation class Route
 */
@WebServlet("/user_views/see_route")
public class RouteServlet extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String route_id = request.getParameter("id");
		String train_id = request.getParameter("tr_id");
		if(route_id!=null) {
			System.out.println("r-id not null");
			RouteDAO dao = new RouteDAO();
			Route route = dao.getRouteById(Integer.parseInt(route_id));
			System.out.println("route: "+ route);
			request.setAttribute("route", route);
			request.setAttribute("tr_id", train_id);
			request.getRequestDispatcher("route_display.jsp").forward(request, response);
		}
	}

}
