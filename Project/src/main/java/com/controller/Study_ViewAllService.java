package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.LectureDAO;
import com.model.LectureVO;
import com.model.StudyDAO;
import com.model.StudyVO;


@WebServlet("/Study_ViewAllService")
public class Study_ViewAllService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// DAO�� Lecture_viewAll �����ؼ� ��ü ���̺� ������ ��������
		StudyDAO dao = new StudyDAO();
		ArrayList<StudyVO> list = dao.Study_SeclectAll();
		
		if (list != null) {
			// ���� ��ü ����
			HttpSession session = request.getSession();
			
			// �������� ��ü �����͸� ���ǿ� ����
			session.setAttribute("Study", list);
			
			// ���������������� �̵�
			response.sendRedirect("Study.jsp");
		}	
	}

}
