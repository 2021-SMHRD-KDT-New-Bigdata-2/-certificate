package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CourseDAO;
import com.model.CourseVO;
import com.model.LectureDAO;
import com.model.LectureVO;
import com.model.MemberDAO;
import com.model.MemberVO;

// �������������� ���������� ������ ���
@WebServlet("/Lecture_MainpageService")
public class Lecture_MypageView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		//�������������� �ڽ��� ���� ���͵� �� �� �ִ� â
		//���ǰ�ü����->���̵� �̿��� ȸ����ȣ�� �������� ����
		HttpSession session = request.getSession();
		MemberVO vo2 = (MemberVO)session.getAttribute("Member");
		int member_no = vo2.getMember_no();
		CourseDAO dao = new CourseDAO();
		
		ArrayList<LectureVO> list = dao.Course_mypage(member_no);
		
		if (list != null) {
		
			// �� ���������� ���ǿ� ����
			session.setAttribute("LectureMy", list);
			
			// ������������ �̵�
			response.sendRedirect("mycourse.jsp");
		}	
	}

}