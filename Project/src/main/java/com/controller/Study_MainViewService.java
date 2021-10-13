package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.StudyDAO;
import com.model.StudyVO;

//���������� �湮�� �������������� ���͵������� ������ servlet �ڵ�
@WebServlet("/Study_MainViewService")
public class Study_MainViewService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// DAO�� Study_MainView�� �����ؼ� ���������� ���ĵ� �������� ���̺� ������ ��������
		StudyDAO dao = new StudyDAO();
		ArrayList<StudyVO> list = dao.Study_MainView();
		
		if (list != null) {
			// ���� ��ü ����
			HttpSession session = request.getSession();
			
			// ���ο� ��� �������� �����͸� ���ǿ� ����
			session.setAttribute("StudyMain", list);
			
			// ������������ �̵�
			response.sendRedirect("main.jsp");
		}
		
	}

}
