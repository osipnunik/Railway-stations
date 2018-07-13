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

import dao.jdbc.RouteDAO;

/**
 * Servlet implementation class UpdateRoute
 */
@WebServlet("/update_route")
public class UpdateRoute extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("cp1251");
		response.setCharacterEncoding("cp1251");
		response.setContentType("text/html;charset=cp1251");
		String initStation = request.getParameter("initial_station");
		String departure = request.getParameter("departure");
		String finite_station = request.getParameter("finite_station");
		String arrival = request.getParameter("arrival");
		String generalStation = request.getParameter("generalStation");
		String id = request.getParameter("id");
		System.out.println(id);
		if (!id.isEmpty()) {
			Map<String, String> map = new LinkedHashMap<>();
			if (!initStation.isEmpty())
				map.put("initial_station", initStation);
			if (!departure.isEmpty())
				map.put("departure", departure);
			if (!finite_station.isEmpty())
				map.put("finite_station", finite_station);
			if (!arrival.isEmpty())
				map.put("arrival", arrival);
			RouteDAO dao = new RouteDAO();
			// String id = "1";
			int idInt = Integer.parseInt(id);
			dao.updateRoute(idInt, map);
			map = null;
			response.sendRedirect("change_route?id="+id);
			
		}
	}

}
