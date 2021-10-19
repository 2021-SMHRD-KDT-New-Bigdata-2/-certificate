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

// �������������� �湮�� ��ü ���������� ������ servlet �ڵ�
@WebServlet("/Lecture_ViewAllService")
public class Lecture_ViewAllService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		// �������� ���������� ��ȣ(������ ��ȣ�� 1������ ���� +10 �ʿ�)
		int i = 1;
		
		// ������ ��ȣ ��������
//		String num = request.getParameter("page_no");
//		int page_no = Integer.parseInt(num);
//		int i = 1+(page_no-1)*10;
		
		// DAO�� Lecture_viewAll �����ؼ� ��ü ���̺� ������ ��������
		LectureDAO dao = new LectureDAO();
		ArrayList<LectureVO> list = dao.Lecture_ViewAll(i);
		
		if (list != null) {
			// ���� ��ü ����
			HttpSession session = request.getSession();
			
			// �������� ��ü �����͸� ���ǿ� ����
			session.setAttribute("Lecture", list);
			
			// ���������������� �̵�
			response.sendRedirect("lecture.jsp");
		}	
		
	}

}
