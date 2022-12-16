package com.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.service.StudentPointService;
import com.web.service.impl.StudentPointServiceImpl;
import com.web.util.ParameterUtil;

/**
 * Servlet implementation class StudentPointServlet
 */
@WebServlet(value = "/student-point/*", loadOnStartup = 1)
public class StudentPointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentPointService studentPointService = new StudentPointServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(15);
		if ("list".equals(cmd)) {
			List<Map<String, String>> spList = studentPointService.selectStudentPointList();
			request.setAttribute("list", spList);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/student-point/list.jsp");
			rd.forward(request, response);
			
		}else if("view".equals(cmd) || "update".equals(cmd)) {
			String spNum = request.getParameter("spNum");
			Map<String, String> studentPoint = studentPointService.selectStudentPoint(spNum);
			request.setAttribute("sp", studentPoint);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/student-point/" + cmd +".jsp");
			rd.forward(request, response);
		}
		
//		Map<String, String> sp = new HashMap<>();
//		sp.put("SP_NUM", "1");
//		sp.put("SP_NAME", "박진영");
//		sp.put("SP_KOR_POINT", "100");
//		sp.put("SP_ENG_POINT", "100");
//		sp.put("SP_MATH_POINT", "100");
//		sp.put("SP_PROFILE", "박진영 천재");
//		List<Map<String, String>> spList = new ArrayList<>();
//		spList.add(sp);
//		request.setAttribute("list", spList);
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/student-point/list.jsp");
//		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String cmd = uri.substring(15);
		Map<String, String> param = ParameterUtil.convertMap(request);
		if ("insert".equals(cmd)) {
			int result = studentPointService.insertStudentPoint(param);
			request.setAttribute("msg", "등록이 실패!");
			request.setAttribute("url", "/student-point/list");
			if(result==1){
				request.setAttribute("msg", "등록이 성공!");
				request.setAttribute("url", "/student-point/list");
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/alert.jsp");
			rd.forward(request, response);
			
		}
	}
}
