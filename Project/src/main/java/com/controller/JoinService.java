package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;

// ȸ������ ��ư�� ������ ����� servlet �ڵ�
@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// ȸ������ form�� �ۼ��� �� �޾ƿ���
		String member_id = request.getParameter("id");	// ȸ�����̵�
		String member_NM = request.getParameter("name");	// �̸�
		String member_tel = request.getParameter("tel");	// ��ȭ��ȣ
		String member_address = request.getParameter("address");	// �ּ�
		String member_interest = request.getParameter("interest");	// ���ɺо�
		String member_job = request.getParameter("job");	// ����
		String member_pw = request.getParameter("pwd");	// ��й�ȣ
		String member_repw = request.getParameter("repwd"); // ��й�ȣ ��Ȯ��
		
		// ��й�ȣ ��ġ���� Ȯ�� & �ʼ����� �Է¿��� Ȯ��
		if(member_pw.equals(member_repw) && member_id != null && member_pw != null && member_repw != null) {
			MemberDAO dao = new MemberDAO();
			int cnt = dao.Join(member_id, member_NM, member_tel, member_address, member_interest, member_job, member_pw);
			
			// ���Ŀ� ȸ������ �� ������ Ȱ�� �Է��ؾ���
			if (cnt>0) {
				// ���� ��ü ����
				HttpSession session = request.getSession();
				
				// ȸ�������� ��� ���̵� ���ǿ� ����
				session.setAttribute("MemberJoinID", member_id);
				
				// ȸ������ ������������ �̵�(ȸ������ �������������� id�� �Բ� ȯ���޽��� ���� ������ ��밡��)
				response.sendRedirect("joinSuccess.jsp");
			}
			
		} else if(!member_pw.equals(member_repw)) {
			// ��й�ȣ�� ���Էº�й�ȣ ����ġ���� �׼�
		} else {
			// �ʼ����� �������� �׼�
		}
		
	}

}
