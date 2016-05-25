package com.chat.filter;

import java.io.IOException;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chat.bean.User;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter(filterName="MyFilter", urlPatterns="/*")
public class MyFilter implements Filter {

	private FilterConfig fc;
	
    /**
     * Default constructor. 
     */
    public MyFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		chain.doFilter(req, resp);
		/*	
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		if(user != null) {
//System.out.println(user.getUserName());
			ServletContext sc = fc.getServletContext();
			@SuppressWarnings("unchecked")
			Set<User> onlineUsers = (Set<User>)sc.getAttribute("onlineUsers");
			onlineUsers.add(user);	
			sc.setAttribute("onlineUsers", onlineUsers);*/
			/*System.out.println("###############start#################");
			System.out.println(onlineUsers.size());
			System.out.println("###############end#################");*/
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		fc = fConfig;
	}

}
