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

import dao.jdbc.UserDAO;
import entity.User;

/*@WebFilter(urlPatterns = { "/admin/*", "/admin*", "/routes", "/delete_layover", "/delete_route_redirect",
		"/insert_layover", "/insert_layover_update_redirect", "/insert_route", 
		"/routes", "/update_layover", "/update_route", "/update_route_redirect"
		})
public class AdminFilter implements Filter {

  
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("its filter");
		PrintWriter out = response.getWriter();
		HttpServletRequest req = (HttpServletRequest) request;
		
		String login = req.getParameter("login");
		String pass = req.getParameter("password");
				
		User user = new UserDAO().getUser(login);
		if (user != null && user.getPassword().equals(pass)) {
			if(user.getRole().equals("admin")) {
				chain.doFilter(request, response);
			}
		}else {
			out.println("you are not our login correctly");
			out.println("<a href='login.jsp'>go to login page</a>");
		}
		//chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}*/
