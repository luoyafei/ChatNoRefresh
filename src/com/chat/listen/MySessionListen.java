package com.chat.listen;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.chat.bean.User;

/**
 * Application Lifecycle Listener implementation class MySessionListen
 *
 */
@WebListener
public class MySessionListen implements HttpSessionListener,HttpSessionAttributeListener {

	private ServletContext context = null;
	
    @SuppressWarnings("unchecked")
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
    	HttpSession session = event.getSession();
    	User user = (User)session.getAttribute("user");
    	ServletContext context = session.getServletContext();
		Set<User> onlineUsers = (Set<User>)context.getAttribute("onlineUsers");
    	onlineUsers.add(user);
System.out.println("####################################");
System.out.println(user.getUserName());
    	context.setAttribute("onlineUsers", onlineUsers);
    	Set<User> temp = (Set<User>)context.getAttribute("onlineUsers");
System.out.println(temp.size());
System.out.println("####################################");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Default constructor. 
     */
    public MySessionListen() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
	public void sessionCreated(HttpSessionEvent event)  { 
         // TODO Auto-generated method stub
    	
    	if(context == null) {
    		HttpSession session = event.getSession();
    		context = session.getServletContext();
    	}
System.out.println(" a session had been create");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  { 
         // TODO Auto-generated method stub
    	HttpSession session = event.getSession();
    	User user = (User)session.getAttribute("user");
    	ServletContext context = session.getServletContext();
    	@SuppressWarnings("unchecked")
		Set<User> onlineUsers = (Set<User>)context.getAttribute("onlineUsers");
    	onlineUsers.remove(user);
System.out.println(" a session had been delete");
    }
}
