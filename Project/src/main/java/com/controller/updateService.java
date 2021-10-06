package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.memberDAO;
import com.model.memberVO;

@WebServlet("/updateService")
public class updateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������ �ҷ��ͼ� ���ǿ� �α��� �� ȸ���� ������ �����Ѵ�.
		HttpSession session =  request.getSession();
		memberVO vo = (memberVO)session.getAttribute("member");
		
		String email = vo.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		memberDAO dao = new memberDAO();
		int cnt = dao.update(pw, tel, address, email);
		
		if(cnt>0) {
			System.out.println("ȸ���������� ����!");
			memberVO vo1 = new memberVO(email, tel, address);
			session.setAttribute("member", vo1);
			response.sendRedirect("main.jsp");

		}
	}

}
