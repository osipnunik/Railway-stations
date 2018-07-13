package controlers.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jdbc.CarriageDAO;

/**
 * Servlet implementation class BuyingServlet
 */
@WebServlet("/user_views/buy_ticket")
public class BuyingTicketServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarriageDAO dao = new CarriageDAO();
		String cardNumber = (String) request.getParameter("card number");
		String carrige_id = (String) request.getParameter("car_id");
		//String carrige_id = (String) request.getAttribute("car_id");
		System.out.println(": "+carrige_id);
		System.out.println("buyingservletticket: "+carrige_id);
		if (carrige_id != null) {// && !cardNumber.isEmpty()) {
			dao.buying(Integer.parseInt(carrige_id));
			PrintWriter pw = response.getWriter();
			pw.println("<p>buying success</p>");
			pw.println("<a href='user_form.jsp'>go to search form</a>");
		}
	}

}
