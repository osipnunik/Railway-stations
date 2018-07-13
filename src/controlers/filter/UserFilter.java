package controlers.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.jdbc.UserDAO;
import entity.User;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter("/user_views/*")
public class UserFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		System.out.println("its user filter");
		PrintWriter out = resp.getWriter();
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("login");
		System.out.println("login" + login);
		String role = (String) session.getAttribute("role");
		// String pass = req.getParameter("password");
		// User user = new UserDAO().getUser(login);
		System.out.println("login: " + login + " role: " + role);
		//System.out.println(!role.isEmpty() && role.equals("user"));
		if (role!=null 
				&& role.equals("user")) {
			chain.doFilter(req, resp);
		} else {
			out.println("<p>sorry, you go to this page without authentification</p>");
			out.println("<a href='../login.jsp'>log in</a>");
		}

	}

}
