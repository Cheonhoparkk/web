package com.web.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface UserInfoService {
	boolean login(String id, String pwd, HttpSession session);
	boolean signUp(Map<String,String> user);
	Map<String,String> getUser(String id);
	boolean update(Map<String,String> user, HttpSession session);
}