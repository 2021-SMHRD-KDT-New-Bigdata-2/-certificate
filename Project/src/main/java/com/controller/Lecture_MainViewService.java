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

// ���������� �湮�� �������������� ���������� ������ servlet �ڵ�
@WebServlet("/Lecture_MainViewService")
public class Lecture_MainViewService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		ArrayList<LectureVO> list_main = null; 
		
		// DAO�� Lecture_MainView�� �����ؼ� ���������� ���ĵ� �������� ���̺� ������ ��������
		LectureDAO dao = new LectureDAO();
		ArrayList<LectureVO> list = dao.Lecture_MainView();
		
		// ���� ���� 4���� list_main�� ����
		for(int i=0; i<4; i++) {
			list_main.add(list.get(i));
		}
		
		if (list != null) {
			// ���� ��ü ����
			HttpSession session = request.getSession();
			
			// ���ο� ��� �������� �����͸� ���ǿ� ����
			session.setAttribute("LectureMain", list_main);
			
			// ������������ �̵�
			response.sendRedirect("main.jsp");
		}
	}

}
