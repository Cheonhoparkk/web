package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.service.UserInfoService;
import com.web.service.impl.UserInfoServiceImpl;

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService uiService = new UserInfoServiceImpl();
	public UserInfoServlet() {
		System.out.println("이야~ 내 메모리 만들었구나~~");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		String cmd = uri.substring(11);
		if("update".equals(cmd)) {
			Map<String,String> user = (Map<String,String>) request.getSession().getAttribute("user");
			String id = user.get("UI_ID");
			user = uiService.getUser(id);
			request.setAttribute("userInfo", user);
			RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
			rd.forward(request, response);
		}else if("logout".equals(cmd)) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/");
		}else if("delete".equals(cmd)) {
			Map<String,String> user = (Map<String,String>) request.getSession().getAttribute("user");
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		String cmd = uri.substring(11);
		request.setCharacterEncoding("UTF-8");
		if("sign-in".equals(cmd)) {
			String uiId = request.getParameter("uiId");
			String uiPwd = request.getParameter("uiPwd");
			boolean result = uiService.login(uiId, uiPwd, request.getSession());
			if(result) {
				response.sendRedirect("/");
			}else {
				response.sendRedirect("/sign-in.jsp");
			}
		}else if("sign-up".equals(cmd)) {
			Map<String,String> user = new HashMap<>();
			user.put("uiId", request.getParameter("uiId"));
			user.put("uiPwd", request.getParameter("uiPwd"));
			user.put("uiName", request.getParameter("uiName"));
			user.put("uiEmail", request.getParameter("uiEmail"));
			user.put("uiAddr", request.getParameter("uiAddr"));
			boolean result = uiService.signUp(user);

			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("니 회원가입 결과 : " + result);
		}else if("update".equals(cmd)) {
			Map<String,String> user = new HashMap<>();
			user.put("uiId", request.getParameter("uiId"));
			user.put("uiNum", request.getParameter("uiNum"));
			user.put("uiPwd", request.getParameter("uiPwd"));
			user.put("uiName", request.getParameter("uiName"));
			user.put("uiEmail", request.getParameter("uiEmail"));
			user.put("uiAddr", request.getParameter("uiAddr"));
			boolean result = uiService.update(user, request.getSession());
			if(result) {
				response.sendRedirect("/");
			}
		}
	}
		

}