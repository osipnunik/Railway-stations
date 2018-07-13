package controlers.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jdbc.TrainDAO;
import entity.Train;
/**
 * Servlet implementation class UserWantStation
 */
@WebServlet("/user_views/user_want_station")
public class UserWantStation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		System.out.println("uw : "+from+"-"+to);
		System.out.println(to.equals("Лозовая"));
		if(!from.isEmpty() && !to.isEmpty()) {
			List<Train> trains = new ArrayList<>();
			TrainDAO dao = new TrainDAO();
			
			trains = dao.getTrains(from, to);
			System.out.println(trains.toString());
			if(trains != null)
				request.setAttribute("trains", trains);
				request.getRequestDispatcher("user_trains.jsp").forward(request, response);
		}
	}

}
