package com.chat.listen;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.chat.bean.User;

/**
 * Application Lifecycle Listener implementation class MyListen
 *
 */
@WebListener
public class MyListen implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyListen() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	ServletContext context = arg0.getServletContext();
    	Set<User> onlineUsers = new HashSet<User>();
		context.setAttribute("onlineUsers", onlineUsers);
System.out.println("init service");
    }
	
}
