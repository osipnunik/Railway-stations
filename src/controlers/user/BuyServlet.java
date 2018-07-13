package controlers.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.jdbc.CarriageDAO;
import dao.jdbc.CarriageType;
import dao.jdbc.RouteDAO;
import entity.Carriage;
import entity.Route;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/user_views/buy")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String train_id = request.getParameter("tr_id");
		String carriageType = request.getParameter("type");

		if (!train_id.isEmpty() && !carriageType.isEmpty()) {
			System.out.println("train_id : " + train_id);
			CarriageDAO dao = new CarriageDAO();
			carriageType = makeTypeProper(carriageType);
			List<Carriage> carriages = dao.getAvailableCarriages(Integer.parseInt(train_id), carriageType);
			
			System.out.println("cariage Type : " + carriageType);
			System.out.println("carriages : " + carriages);
			
			HttpSession session = request.getSession();
			session.setAttribute("tr_id", train_id);
			session.setAttribute("carriages", carriages);
			request.setAttribute("carriages", carriages);
			request.setAttribute("tr_id", train_id);
			request.getRequestDispatcher("buy.jsp"/* "route_display.jsp" */).forward(request, response);
		}
	}

	private String makeTypeProper(String carriageType) {
		if (carriageType.equals("p")) {
			return CarriageType.PLATSCART.toString();
		}
		if (carriageType.equals("c")) {
			return CarriageType.COUPE.toString();
		}
		if (carriageType.equals("g")) {
			return CarriageType.GENERAL.toString();
		}
		return null;

	}
}
