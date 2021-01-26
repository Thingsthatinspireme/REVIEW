package com.nl.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//CONTROLLER

@WebServlet("/hello")
public class Hello extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
		String num_ = request.getParameter("n"); 
		if(num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);

		String result;

		if(num % 2 != 0)
			result = "홀수";
		else
			result = "짝수";
		
		
		request.setAttribute("result", result); //request에 result를 담아주기
		
		String[] names = {"Java", "Servlet"};
		request.setAttribute("names", names);
		
		Map<String, Object> notice = new HashMap<String, Object> ();
		notice.put("id", 1);
		notice.put("title", "EL표기법");
		request.setAttribute("notice", notice);
		
		//jsp와 자바 코드를 연결 해줄 수 있는 저장소가 필요하다.
		//redirect : 현재 작업과 상관없이 새로운 요청
		//forward : 현재 작업한것을 이어 갈 수 있도록 공유
		RequestDispatcher dispatcher = request.getRequestDispatcher("hello.jsp");
		//request에 result가 담겨서 hello.jsp로 넘어가게 된다.
		dispatcher.forward(request, response);
	}
}
