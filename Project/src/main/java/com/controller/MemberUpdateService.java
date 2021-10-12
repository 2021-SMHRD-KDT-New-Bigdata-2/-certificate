package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberVO;

@WebServlet("/MemberUpdateService")
public class MemberUpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("Member");
		
		// �α������� ������ VO�κ��� id ��������
		String id = vo.getMember_id();
		
		// �Է¹��� ������ ������ ������ ���� 
		String new_NM = request.getParameter("name");	// �̸�
		String new_tel = request.getParameter("tel");	// ��ȭ��ȣ
		String new_address = request.getParameter("address");	// �ּ�
		String new_interest = request.getParameter("interest");	// ���ɺо�
		String new_job = request.getParameter("job");	// ����
		String new_pw = request.getParameter("pw");	// ��й�ȣ
		
		// update �޼ҵ����
		MemberDAO dao = new MemberDAO();
		int cnt = dao.Update(id, new_pw, new_NM, new_tel, new_address, new_interest, new_job);
		
		if(cnt>0) {
			// ������ ������ ���� vo��ü ����
			MemberVO new_vo = new MemberVO(id, new_NM, new_tel, new_address, new_interest, new_job, new_pw);
			
			// ���� ����
			session.setAttribute("Member", new_vo);
			
			// ������������ �̵�
			response.sendRedirect("main.jsp");
		}
	}

}
