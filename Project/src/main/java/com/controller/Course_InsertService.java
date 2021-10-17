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

// �������� ���������� ���Ǹ� ���ù�ư�� ������ ����
@WebServlet("/Course_InsertService")
public class Course_InsertService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		int member_no = Integer.parseInt(request.getParameter("member_no"));	// ȸ����ȣ
		int lecture_no = Integer.parseInt(request.getParameter("lecture_no"));	// ���ǹ�ȣ
		
		// ������ ���ǰ� �̹� ���õȰ��� �ƴ��� Ȯ��
		// CourseDAO�� Course_Select�� �����ؼ� ���� ���õǸ� �̹� ���ǰ� �̹� ���õȰɷ� �Ǵ�
		CourseDAO dao = new CourseDAO();
		CourseVO vo = dao.Course_Select(member_no, lecture_no);
		if(vo == null) {
			// CourseDAO�� Course_insert ����
			int cnt = dao.Course_Insert(member_no, lecture_no);
			vo = dao.Course_Select(member_no, lecture_no);
			
			if (cnt>0) {	
//			// ���� ��ü ����
			HttpSession session = request.getSession();
			
			// ������ ���� ������ ���ǿ� ����
			session.setAttribute("Course_Selected", vo);
			
			// ���Ǽ��� ���� �������� �̵�
			response.sendRedirect("lectureJoinSuccess.jsp");
			}
		} else {
			System.out.println("�� ���Ǵ� �̹� ���õǾ����ϴ�.");
			
			// ���Ǽ��� ���� �������� �̵�
			response.sendRedirect("lectureJoinFailure.jsp");
		}
	}

}
