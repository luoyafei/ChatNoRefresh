package com.chat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chat.Factory.ServiceFactory;
import com.chat.bean.HeadPicture;
import com.chat.bean.MyJsonBean;
import com.chat.bean.User;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetAllHeadPicture
 */
@WebServlet("/GetAllHeadPicture")
public class GetAllHeadPicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllHeadPicture() {
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
		
		List<HeadPicture> pictures = ServiceFactory.createHeadPictureService().getAllHeadPicture();
		
		jb.accumulate("mjb", mjb);
		jb.accumulate("pictures", pictures);
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
