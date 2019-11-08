package com.ds.util;

import java.io.File;
import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUploader {
	
	public static MultipartRequest fileUpload (HttpServletRequest request){
		System.out.println(request.getMethod());
		ServletContext ctx = request.getServletContext();
		String uploadPath = ctx.getRealPath("upload");
		System.out.println("uploadPath = " + uploadPath);
		
		File f = new File(uploadPath);
		if(!f.exists()){
			f.mkdir();
		}
		
		MultipartRequest multi = null;
		
		try{
			multi = new MultipartRequest(request,
										 uploadPath,
										 5*1024*1024,
										 "utf-8",
										 new DefaultFileRenamePolicy());
			
		} catch (IOException e){
			e.printStackTrace();
		}
		return multi;
	}
	
}
