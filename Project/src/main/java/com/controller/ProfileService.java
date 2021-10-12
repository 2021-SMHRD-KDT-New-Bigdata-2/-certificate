package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberVO;

@WebServlet("/ProfileService")
public class ProfileService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// �� �ڵ带 jsp ������ ������ �� ������ ����������.
		// jsp���� getAttribute�� vo �ҷ����� vo.get�Լ��� �̿��ؼ� ȸ������ �������°� �����ҵ�
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("Member");
		
		// �α������� ������ VO�κ��� id ��������
		String id = vo.getMember_id();
		
		// ȸ���������̺��� �ش� id�� ������ �����ͼ� Arraylist�� ����
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.Profile(id);
		
		// ���ǻ���
		if (list != null) {
			// ȸ���� ������ ���ǿ� ����
			session.setAttribute("MemberProfile", list);
			
			// ȸ�������������� �̵�
			response.sendRedirect("profile.jsp");
		}
	}

}
