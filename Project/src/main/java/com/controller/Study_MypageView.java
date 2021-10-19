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
import com.model.LectureVO;
import com.model.MemberVO;
import com.model.StudyMemberDAO;
import com.model.StudyVO;

//�������������� COURSE�� �ڽ��� ���� ���͵� �� �� �־�� ��
@WebServlet("/Study_MypageView")
public class Study_MypageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//�������������� �ڽ��� ���� ���͵� �� �� �ִ� â
		//���ǰ�ü����->���̵� �̿��� ȸ����ȣ�� �������� ����
		HttpSession session = request.getSession();
		MemberVO vo2 = (MemberVO)session.getAttribute("Member");
		int member_no = vo2.getMember_no();
		StudyMemberDAO dao = new StudyMemberDAO();
		
		ArrayList<StudyVO> list = dao.StudyMember_Select(member_no);
		
		if (list != null) {
			
			// �� ���������� ���ǿ� ����
			session.setAttribute("StudyMy", list);
			
			// ������������ �̵�
			response.sendRedirect("mystudy.jsp");
		}	
	}

}
