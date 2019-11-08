package com.ds.vo;

import java.sql.Timestamp;

public class ContentVO {
	private int cNum;
	private String cType;
	private String cSubject;
	private String cContent;
	private String cFile;
	private int cReadCount;
	private Timestamp cDate;
	
	public ContentVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContentVO(int cNum, String cType, String cSubject, String cContent, String cFile, int cReadCount, Timestamp cDate) {
		super();
		this.cNum = cNum;
		this.cType = cType;
		this.cSubject = cSubject;
		this.cContent = cContent;
		this.cFile = cFile;
		this.cReadCount = cReadCount;
		this.cDate = cDate;
	}
	
	public ContentVO(String cType, String cSubject, String cContent, String cFile) {
		super();
		this.cType = cType;
		this.cSubject = cSubject;
		this.cContent = cContent;
		this.cFile = cFile;
	}

	public int getcNum() {
		return cNum;
	}

	public void setcNum(int cNum) {
		this.cNum = cNum;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public String getcSubject() {
		return cSubject;
	}

	public void setcSubject(String cSubject) {
		this.cSubject = cSubject;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public String getcFile() {
		return cFile;
	}

	public void setcFile(String cFile) {
		this.cFile = cFile;
	}

	public int getcReadCount() {
		return cReadCount;
	}

	public void setcReadCount(int cReadCount) {
		this.cReadCount = cReadCount;
	}

	public Timestamp getcDate() {
		return cDate;
	}

	public void setcDate(Timestamp cDate) {
		this.cDate = cDate;
	}

	@Override
	public String toString() {
		return "ContentVO [cNum=" + cNum + ", cType=" + cType + ", cSubject=" + cSubject + ", cContent=" + cContent
				+ ", cFile=" + cFile + ", cReadCount=" + cReadCount + ", cDate=" + cDate + "]";
	}

}
