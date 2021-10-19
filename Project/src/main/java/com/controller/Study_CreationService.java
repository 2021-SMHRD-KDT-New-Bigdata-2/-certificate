package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CourseDAO;
import com.model.MemberVO;
import com.model.StudyDAO;
import com.model.StudyMemberDAO;

// ���͵����� ���� ��ư�� ������ ���͵������� �����ϰ� ������ �����ϴ� servlet �ڵ�
@WebServlet("/Study_CreationService")
public class Study_CreationService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		//�������������� �ڽ��� ���� ���͵� �� �� �ִ� â
		//���ǰ�ü����->���̵� �̿��� ȸ����ȣ�� �������� ����
		HttpSession session = request.getSession();
		MemberVO vo2 = (MemberVO)session.getAttribute("Member");
		int member_no = vo2.getMember_no();
		// ���͵����� ���� form�� �ۼ��� �� �޾ƿ���
		String study_name = request.getParameter("name");	// ���͵��
		String study_begin = request.getParameter("begin");	// ��������
		String study_end = request.getParameter("end");	// ��������
		String study_sub = request.getParameter("sub");	// ���͵����
		String study_place = request.getParameter("place");	// ���
		String study_week = request.getParameter("week");	// ����
		String study_time = request.getParameter("time");	// �ð�

		StudyDAO dao = new StudyDAO();
		int cnt = dao.Study_Creation(study_name, study_begin, study_end, study_sub, study_place, study_week, study_time, member_no);
		
		// ���͵� ���� ���� �� ������ Ȱ��
		if (cnt>0) {
			
			// ������ ���͵� ���� �̸��� ���ǿ� ����
			session.setAttribute("StudyCreation", study_name);
			int studyNo = dao.newStudyNo();
			
			//������ ���͵��� ��ȣ�� ���ǿ� ����
			session.setAttribute("newStudyNo", studyNo);
			
			// ���͵� ���� ���� �����ϸ� ���͵� ���� �Խ������� �̵�(ȸ������ �������������� id�� �Բ� ȯ���޽��� ���� ������ ��밡��)
			response.sendRedirect("studySuccess.jsp");
		}else {
			System.out.println("���͵� ���� �����Ͽ� ����â���� �̵�");
			response.sendRedirect("studycreate.jsp");
		}
		
	}

}
