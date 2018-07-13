package controlers.admin;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import dao.jdbc.LayoverDAO;
import entity.LayOver;
import listener.TestLog4jServlet;

/**
 * Servlet implementation class InsertLayoverUpdateRedirect
 */
@WebServlet("/insert_layover_update_redirect")
public class InsertLayoverUpdateRedirect extends HttpServlet {
    static final Logger log = Logger.getLogger(TestLog4jServlet.class);
    	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("post /insert_layover_update_redirect");
		request.setCharacterEncoding("cp1251");
		response.setCharacterEncoding("cp1251");
		response.setContentType("text/html;charset=cp1251");
		String route_id = request.getParameter("route_id");
		String station = request.getParameter("station");
		String departure = request.getParameter("departure");
		String parking_min = request.getParameter("parking_min");
		String arrival = request.getParameter("arrival");
		int r_id = Integer.parseInt(route_id);
		int park_min = Integer.parseInt(parking_min);
		LayOver layover = new LayOver(r_id, station, Time.valueOf(departure), park_min, Time.valueOf(arrival));
		LayoverDAO dao = new LayoverDAO();
		System.out.println("inserted layover: "+ layover);
		dao.insertLayover(layover);
		request.setAttribute("route_id", route_id);
		response.sendRedirect("change_route?id="+route_id);
		/*RequestDispatcher rd = request.getRequestDispatcher("update_route_redirect?id="+route_id);
		rd.forward(request, response);*/
	}
	
	/*@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("get /insert_layover_update_redirect");
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
		System.out.println("inserted layover: "+ layover);
		request.setAttribute("route_id", route_id);
		RequestDispatcher rd = request.getRequestDispatcher("update_route_redirect?id="+route_id);
		rd.forward(request, response);
	}*/
}
