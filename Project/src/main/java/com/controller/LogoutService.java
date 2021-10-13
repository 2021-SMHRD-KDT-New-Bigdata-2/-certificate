package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//�α׾ƿ� ��ư�� ������ �α׾ƿ��ϰ� ������������ ���ư��� servlet �ڵ�
@WebServlet("/LogoutService")
public class LogoutService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���� ��ü ����
		HttpSession session = request.getSession();
		
		// �α��λ������ ������ �����ϴ� ���� ����
		session.removeAttribute("Member");
		
		// ���������� �̵�
		response.sendRedirect("main.jsp");
	}

}
