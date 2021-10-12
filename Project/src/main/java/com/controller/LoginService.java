package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberVO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		// �α��� form�� �ۼ��� �� �޾ƿ���
		String id = request.getParameter("member_id");
		String pw = request.getParameter("member_pw");
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.Login(id, pw);
		
		// ���ǻ���
		if (vo != null) {
			// ���� ��ü ����
			HttpSession session = request.getSession();
			
			// �α��λ������ ������ ���ǿ� ����
			session.setAttribute("Member", vo);
			
			// ������������ �̵�
			response.sendRedirect("main.jsp");
		}
	}

}
