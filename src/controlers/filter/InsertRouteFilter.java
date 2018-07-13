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

/**
 * Servlet Filter implementation class InsertRouteFilter
 */
@WebFilter("/insert_route")
public class InsertRouteFilter implements Filter {
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("its insert_route filter");
		PrintWriter out = response.getWriter();
		HttpServletRequest req = (HttpServletRequest) request;
		
		String initial_station = req.getParameter("initial_station");
		String departure = req.getParameter("departure");
		String finite_station = req.getParameter("finite_station");
		String arrival = req.getParameter("arrival");
		if(!initial_station.isEmpty() && !departure.isEmpty()&&
				!finite_station.isEmpty() && !arrival.isEmpty()) {
		chain.doFilter(request, response);
		}else out.println("<p>one of your feald is empty.You can go to insert form "
				+ "or routes page</p>");
		out.println("<a href='insert_route.jsp'>insert route</a>");
		out.println("<a href='routes'>routes</a>");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
