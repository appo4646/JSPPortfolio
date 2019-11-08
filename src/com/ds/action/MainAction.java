package com.ds.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.dao.ProjectDAO;
import com.ds.vo.ContentVO;
import com.ds.vo.PagingDTO;
import com.ds.vo.SearchDTO;

public class MainAction implements IAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String result = request.getParameter("result");
		request.setAttribute("result", result);
		System.out.println("result = " + result);
		
		SearchDTO sDTO = null;
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		
		if (searchType == null){
			searchType = "";
		}
		
		if (searchValue == null){
			searchValue = "";
		}
		
		sDTO = new SearchDTO(searchType, searchValue);
		System.out.println("MainAction, searchType = " + searchType);
		System.out.println("MainAction, searchValue = " + searchValue);
		System.out.println("MainAction, sDTO = " + sDTO );
		int nowPage = 1; 
		String str_nowPage = request.getParameter("page");
		if (str_nowPage != null){
			nowPage = Integer.parseInt(str_nowPage);
		}
		
		ProjectDAO dao = ProjectDAO.getInstance();
		int totalCount = dao.allContentCount(sDTO); 
		
		PagingDTO pDTO = new PagingDTO();
		pDTO.setNowPage(nowPage, totalCount);
		System.out.println("MainAction, pDTO = " + pDTO);
		System.out.println("MainAction, sDTO = " + sDTO);
		System.out.println("MainAction, totalCount = " + totalCount);
		ArrayList<ContentVO> list = dao.selectAll(pDTO, sDTO);
		request.setAttribute("searchDTO", sDTO);
		request.setAttribute("list", list);
		request.setAttribute("pagingDTO", pDTO);
		System.out.println("MainAction, execute, list = " + list);
		return "main";
	}

}
