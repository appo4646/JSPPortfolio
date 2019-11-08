package com.ds.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.dao.ProjectDAO;
import com.ds.vo.ReplyVO;

public class ReplyRunAction implements IAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int cNum = Integer.parseInt(request.getParameter("cnum"));
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String userComment = request.getParameter("userComment");
		if (userID != null && userPW != null){
			ReplyVO vo = new ReplyVO(cNum, userID, userPW, userComment);
			System.out.println("ReplyRunAction, ReplyVO = " + vo);
			
			ProjectDAO dao = ProjectDAO.getInstance();
			boolean result = dao.insertReply(vo);
			System.out.println("ReplyRunAction, result = " + result);
			
		}
		
		return "redirect:detail_view.dong?cnum=" + cNum;
	}

}
