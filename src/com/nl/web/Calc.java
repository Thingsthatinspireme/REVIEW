package com.nl.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/calc")
public class Calc extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext application = req.getServletContext(); //어플리케이션 저장소
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String v_ = req.getParameter("v");
		String op = req.getParameter("operator");
		
		int v = 0;
		
		if(!v_.equals("")) v = Integer.parseInt(v_);
		//계산
		if(op.equals("=")) {
			
			int x = (Integer)application.getAttribute("value");
			int y = v;		
			String operator = (String)application.getAttribute("op");;
			int result = 0;
			
			if(operator.equals("+"))
				result = x+y;
			else
				result = x-y;
			
			resp.getWriter().printf("Result :  %d\n",result);
		}else {
			//값을 저장 해준다 
			application.setAttribute("value", v); //key랑 value를 넣게된다 map컬렉션과 비슷
			application.setAttribute("op", op);
			
		}
		
		
		
	
	}
}
