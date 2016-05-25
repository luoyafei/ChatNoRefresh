package com.chat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chat.bean.MyJsonBean;
import com.chat.bean.User;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetOnlineUsers
 */
@WebServlet("/GetOnlineUsers")
public class GetOnlineUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOnlineUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		MyJsonBean mjb = new MyJsonBean();
		Integer status = -1;
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		JSONObject jb = new JSONObject();
		
		/**
		 * 获取所有在线的用户！
		 * */
		ServletContext sc = getServletContext();
		Set<User> onlineUsers = (Set<User>)sc.getAttribute("onlineUsers");
		
		if(user != null)
			mjb.setRegister(true);
		else {
			mjb.setRegister(false);
			jb.accumulate("mjb", mjb);
			out.print(jb.toString());
			out.flush();
			out.close();
			return;
		}
		
		mjb.setStatus(status);
		jb.accumulate("mjb", mjb);
		jb.accumulate("onlineUsers", onlineUsers.toArray());
		out.print(jb.toString());
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
