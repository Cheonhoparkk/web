package com.web.service;

import java.util.List;
import java.util.Map;

public interface StudentPointService {
	Map<String,String> selectStudentPoint(String spNum);
	int insertStudentPoint(Map<String,String> studentPoint);
	int updateStudentPoint(Map<String,String> studentPoint);
	int deleteStudentPoint(String spNum);
	List<Map<String,String>> selectStudentPointList();
}