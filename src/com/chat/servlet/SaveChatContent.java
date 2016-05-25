package com.chat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

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
 * Servlet implementation class SaveChatContent
 */
@WebServlet("/SaveChatContent")
public class SaveChatContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveChatContent() {
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
		
		String chatContent = request.getParameter("content");
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		MyJsonBean mjb = new MyJsonBean();
		if(user != null) {
			Chat chat = new Chat();
			chat.setChatContent(chatContent);
			chat.setUserId(user.getUserId());
			chat.setSendDate(new Timestamp(System.currentTimeMillis()));
			
			boolean flag = ServiceFactory.createChatService().insertChat(chat);
			
			Integer status = -1;
			if(flag)
				status = 1;
			else
				status = 0;
			
			mjb.setRegister(true);
			mjb.setStatus(status);
			
		} else {
			mjb.setStatus(0);
			mjb.setRegister(false);
		}
		
		JSONObject jb = new JSONObject();
		jb.accumulate("myjson", mjb);
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
