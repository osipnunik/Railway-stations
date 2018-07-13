package controlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.jdbc.UserDAO;
import entity.User;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String login = req.getParameter("login");
		String pass = req.getParameter("password");
		User user = new UserDAO().getUser(login);
		System.out.println(user);
		if (user != null && user.getPassword().equals(pass)) {
			HttpSession session = req.getSession();
			session.setAttribute("login", login);
			session.setAttribute("role", user.getRole());
			
			req.setAttribute("login", login);
			req.setAttribute("role", user.getRole());
			System.out.println(user.getRole());
			if (user.getRole().equals("admin")) {
				req.getRequestDispatcher("/admin_views/welcome_admin.jsp").forward(req, resp);
				System.out.println("admin go to send redirect");
				//resp.sendRedirect("welcome_admin.jsp");
			} else if (user.getRole().equals("user")) {
				req.getRequestDispatcher("welcome_user.jsp").forward(req, resp);
				System.out.println("user go to send redir");
				//resp.sendRedirect("welcome_user.jsp");
			}
		}

	}

}
