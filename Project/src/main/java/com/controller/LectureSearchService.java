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

// ������������������ �˻���ư Ŭ���� ���������� �˻����� servlet �ڵ�
@WebServlet("/LectureSearchService")
public class LectureSearchService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		// ���� ��ü ����
		HttpSession session = request.getSession();
		
		ArrayList<LectureVO> list = null;
		String words = request.getParameter("search_words");
		String pages =  request.getParameter("pages");
		session.setAttribute("words", words);
		System.out.println("���: " + words);
		LectureDAO dao = new LectureDAO();
		
		// �������� ���������� ��ȣ(������ ��ȣ�� 1������ ���� +10 �ʿ�)

		if(pages==null) {
			pages="1";
		}
		int i = Integer.parseInt(pages);

		
		// �˻�â�� �ƹ��͵� �Է��� ���ϸ� ��ü���, �Է½� �˻�����
		if (words.equals("")) {
			// ��ü���
			list = dao.Lecture_ViewAll(i);
		} else {
			// DAO�� Lecture_Search ���� �� �ش��ϴ� ���̺� ������ ��������
			list = dao.Lecture_Search(words, i);
//			list = dao.Lecture_Search(words);
		}
		
		if (list != null) {

			
			// �������� �����͸� ���ǿ� ����
			session.setAttribute("Lecture", list);
			
			// ���������������� �̵�
			response.sendRedirect("lecture.jsp");
		}
	}

}
