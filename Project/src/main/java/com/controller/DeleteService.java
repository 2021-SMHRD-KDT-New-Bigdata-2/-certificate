package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.memberVO;
import com.model.messageDAO;

@WebServlet("/DeleteService")
public class DeleteService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// session ���� �α����� ���� ��������
		HttpSession session = request.getSession();
		memberVO vo = (memberVO) session.getAttribute("member");
		
		messageDAO dao = new messageDAO();
		//�Ű������� �޴� email = ���� �α����� email
		int cnt = dao.DeleteService(vo.getEmail());
		
		if(cnt>0) {
			System.out.println("�޽��� ��ü ���� ����");
		}else {
			System.out.println("�޽��� ��ü ���� ����");
		}
		response.sendRedirect("main.jsp");
		
	}

}
