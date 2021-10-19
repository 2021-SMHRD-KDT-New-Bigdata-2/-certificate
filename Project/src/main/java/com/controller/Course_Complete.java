package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CourseDAO;
import com.model.CourseVO;

// ���Ῡ�� ���� ��ư�� ������ ����
@WebServlet("/Course_Complete")
public class Course_Complete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		int course_no = Integer.parseInt(request.getParameter("course_no"));	// ������ȣ
		
		// CourseDAO�� Course_Complete�� �����ؼ� ���Ῡ�� ����
		CourseDAO dao = new CourseDAO();
		int cnt = dao.Course_Complete(course_no);
		
		if (cnt>0) {
			// ������ ������ ���� vo��ü ����
			CourseVO new_vo = dao.Course_SelectByCourse(course_no);
			
			// ���� ����
			HttpSession session = request.getSession();
			session.setAttribute("Course_Selected", new_vo);
			
			// ������������ �̵�
			response.sendRedirect("lecture.jsp");
		}
	}

}
