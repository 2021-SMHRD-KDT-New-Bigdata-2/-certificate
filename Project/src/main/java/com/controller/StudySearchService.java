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

// ���͵����������� ���͵� �˻��� �� �ְ� �� �� servlet �ڵ�
@WebServlet("/StudySearchService")
public class StudySearchService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		ArrayList<StudyVO> list = null;
		String words = request.getParameter("search_words");
		System.out.println("���" + words);
		StudyDAO dao = new StudyDAO();
		// �˻�â�� �ƹ��͵� �Է��� ���ϸ� ��ü���, �Է½� �˻�����
		if (words.equals("")) {
			// ��ü���
			list = dao.Study_SeclectAll();
		} else {
			// DAO�� Lecture_Search ���� �� �ش��ϴ� ���̺� ������ ��������
			list = dao.Study_Search(words);
		}
		
		if (list != null) {
			// ���� ��ü ����
			HttpSession session = request.getSession();
			
			// �������� �����͸� ���ǿ� ����
			session.setAttribute("Study", list);
			
			// ���������������� �̵�
			response.sendRedirect("study.jsp");
		}
	}

}
