package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;

@WebServlet("/PW_FindService")
public class PW_FindService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// ���̵�ã�� form�� �ۼ��� �� �޾ƿ���
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		System.out.println("���̵� : " + id);
		System.out.println("�̸� : " + name);
		
		MemberDAO dao = new MemberDAO();
		String pw = dao.PW_Find(id, name);
		
		if (id != null) {
			System.out.println("��������");
			// ���� ��ü ����
			HttpSession session = request.getSession();
			
			// ã�� ������� ���̵� ���ǿ� ����
			session.setAttribute("MemberPW", pw);
			
			// ������������ �̵�
			response.sendRedirect("main.jsp");
		}
	}

}
