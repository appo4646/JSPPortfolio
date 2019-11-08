package com.ds.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.action.DeleteReplyRunAction;
import com.ds.action.DetailViewAction;
import com.ds.action.IAction;
import com.ds.action.LoginAction;
import com.ds.action.MainAction;
import com.ds.action.ReplyRunAction;
import com.ds.action.WriteRunAction;


/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.dong")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String PREFIX = "WEB-INF/views/";
    private static final String POSTFIX = ".jsp";
    
    private HashMap<String, IAction> map = new HashMap<String, IAction>();
    
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	
    	map.put("main", new MainAction());
    	map.put("login", new LoginAction());
    	map.put("write_run", new WriteRunAction());
    	map.put("detail_view", new DetailViewAction());
    	map.put("reply_run", new ReplyRunAction());
    	map.put("delete_reply_run", new DeleteReplyRunAction());
    }
    
    private String getCommand(HttpServletRequest request){
    	String uri = request.getRequestURI();
    	String context = request.getContextPath();
    	int beginIndex = context.length() + 1 ;
    	int endIndex = uri.indexOf(".");
    	String command = uri.substring(beginIndex, endIndex);
    	return command;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = getCommand(request);
		IAction iAction = null;
		iAction = map.get(command);
		
		String view = iAction.execute(request, response);
		
		if (view.startsWith("redirect:")){
			int beginIndex = view.indexOf(":") + 1;
			view = view.substring(beginIndex);
			response.sendRedirect(view);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(PREFIX + view +POSTFIX);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
