package controlers.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jdbc.RouteDAO;
import entity.Route;
import services.AdminService;
import services.Service;

@WebServlet("/routes")
public class RoutesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		AdminService service = new AdminService();
		List<Route> list = service.getRouts();
		request.setAttribute("routes", list);
		request.getRequestDispatcher("admin_views/routes.jsp").forward(request, response);
	}

	
}
