package com.compo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchResult")
public class SearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = request.getParameter("search");
		System.out.println("���޹��� ��>> "+data);
		//����ڿ��� �����͸� ����
		response.setContentType("text/html; charset=utf-8");
		
		//����ڿ��� �����͸� �����ϱ� ���� ��ü����
		PrintWriter out = response.getWriter();
		
		//������ ����--> �������� ���
		out.print("<h1>��û�� ���� ó�� �Ϸ�!</h1>");
		out.print("���޹��� ��>> "+data);
		//html ��� ������ ���ΰ�
	}

}
