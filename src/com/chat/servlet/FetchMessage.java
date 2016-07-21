package com.chat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chat.Factory.ServiceFactory;
import com.chat.bean.Chat;
import com.chat.bean.MyJsonBean;
import com.chat.bean.User;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class FetchMessage
 */
@WebServlet("/FetchMessage")
public class FetchMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchMessage() {
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
		MyJsonBean mjb = new MyJsonBean();
		Integer status = -1;
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		JSONObject jb = new JSONObject();
		
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
		
		Integer count = ServiceFactory.createChatService().getAllChatCounts();
		Integer notread = user.getReadCount();
		List<Chat> chats = ServiceFactory.createChatService().getAllChats(0, (count-notread)==1?1:0);
		List<User> users = new ArrayList<User>();
		if(chats.size() > 0) {
			status = 0;
			for(int i = 0; i < chats.size(); i++) {
				User u = ServiceFactory.createUserService().getUserInId(chats.get(i).getUserId());
				users.add(u);
			}
		}
		
		user.setReadCount(count);
		boolean flag = ServiceFactory.createUserService().updateUser(user);//将用户的未读信息就行更新
		if(!flag)
			System.out.println("用户未读消息更新失败");
		
		mjb.setStatus(status);
		jb.accumulate("mjb", mjb);
		jb.accumulate("chats", chats);
		jb.accumulate("users", users);
		jb.accumulate("user", user);
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
