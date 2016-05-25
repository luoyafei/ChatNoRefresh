package com.chat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chat.Factory.ServiceFactory;
import com.chat.bean.User;
import com.chat.service.UserMysqlService;

/**
 * Servlet implementation class SaveUserInfo
 */
@WebServlet("/SaveUserInfo")
public class SaveUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveUserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		int status = 0;
		
		boolean isUse = ServiceFactory.createUserService().valdateUserName(userName);
		User user = null;
		if(isUse) {
			user = ServiceFactory.createUserService().getUserInName(userName);
			if(user.getPassword().equals(password))
				status = 1;
			else
				status = 0;
		} else {
			user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			boolean flag = ServiceFactory.createUserService().insertUser(user);
			if(flag) {
				status = 1;
				user = ServiceFactory.createUserService().getUserInName(userName);
			}
		}
		
		if(status == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		}
		
		String jsonStr = "{\"status\":\"" + status + "\"}";
		out.print(jsonStr);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
