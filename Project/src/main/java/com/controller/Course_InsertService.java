package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CourseDAO;
import com.model.CourseVO;
import com.model.MemberDAO;
import com.model.MemberVO;

// �������� ���������� ���Ǹ� ���ù�ư�� ������ ����
@WebServlet("/Course_Insert")
public class Course_InsertService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int lecture_no = 0;
		request.setCharacterEncoding("euc-kr");
		//���ǰ�ü����->���̵� �̿��� ȸ����ȣ�� �������� ����
		HttpSession session = request.getSession();
		MemberVO vo2 = (MemberVO)session.getAttribute("Member");
		int member_no = vo2.getMember_no();
		MemberDAO dao = new MemberDAO();
		
		lecture_no = Integer.parseInt(request.getParameter("lecture_no"));	// ���ǹ�ȣ
		
		
		// ������ ���ǰ� �̹� ���õȰ��� �ƴ��� Ȯ��
		// CourseDAO�� Course_Select�� �����ؼ� ���� ���õǸ� �̹� ���ǰ� �̹� ���õȰɷ� �Ǵ�
		CourseDAO dao2 = new CourseDAO();
		CourseVO vo = dao2.Course_Select(member_no, lecture_no);
		
		if(vo == null) {
			// CourseDAO�� Course_insert ����
			int cnt = dao2.Course_Insert(member_no, lecture_no);
			vo = dao2.Course_Select(member_no, lecture_no);
			
			if (cnt>0) {	
			// ���� ��ü ����
			HttpSession session1 = request.getSession();
			
			// ������ ���� ������ ���ǿ� ����
			session1.setAttribute("Course_Selected", vo);
			
			// ���Ǽ��� ���� �������� �̵�
			response.sendRedirect("lectureJoinSuccess.jsp");
			}
		} else {
			System.out.println("�� ���Ǵ� �̹� ���õǾ����ϴ�.");
			//���� �̹� ���õǾ��� �� �˸�â ���� 
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�� ���Ǵ� �̹� ���õǾ����ϴ�.'); location.href='lecture.jsp';</script>");
			out.flush();
		}
	}

}
