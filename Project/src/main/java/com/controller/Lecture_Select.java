package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CourseDAO;
import com.model.MemberDAO;
import com.model.MemberVO;

// �������� ���̴µ����� ���Ǹ� �����ϸ� ����
@WebServlet("/Lecture_Select")
public class Lecture_Select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("Member"); 
		String member_id = vo.getMember_id(); //���� ���� �α����� ���̵�
		
		int Lecture_no = Integer.parseInt(request.getParameter("Lecture_no"));
		CourseDAO dao = new CourseDAO();
		int cnt = dao.course_insert(member_id, Lecture_no);
		if(cnt > 0) {
			response.sendRedirect("lectureJoinSuccess.jsp");
		}else {
			//����� ���� ���� �ʿ�
			response.sendRedirect("main.jsp");
		}
	}
}
