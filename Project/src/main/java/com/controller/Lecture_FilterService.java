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

@WebServlet("/Lecture_FilterService")
public class Lecture_FilterService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		ArrayList<LectureVO> list = null;
		ArrayList<String> filter = new ArrayList<String>();
		
		
		
		// ������ ���͸� �������� �κ�(jsp���Ͽ� ���缭 �����ʿ��� �κ�, for�� ������?)
		String ���Ϳ��1 = request.getParameter("���� �±��� name");
		// ������ ���͸� ���ڿ��� �߰�
		filter.add(���Ϳ��1);
		
		
		LectureDAO dao = new LectureDAO();
		// ���͸� �ƹ��͵� ������ ���ϸ� ��ü���, ���ý� �˻�����
		if (filter.size()==0) {
			// ��ü���
			list = dao.Lecture_ViewAll();
		} else {
			// DAO�� Lecture_Search ���� �� �ش��ϴ� ���̺� ������ ��������
			list = dao.Lecture_filter(filter);
		}
		
		if (list != null) {
			// ���� ��ü ����
			HttpSession session = request.getSession();
			
			// �������� �����͸� ���ǿ� ����
			session.setAttribute("Lecture", list);
			
			// ���������������� �̵�
			response.sendRedirect("lecture.jsp");
		}
	}

}
