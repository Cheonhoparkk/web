package com.web.dao;

import java.util.List;
import java.util.Map;

public interface StudentPointDAO {
	List<Map<String,String>> selectStudentPointList();
	Map<String,String> selectStudentPoint(String spNum);
	int insertStudentPoint(Map<String,String> studentPoint);
	int updateStudentPoint(Map<String,String> studentPoint);
	int deleteStudentPoint(String spNum);
}
