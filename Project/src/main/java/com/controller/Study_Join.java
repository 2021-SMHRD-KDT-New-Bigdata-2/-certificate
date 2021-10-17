package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.model.MemberDAO;
import com.model.MemberVO;
import com.model.StudyMemberDAO;
//���͵� ������ �� �־����
@WebServlet("/Study_Join")
public class Study_Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * request.setCharacterEncoding("euc-kr");
	 * 
	 * String name = request.getParameter("name");//������ ���͵� �̸� //���ǿ��� �ڽ��� �̸� �޾ƿ���
	 * //�����ϴ� �޼ҵ带 ���� //���������� studyjoinsuccess�� ������ //���������� �����ߴٰ� ����ֱ�
	 * 
	 * //���͵𿡼� �����ϱ� ������ ���⼭ ���͵�ȸ���� ����Ѵ�. �׸��� joinsuccess�� �����ش�.
	 * System.out.println(name); }
	 */
	///////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////ȸ�����Կ��� ������///////////////////////////////
	//���͵𿡼� ���� �޾ƿͼ� ���͵� ��� ���̺� �����ϱ�/////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		//���͵� ���ý� �޾ƿ��� �Ű�����
		HttpSession session = request.getSession();//���� ����
		String studyNo = "";
		if(request.getParameter("studyNo") !=null){
			studyNo = request.getParameter("studyNo");//study.jsp���� �Ű����� ���͵�ѹ� �޾ƿ���
		}else {
			studyNo= (String)session.getAttribute(studyNo);
		}
		MemberVO vo = (MemberVO)session.getAttribute("Member");//���ǿ��� ȸ���ѹ� �޾ƿ���
		String memberNo = Integer.toString(vo.getMember_no());//��Ʈ������ ����ȯ�ϱ�
		
		
		//studyMemberDAO�� ������
			StudyMemberDAO dao = new StudyMemberDAO();
			//���͵� ���ý� �޾ƿ��� ������ �� ���� ������� �ƴϸ� ���͵� �̸������� ���͵� ���尡���ϰ� ���� ��
			//�ϴ� ���� �ϳ��θ� �����ϰ� �������
			int cnt = dao.study_Join(studyNo, memberNo);
			
			// ���Ŀ� ȸ������ �� ������ Ȱ�� �Է��ؾ���
			if (cnt>0) {
				// ���� ��ü ����

				
				// ���͵� ������ ����� �̸��� ���͵� �̸��� ���ǿ� ����
				//������ ��
				session.setAttribute("Study_no", studyNo);
				
				// ������ ���͵� ���Լ������� ������
				response.sendRedirect("StudyJoinSuccess.jsp");
			}
			
	
		
	}

}
