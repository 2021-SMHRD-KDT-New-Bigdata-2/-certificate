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

@WebServlet("/LectureSearchService")
public class LectureSearchService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		ArrayList<LectureVO> list = null;
		String words = request.getParameter("search_words");
		
		LectureDAO dao = new LectureDAO();
		// �˻�â�� �ƹ��͵� �Է��� ���ϸ� ��ü���, �Է½� �˻�����
		if (words.equals(null)) {
			// ��ü���
			list = dao.Lecture_ViewAll();
		} else {
			// DAO�� Lecture_Search ���� �� �ش��ϴ� ���̺� ������ ��������
			list = dao.Lecture_Search(words);
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
