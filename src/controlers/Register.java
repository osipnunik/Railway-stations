package controlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import services.UserService;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		String role = request.getParameter("role");
		String name = request.getParameter("name");
		System.out.println("password is : "+pass);
		if (role!=null && role.equals("on")) {
			role = "admin";
		} else {
			role = "user";
		}

		User user = new User(login, pass, role, name);
		System.out.println(user);
		UserService service = new UserService();
		service.insertUser(user);
		response.sendRedirect("login.jsp");
	}

}
