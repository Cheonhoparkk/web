package com.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.web.DBCon;
import com.web.dao.StudentPointDAO;

public class StudentPointDAOImpl implements StudentPointDAO {

	@Override
	public Map<String, String> selectStudentPoint(String spNum) {
		try(Connection con = DBCon.getConnection()){
			String sql = "SELECT * FROM STUDENT_POINT WHERE SP_NUM=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, spNum);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCnt = rsmd.getColumnCount();
				Map<String,String> studentPoint = new HashMap<>();
				for(int i=1;i<=columnCnt;i++) {
					String columnName = rsmd.getColumnLabel(i);
					studentPoint.put(columnName, rs.getString(columnName));
				}
				return studentPoint;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertStudentPoint(Map<String, String> studentPoint) {
		try(Connection con = DBCon.getConnection()){
			String sql = "INSERT INTO STUDENT_POINT\r\n"
					+ "(SP_NAME, SP_KOR_POINT, SP_ENG_POINT, SP_MATH_POINT, SP_PROFILE)\r\n"
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, studentPoint.get("spName"));
			pstmt.setString(2, studentPoint.get("spKorPoint"));
			pstmt.setString(3, studentPoint.get("spEngPoint"));
			pstmt.setString(4, studentPoint.get("spMathPoint"));
			pstmt.setString(5, studentPoint.get("spProfile"));
			return pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateStudentPoint(Map<String, String> studentPoint) {
		try(Connection con = DBCon.getConnection()){
			String sql = "UPDATE STUDENT_POINT\r\n"
					+ "SET SP_NAME=?,\r\n"
					+ "SP_KOR_POINT=?,\r\n"
					+ "SP_ENG_POINT=?,\r\n"
					+ "SP_MATH_POINT=?,\r\n"
					+ "SP_PROFILE=?\r\n"
					+ " WHERE SP_NUM=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, studentPoint.get("spName"));
			pstmt.setString(2, studentPoint.get("spKorPoint"));
			pstmt.setString(3, studentPoint.get("spEngPoint"));
			pstmt.setString(4, studentPoint.get("spMathPoint"));
			pstmt.setString(5, studentPoint.get("spProfile"));
			pstmt.setString(6, studentPoint.get("spNum"));
			return pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStudentPoint(String spNum) {
		try(Connection con = DBCon.getConnection()){
			String sql = "DELETE FROM STUDENT_POINT WHERE SP_NUM=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, spNum);
			return pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {
		StudentPointDAO spDAO = new StudentPointDAOImpl();
		System.out.println(spDAO.selectStudentPointList());
	}

	@Override
	public List<Map<String, String>> selectStudentPointList() {
		try(Connection con = DBCon.getConnection()){
			String sql = "SELECT * FROM STUDENT_POINT";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCnt = rsmd.getColumnCount();
			List<Map<String,String>> studentPointList = new ArrayList<>();
			while(rs.next()) {
				Map<String,String> studentPoint = new HashMap<>();
				for(int i=1;i<=columnCnt;i++) {
					String columnName = rsmd.getColumnLabel(i);
					studentPoint.put(columnName, rs.getString(columnName));
				}
				studentPointList.add(studentPoint);
			}
			return studentPointList;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void test() {
		for(;;) {
			
		}
	}
}