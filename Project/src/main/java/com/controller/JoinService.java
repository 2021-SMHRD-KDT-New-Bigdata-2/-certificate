package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// ȸ������ form�� �ۼ��� �� �޾ƿ���
		String member_id = request.getParameter("member_id");	// ȸ�����̵�
		String member_NM = request.getParameter("member_NM");;	// �̸�
		String member_tel = request.getParameter("member_tel");;	// ��ȭ��ȣ
		String member_address = request.getParameter("member_address");;	// �ּ�
		String member_interest = request.getParameter("member_interest");;	// ���ɺо�
		String member_job = request.getParameter("member_job");;	// ����
		String member_pw = request.getParameter("member_pw");;	// ��й�ȣ
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.Join(member_id, member_NM, member_tel, member_address, member_interest, member_job, member_pw);
		
		// ���Ŀ� ȸ������ �� ������ Ȱ�� �Է��ؾ���
		if (cnt>0) {
			// �� �Ѱ��ֱ�
			//request.setAttribute("joinemail", email);
			// forward ������� ������ �̵�
			//RequestDispatcher rd = request.getRequestDispatcher("joinSuccess.jsp");
			//rd.forward(request, response);
		}
		
	}

}
