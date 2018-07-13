package controlers.admin;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import dao.jdbc.RouteDAO;
import entity.Route;
import listener.TestLog4jServlet;

/**
 * Servlet implementation class InsertRoute
 */
@WebServlet("/admin_views/insert_route")
public class InsertRoute extends HttpServlet {
    static final Logger LOGGER = Logger.getLogger(TestLog4jServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertRoute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.info("post servlet /insert_route");
		resp.setCharacterEncoding("cp1251");
		resp.setContentType("text/html;charset=cp1251");
		req.setCharacterEncoding("cp1251");
		String initial_station = req.getParameter("initial_station");
		String departure = req.getParameter("departure");
		String finite_station = req.getParameter("finite_station");
		String arrival = req.getParameter("arrival");
		RouteDAO dao = new RouteDAO();
		Route route = new Route(initial_station, Time.valueOf(departure), finite_station, Time.valueOf(arrival)); 
		int route_id = dao.insertRouteWithoutLayoversAndGetId(route);
		System.out.println("inserted_route_id : " + route_id);
		HttpSession session = req.getSession();
		req.setAttribute("route_id", route_id);
		session.setAttribute("route_id", route_id);
		RequestDispatcher rd = req.getRequestDispatcher("/admin_views/routes.jsp");
		rd.forward(req, resp);
	}

}
