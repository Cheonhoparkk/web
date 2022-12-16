package com.web.service.impl;

import java.util.List;
import java.util.Map;

import com.web.dao.StudentPointDAO;
import com.web.dao.impl.StudentPointDAOImpl;
import com.web.service.StudentPointService;

public class StudentPointServiceImpl implements StudentPointService {
	private StudentPointDAO studentPointDAO = new StudentPointDAOImpl();
	@Override
	public Map<String, String> selectStudentPoint(String spNum) {
		return studentPointDAO.selectStudentPoint(spNum);
	}

	@Override
	public int insertStudentPoint(Map<String, String> studentPoint) {
		return studentPointDAO.insertStudentPoint(studentPoint);
	}

	@Override
	public int updateStudentPoint(Map<String, String> studentPoint) {
		return studentPointDAO.updateStudentPoint(studentPoint);
	}

	@Override
	public int deleteStudentPoint(String spNum) {
		return studentPointDAO.deleteStudentPoint(spNum);
	}

	@Override
	public List<Map<String, String>> selectStudentPointList() {
		// TODO Auto-generated method stub
		return studentPointDAO.selectStudentPointList();
	}

}