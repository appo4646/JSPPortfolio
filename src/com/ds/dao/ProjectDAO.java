package com.ds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ds.vo.ContentVO;
import com.ds.vo.PagingDTO;
import com.ds.vo.ReplyVO;
import com.ds.vo.SearchDTO;

public class ProjectDAO {
	private static ProjectDAO instance;
	private final String LOOK_UP_NAME = "java:comp/env/jdbc/OracleDB";
	
	public ProjectDAO() {}
	
	public static ProjectDAO getInstance(){
		if(instance == null){
			instance = new ProjectDAO();
		} 
		return instance;
	}
	
	private Connection getConnection(){
		Connection con = null;
		
		try{
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(LOOK_UP_NAME);
			con = ds.getConnection();
			return con;
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	private void close(Connection con, PreparedStatement pstmt, ResultSet rs){
		if (con != null) try{ con.close();} catch (Exception e){ } 
		if (pstmt != null) try{ pstmt.close();} catch (Exception e){ } 
		if (rs != null) try{ rs.close();} catch (Exception e){ } 
	}
	
	public boolean loginMyID (String id, String pw){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			String sql = "select * from mine";
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			String db_id = rs.getString("id");
			String db_pw = rs.getString("pw");
			System.out.println("db_id = " + db_id);
			System.out.println("db_pw = " + db_pw);
			if (id.equals(db_id)){
				if (pw.equals(db_pw)){
					return true;
				}
			}
		
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			close(con, pstmt, rs);
		}
		return false;
	}
	public ArrayList<ContentVO> selectAll(PagingDTO pDTO, SearchDTO sDTO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			String sql2 = "";
			System.out.println("ProjectDAO, selectAll, pDTO = " + pDTO);
			System.out.println("ProjectDAO, selectAll, sDTO = " + sDTO);
			
			if (sDTO != null){
				String searchType = sDTO.getSearchType();
				String searchValue = sDTO.getSearchValue();
				if (!searchType.equals("")){
					sql2 = " where ctype = '" + searchType + "'";
					if (!searchValue.equals("")){
						sql2 = " where ctype = '" + searchType + "' and csubject like '%" + searchValue + "%' ";
					}
				}
			}
			System.out.println("ProjectDAO, selectAll, sql2 =" + sql2 );
			
			String sql = " select * from (select rownum rnum, a.* from "
					+ " (select * from board "
					+ sql2
					+	"	order by cnum desc) a) "
					+ " where rnum >= ? and rnum <=? ";
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pDTO.getStartRow());
			pstmt.setInt(2, pDTO.getEndRow());
			rs = pstmt.executeQuery();
			System.out.println("ProjectDAO, selectAll, sql = " + sql);
			ArrayList<ContentVO> list = new ArrayList<>();
			
			while (rs.next()){
				int cnum = rs.getInt("cnum");
				String cType = rs.getString("ctype");
				String cSubject = rs.getString("csubject");
				String cContent = rs.getString("ccontent");
				String cFile = rs.getString("cfile");
				System.out.println("cFile:" + cFile);
				if (cFile != null) {
					boolean isContain = cFile.contains(",");
					if (isContain == true) {
						StringTokenizer tokenizer = new StringTokenizer(cFile, ",");
						String cFile1st = tokenizer.nextToken();
						cFile = cFile1st;
						System.out.println("cFile:" + cFile);
					}
				}
				
				int cReadCount = rs.getInt("creadcount");
				Timestamp cDate = rs.getTimestamp("cdate");
				ContentVO vo = new ContentVO(cnum, cType, cSubject, cContent, cFile, cReadCount, cDate);
				list.add(vo);
			}
			System.out.println("ProjectDAO, selectAll, sql = " + sql);
			return list;
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return null;
	}
	
	public int allContentCount (SearchDTO sDTO){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			String sql2 = "";
			if (sDTO != null){
				String searchType = sDTO.getSearchType();
				String searchValue = sDTO.getSearchValue();
				if (!searchType.equals("")){
					sql2 = " where ctype = '" + searchType + "'";
					if (!searchValue.equals("")){
						sql2 = " where ctype = '" + searchType + "' and csubject like '%" + searchValue + "%' ";
					}
				}
			}
			String sql = "select count(*) cnt from board ";
			sql = sql + sql2;
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int count = rs.getInt("cnt");
			System.out.println("allContentCount = " + count);
			return count;
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return 0;
	}
	
	public boolean writeContent (ContentVO vo){
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			String sql = "insert into board (cnum,ctype,csubject,ccontent,cfile,creadcount,cdate) "
						+ "values(project_seq.nextval,?,?,?,?,0,sysdate)";
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			int i = 0;
			pstmt.setString(++i, vo.getcType());
			pstmt.setString(++i, vo.getcSubject());
			pstmt.setString(++i, vo.getcContent());
			pstmt.setString(++i, vo.getcFile());
			int result = pstmt.executeUpdate();
			if (result > 0){
				return true;
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			close(con, pstmt, null);
		}
				
		
		return false;
	}
	
	public ContentVO selectByNum (int cNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			String sql = "select * from board where cnum = ?";
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cNum);
			rs = pstmt.executeQuery();
			rs.next();
			
			String cType = rs.getString("ctype"); 
			String cSubject = rs.getString("cSubject"); 
			String cContent = rs.getString("cContent"); 
			String cFile = rs.getString("cfile"); 
			int cReadCount = rs.getInt("creadcount");
			Timestamp cDate = rs.getTimestamp("cdate");
			ContentVO vo = new ContentVO(cNum, cType, cSubject, cContent, cFile, cReadCount, cDate);
			
			return vo;
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return null;
	}
	
	public boolean insertReply(ReplyVO vo){
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			String sql = "insert into reply (cnum,rnum,userid,userpw,usercomment,rdate)"
					+ " values (?,reply_seq.nextval,?,?,?,sysdate)";
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			int i = 0;
			pstmt.setInt(++i, vo.getcNum());
			pstmt.setString(++i, vo.getUserID());
			pstmt.setString(++i, vo.getUserPW());
			pstmt.setString(++i, vo.getUserComment());
			int result = pstmt.executeUpdate();
			System.out.println("DAO, insertReply, sql = " + sql);
			
			if (result > 0){
				return true;
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			close(con, pstmt, null);
		}
		return false;
	}
	
	public ArrayList<ReplyVO> replyByNum(int cnum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			String sql = "select  * from reply where cnum = ?";
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cnum);
			rs = pstmt.executeQuery();
			System.out.println("replyByNum, sql = " + sql);
			ArrayList<ReplyVO> list = new ArrayList<>();
			
			while(rs.next()){
				int rnum = rs.getInt("rnum");
				String userID = rs.getString("userid");
				String userPW = rs.getString("userpw");
				String userComment = rs.getString("usercomment");
				Timestamp rDate = rs.getTimestamp("rdate");
				ReplyVO vo = new ReplyVO(cnum, rnum, userID, userPW, userComment, rDate);
				System.out.println("replyByNum, vo = " + vo);
				list.add(vo);
			}
			
			return list;
		} catch (Exception e){
			e.printStackTrace();
 		} finally {
 			close(con, pstmt, rs);
 		}
		return null;
	}
	
	public boolean deleteReply (int rnum, String userPW){
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			String sql = "delete from reply where rnum = ? and userpw = ?";
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rnum);
			pstmt.setString(2, userPW);
			int result = pstmt.executeUpdate();
			if (result > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, null);
		}
			
		return false;
	}
}
