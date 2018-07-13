package controlers.admin;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jdbc.LayoverDAO;
import entity.LayOver;

/**
 * Servlet implementation class InsertLayover
 */
@WebServlet("/insert_layover")
public class InsertLayover extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String route_id = request.getParameter("route_id");
		String station = request.getParameter("station");
		String departure = request.getParameter("departure");
		String parking_min = request.getParameter("parking_min");
		String arrival = request.getParameter("arrival");
		int r_id = Integer.parseInt(route_id);
		int park_min = Integer.parseInt(parking_min);
		LayOver layover = new LayOver(r_id, station, Time.valueOf(departure), park_min, Time.valueOf(arrival));
		LayoverDAO dao = new LayoverDAO();
		dao.insertLayover(layover);
		request.setAttribute("route_id", route_id);
		RequestDispatcher rd = request.getRequestDispatcher("admin_views/insert_route.jsp");
		rd.forward(request, response);
	}

}
