package com.nl.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/calc")
public class Calc extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ServletContext application = req.getServletContext(); // 어플리케이션 저장소
//		HttpSession session = req.getSession();

		// 쿠키 읽기
		Cookie[] cookies = req.getCookies();

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String v_ = req.getParameter("v");
		String op = req.getParameter("operator");
		int v = 0;

		if (!v_.equals(""))
			v = Integer.parseInt(v_);
		// 계산
		if (op.equals("=")) {

//			int x = (Integer)application.getAttribute("value");
//			int x = (Integer)session.getAttribute("value");
			// 쿠키꺼내기
			int x = 0;

			for (Cookie c : cookies) {
				if (c.getName().equals("value")) { // 여러개의 쿠키가 있을 수 있기 떄문에 서버가 보낸 value값과 같은게 있는지 찾아보는 것
					x = Integer.parseInt(c.getValue()); // 동일한 value가 있다면 값을 x에 저장
				break;// 값을 찾았다면 반복문 탈출
				}
			}

			int y = v;
//			String operator = (String)application.getAttribute("op");
//			String operator = (String)session.getAttribute("op");
			
			String operator = "";
			for (Cookie c : cookies) {
				if (c.getName().equals("op")) { // 서버가 보낸 op값과 같은게 있는지 찾아보는 것
					operator = c.getValue(); // 동일한 op가 있다면 값을 x에 저장
		
				break;// 값을 찾았다면 반복문 탈출
				}
			}
			
			System.out.println(operator);
			int result = 0;
			
			if (operator.equals("+")) {
				result = x + y;
			}else {
				
				result = x - y;
			}

			resp.getWriter().printf("Result :  %d\n", result);
		} else {
//			값을 저장 해준다 
//			application.setAttribute("value", v); //key랑 value를 넣게된다 map컬렉션과 비슷
//			application.setAttribute("op", op);

//			session.setAttribute(, v); //key랑 value를 넣게된다 map컬렉션과 비슷
//			session.setAttribute("op", op);

			Cookie valueCookie = new Cookie("value", String.valueOf(v)); // 쿠키는 url로 전달가능한 문자열만 가능하기 때문에 v를 문자열로바꿔줌
			Cookie opCookie = new Cookie("op", op);
			valueCookie.setPath("/calc"); //쿠키의 경로 /로 설정하게 되면 어떤 서비스를 요청하던 전달된다 /add로 지정하면 /add경로에만전달됨
			valueCookie.setMaxAge(24*60*60); //앞으로 24(시간)*60(초) *60(분)=24시간 후에 만료된다 
			opCookie.setPath("/"); //MaxAge안정해주면 그냥 브라우저 끄면 쿠키 수명도 끝 
			// 사용자에게 cookie를 보낸다
			resp.addCookie(valueCookie);
			resp.addCookie(opCookie);
			
			resp.sendRedirect("calc.html");
		}

	}
}
