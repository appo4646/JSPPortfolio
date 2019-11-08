package com.ds.action;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.dao.ProjectDAO;
import com.ds.vo.ContentVO;
import com.ds.vo.ReplyVO;

public class DetailViewAction implements IAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int cNum = Integer.parseInt(request.getParameter("cnum"));
		System.out.println("DetailViewAction, cNum = " + cNum);
		
		ProjectDAO dao = ProjectDAO.getInstance();
		ContentVO vo = dao.selectByNum(cNum);
		ArrayList<ReplyVO> list = dao.replyByNum(cNum);
		
		System.out.println("DetailViewAction, vo = " + vo);
		System.out.println("DetailViewAction, list = " + list);
		String cFile = vo.getcFile();
		System.out.println("DetailViewAction, cFile = " + cFile);
		if (cFile != null) {
			boolean isContain = cFile.contains(",");
			if (isContain == true) {
				StringTokenizer tokenizer = new StringTokenizer(cFile, ",");
				ArrayList<String> fileNames = new ArrayList<>();
				while (tokenizer.hasMoreTokens()) {
					String fileName = tokenizer.nextToken();
					fileNames.add(fileName);
				}
//				String cFile1st = tokenizer.nextToken();
//				String cFile2nd = tokenizer.nextToken();
//				String cFile3rd = tokenizer.nextToken();
				
//				System.out.println("cFile1st:" + cFile1st);
//				System.out.println("cFile2nd:" + cFile2nd);
//				System.out.println("cFile3rd:" + cFile3rd);
//				if (cFile1st != null){
//					request.setAttribute("cFile1st", cFile1st);
//					if (cFile2nd != null){
//						request.setAttribute("cFile2nd", cFile2nd);
//						if (cFile3rd != null){
//							request.setAttribute("cFile3rd", cFile3rd);
//						}
//					}
//				}
				
				request.setAttribute("fileNames", fileNames);
				
			}
		}
		request.setAttribute("vo", vo);
		request.setAttribute("list", list);
		return "detail_view";
	}

}
