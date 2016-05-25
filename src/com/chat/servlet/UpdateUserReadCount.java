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

/**
 * Servlet implementation class UpdateUserReadCount
 */
@WebServlet("/UpdateUserReadCount")
public class UpdateUserReadCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserReadCount() {
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
		String count = request.getParameter("count");
		//将用户的未读消息数目进行更新
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer updateCount = user.getReadCount() + Integer.valueOf(count);
		if(updateCount < 0) {
			updateCount = 0;
		}
		user.setReadCount(updateCount);
		boolean flag = ServiceFactory.createUserService().updateUser(user);
		if(flag)
			System.out.println("更新成功！");
		else
			System.out.println("更新失败！");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
