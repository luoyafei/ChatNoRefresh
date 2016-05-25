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

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DealChoiceHead
 */
@WebServlet("/DealChoiceHead")
public class DealChoiceHead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealChoiceHead() {
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
		
		String picture = request.getParameter("picture");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		user.setUserPicture(picture);
		boolean flag = ServiceFactory.createUserService().updateUser(user);
		if(flag) {
			session.removeAttribute("user");
			session.setAttribute("user", user);
			response.sendRedirect("/ChatNoRefresh/chat.html");
			return;
		} else {
			response.sendRedirect("/ChatNoRefresh/choicePicture.html");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
