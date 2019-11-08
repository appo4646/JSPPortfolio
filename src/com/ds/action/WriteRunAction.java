package com.ds.action;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.dao.ProjectDAO;
import com.ds.util.FileUploader;
import com.ds.vo.ContentVO;
import com.oreilly.servlet.MultipartRequest;

public class WriteRunAction implements IAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MultipartRequest multi = FileUploader.fileUpload(request);
		String ctype = multi.getParameter("ctype");
		String cSubject = multi.getParameter("csubject");
		String cContent = multi.getParameter("ccontent");
		Enumeration<?> enumer = multi.getFileNames();
		
		ArrayList<String> fileNames = new ArrayList<>();
		
		
//		String cfilePath = multi.getParameter("realFiles");
//		int i = 0;
		while (enumer.hasMoreElements()) {
			String name = (String) enumer.nextElement();
			String filesystemName = multi.getFilesystemName(name);
			fileNames.add(filesystemName);
		};
		
		
//		String fileName = (String) enumer.nextElement();
//		String realFile = multi.getFilesystemName(fileName);	
//		System.out.println("WriteRunAction, multi = " + multi);
//		System.out.println("WriteRunAction, enumer = " + enumer);
//		System.out.println("WriteRunAction, fileName = " + fileName);
//		System.out.println("WriteRunAction, realFile = " + realFile);
//		String fileName2 = (String) enumer.nextElement();
//		String fileName3 = (String) enumer.nextElement();
		
		
		
		String realFile = "";
		for (String fileName : fileNames) {
			realFile += fileName + ",";
		}
		
		realFile = realFile.substring(0, realFile.length() - 1);
		System.out.println("realFile:"+ realFile);
	
//		System.out.println("WriteRunAction, fileName2 = " + fileName2);
//		System.out.println("WriteRunAction, fileName3 = " + fileName3);
//		System.out.println("WriteRunAction, realFile2 = " + realFile2);
//		System.out.println("WriteRunAction, realFile3 = " + realFile3);
//		ProjectDAO dao = ProjectDAO.getInstance();
//		System.out.println("WriteRunAction, realFile = " + realFile);
//		ContentVO vo = new ContentVO(ctype, cSubject, cContent, realFile);
//		System.out.println("WriteRunAction, execute, vo = " + vo);
//		boolean result = dao.writeContent(vo);
//		System.out.println("WriteRunAction, execute = " + result);
		
		return "redirect:main.dong?result=success";
	}

}
