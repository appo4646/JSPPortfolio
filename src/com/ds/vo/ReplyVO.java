package com.ds.vo;

import java.sql.Timestamp;

public class ReplyVO {
	private int cNum;
	private int rNum;
	private String userID;
	private String userPW;
	private String userComment;
	private Timestamp rDate;
	
	public ReplyVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReplyVO(int cNum, int rNum, String userID, String userPW, String userComment, Timestamp rDate) {
		super();
		this.cNum = cNum;
		this.rNum = rNum;
		this.userID = userID;
		this.userPW = userPW;
		this.userComment = userComment;
		this.rDate = rDate;
	}
	
	public ReplyVO(int cNum, String userID, String userPW, String userComment) {
		super();
		this.cNum = cNum;
		this.userID = userID;
		this.userPW = userPW;
		this.userComment = userComment;
	}

	public int getcNum() {
		return cNum;
	}

	public void setcNum(int cNum) {
		this.cNum = cNum;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public Timestamp getrDate() {
		return rDate;
	}

	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}

	@Override
	public String toString() {
		return "ReplyVO [cNum=" + cNum + ", rNum=" + rNum + ", userID=" + userID + ", userPW=" + userPW
				+ ", userComment=" + userComment + ", rDate=" + rDate + "]";
	}

}
