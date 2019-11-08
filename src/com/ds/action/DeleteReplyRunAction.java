package com.ds.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.dao.ProjectDAO;

public class DeleteReplyRunAction implements IAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int cNum = Integer.parseInt(request.getParameter("cNum"));
		int rNum = Integer.parseInt(request.getParameter("rNum"));
		String userPW = request.getParameter("deletePW");
		System.out.println("DeleteRunAction, execute, cNum = " + cNum);
		System.out.println("DeleteRunAction, execute, rNum = " + rNum);
		System.out.println("DeleteRunAction, execute, userPW = " + userPW);
		
		ProjectDAO dao = ProjectDAO.getInstance();
		boolean result = dao.deleteReply(rNum,userPW);
		System.out.println("DeleteReplyRunAction, deleteReply = " + result);
		return "redirect:detail_view.dong?cnum=" + cNum + "&result="+ result;
	}

}
