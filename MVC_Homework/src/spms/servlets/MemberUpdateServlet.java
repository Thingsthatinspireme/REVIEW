package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spms.vo.Member;

@SuppressWarnings("serial")
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		final String sqlSelect = "SELECT mno,email,mname,cre_date" + "\r\n" +
								"FROM members WHERE mno=" + "\r\n" +
								req.getParameter("no");
		
		ServletContext sc = this.getServletContext();
		conn = (Connection)sc.getAttribute("conn");
		
		try {
	
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlSelect);
			rs.next();	// 처음에는 1행 이전을 가리키니까
			
			resp.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = resp.getWriter();
//			out.println("<html><head><title>회원 정보</title></head>");
//			out.println("<body><h1>회원 정보</h1>");
//			out.println("<form action='update' method='post'>");
//			out.println("번호: <input type='text' name='no' value='" +
//					req.getParameter("no") + "'readonly><br>");
//			out.println("이름: <input type='text' name='name'" +
//					" value='" + rs.getString("mname") + "'><br>");
//			out.println("이메일: <input type='text' name='email'" +
//					" value='" + rs.getString("email") + "'><br>");
//			out.println("가입일: " + rs.getDate("cre_date") + "<br>");
//			out.println("<input type='submit' value='저장'>");
//			out.println("<input type='button' value='삭제' "
//					+ "onclick='location.href=\"delete?no=" + 
//					req.getParameter("no") + "\";'>");			
//			out.println("<input type='button' value='취소'" +
//					" onclick='location.href=\"list\"'>");
//			out.println("</form>");
//			out.println("</body></html>");
			Member member = new Member().setNo(rs.getInt("mno"))
										.setName(rs.getString("mname"))
										.setEmail(rs.getString("email"))
										.setCreatedDate(rs.getDate("cre_date"));
										
			HttpSession session = req.getSession();
			session.setAttribute("member", member);
			RequestDispatcher rd = req.getRequestDispatcher("/member/MemberUpdateForm.jsp");
			rd.include(req, resp);
			
		}catch(Exception e) {
//			throw new ServletException(e);
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, resp);
		}finally {
			try {
				if(rs!=null) 
					rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(stmt!=null) 
					stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
//			try {
//				if(conn!=null) 
//					conn.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 필터에 선행처리를 했으므로 주석처리
		//req.setCharacterEncoding("UTF-8");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		final String sqlUpdate = "UPDATE members SET email=?," + "\r\n" +
								"mname=?,mod_date=now() WHERE mno=?";
		
		ServletContext sc = this.getServletContext();
		String driver = sc.getInitParameter("driver");
		String url = sc.getInitParameter("url");
		String id = sc.getInitParameter("username");
		String pwd = sc.getInitParameter("password");
		
		try {
			// 1) MySQL 제어 객체를 로딩
			Class.forName(driver);
			// 2) MySQL과 연결
			conn = DriverManager.getConnection(url, id, pwd);
			stmt = conn.prepareStatement(sqlUpdate);
			stmt.setString(1, req.getParameter("email"));
			stmt.setString(2, req.getParameter("name"));
			stmt.setInt(3, Integer.parseInt(req.getParameter("no")));
			stmt.executeUpdate();
			
			resp.sendRedirect("list");
			
		}catch(Exception e) {
//			throw new ServletException(e);
			
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, resp);
		}finally {
			try {
				if(stmt!=null) 
					stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
//			try {
//				if(conn!=null) 
//					conn.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}				
		}
	}
}














