package controlers.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jdbc.LayoverDAO;
import dao.jdbc.RouteDAO;

/**
 * Servlet implementation class UpdateLayover
 */
@WebServlet("/update_layover")
public class UpdateLayover extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("cp1251");
		response.setCharacterEncoding("cp1251");
		response.setContentType("text/html;charset=cp1251");
		String layover_id = request.getParameter("lo_id");
		String route_id = request.getParameter("route_id");
		String station = request.getParameter("station");
		String departure = request.getParameter("departure");
		String parking_min = request.getParameter("parking_min");
		String arrival = request.getParameter("arrival");
		System.out.println(layover_id);
		if (!layover_id.isEmpty()) {
			Map<String, String> map = new LinkedHashMap<>();
			if (!station.isEmpty())
				map.put("station", station);
			if (!departure.isEmpty())
				map.put("departure", departure);
			if (!parking_min.isEmpty())
				map.put("parking_min", parking_min);
			if (!arrival.isEmpty())
				map.put("arrival", arrival);
			LayoverDAO dao = new LayoverDAO();
			int idInt = Integer.parseInt(layover_id);
			dao.updateLayover(idInt, map);
			map = null;
			response.sendRedirect("change_route?id=" + route_id);
			
		}
	}

}
