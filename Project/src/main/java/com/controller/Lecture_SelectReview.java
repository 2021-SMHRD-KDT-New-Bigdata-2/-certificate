package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.LectureDAO;

// ������������������ Ư�� ������ ���亸�� ��ư�� ������ ���並 �����ִ� ��� 
@WebServlet("/Lecture_SelectReview")
public class Lecture_SelectReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// ���� ��ȣ ��������
		String num = request.getParameter("lecture_no");
		int lecture_no = Integer.parseInt(num);
		
		LectureDAO dao = new LectureDAO();
		
		// Lecture_SelectReview�� �����ؼ� ���� ���� �迭�� ������
		String[] reviewlist = dao.Lecture_SelectReview(lecture_no);
		
		if (reviewlist != null) {
			// ���� ��ü ����
			HttpSession session = request.getSession();
			
			// ���� �����͸� ���ǿ� ����
			session.setAttribute("LectureReview", reviewlist);
			
			// ���亸�� �������� �̵�
			response.sendRedirect("���亸��������.jsp");
		} else {
			// ���䰡 ���� ��� ���� �������� �̵�
			response.sendRedirect("���䰡 �����ϴ�������.jsp");
		}
		
	}

}
