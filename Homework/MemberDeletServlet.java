package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/member/delete")
@SuppressWarnings("serial")
public class MemberDeletServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");// 한글이 안 깨짐
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String no = req.getParameter("no");
		System.out.println(no);
		String sqlDelete = "DELETE FROM members "
						+ "\r\n"+ "WHERE mno=?";
		
		
		ServletContext sc= this.getServletContext(); //web.xml의 정보를 받아오는 객체 
		String driver = sc.getInitParameter("driver");
		String url = sc.getInitParameter("url");
		String id = sc.getInitParameter("username");
		String pwd = sc.getInitParameter("password");
		try {
			Class.forName(driver);	// mysql객체를 로딩
			conn = DriverManager.getConnection(url, id, pwd);
			stmt = conn.prepareStatement(sqlDelete);
			stmt.setInt(1, Integer.parseInt(req.getParameter("no")));
			
			stmt.executeUpdate();
			System.out.println("연결");
			resp.sendRedirect("list");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null)
					stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				if(conn != null)
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");// 한글이 안 깨짐
//		
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		String no = req.getParameter("no");
//		System.out.println(no);
//		String sqlDelete = "DELETE FROM members "
//						+ "\r\n"+ "WHERE mno=?";
//		
//		
//		ServletContext sc= this.getServletContext(); //web.xml의 정보를 받아오는 객체 
//		String driver = sc.getInitParameter("driver");
//		String url = sc.getInitParameter("url");
//		String id = sc.getInitParameter("username");
//		String pwd = sc.getInitParameter("password");
//		try {
//			Class.forName(driver);	// mysql객체를 로딩
//			conn = DriverManager.getConnection(url, id, pwd);
//			stmt = conn.prepareStatement(sqlDelete);
//			stmt.setInt(1, Integer.parseInt(req.getParameter(no)));
//			
//			stmt.executeUpdate();
//			System.out.println("연결");
//			resp.sendRedirect("list");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(stmt != null)
//					stmt.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//			try {
//				if(conn != null)
//					conn.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
}
