package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ���͵� ���� ��ư�� ������ �ش� ���͵������� ���̺��� �������ִ� �ڵ�
@WebServlet("/Study_EndService")
public class Study_EndService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// �ۼ� ����...(���� ���͵������� ���� ȸ���� �ش� ���͵� �������� �湮������ ���ǿ� ���͵� ������ �����ϴ� ����� �����ʿ䰡 ����)
	}

}
