package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.StudyDAO;

@WebServlet("/Study_CreationService")
public class Study_CreationService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// ���͵����� ���� form�� �ۼ��� �� �޾ƿ���
		String study_name = request.getParameter("name");	// ���͵��
		String study_begin = request.getParameter("begin");	// ��������
		String study_end = request.getParameter("end");	// ��������
		String study_sub = request.getParameter("sub");	// ���͵����
		String study_place = request.getParameter("place");	// ���
		String study_week = request.getParameter("week");	// ����
		String study_time = request.getParameter("time");	// �ð�
		String study_onoff = request.getParameter("onoff");	// ��/�������� ����
		
		StudyDAO dao = new StudyDAO();
		int cnt = dao.Study_Creation(study_name, study_begin, study_end, study_sub, study_place, study_week, study_time, study_onoff);
		
		// ���͵� ���� ���� �� ������ Ȱ��
		if (cnt>0) {
			// ���� ��ü ����
			HttpSession session = request.getSession();
			
			// ������ ���͵� ���� �̸��� ���ǿ� ����
			session.setAttribute("StudyCreation", study_name);
			
			// ���͵� ���� ���� �����ϸ� ���͵� ���� �Խ������� �̵�(ȸ������ �������������� id�� �Բ� ȯ���޽��� ���� ������ ��밡��)
			response.sendRedirect("���͵������Խ���.jsp");
		}
		
	}

}
