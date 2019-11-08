package com.ds.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.ds.dao.ProjectDAO;

import javafx.scene.control.Alert;

public class LoginAction implements IAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("myID");
		String pw = request.getParameter("myPass");
		System.out.println("LoginAction, execute, id = " + id);
		System.out.println("LoginAction, execute, pw = " + pw);
		ProjectDAO dao = ProjectDAO.getInstance();
		boolean result = dao.loginMyID(id, pw);
		String resultWord = "";
		if(result == true){
			resultWord = "success";
		} else {
			resultWord = "fail";
		}
		System.out.println("resultWord = " + resultWord);
		return "redirect:main.dong?result=" + resultWord;
	}

}
