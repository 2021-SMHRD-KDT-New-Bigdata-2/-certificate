package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.messageDAO;
import com.model.messageVO;
@WebServlet("/MessageService")
public class MessageService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//post��� ���ڵ�
		request.setCharacterEncoding("EUC-KR");
		//3���� �� �޾ƿ���
		String sendEmail = request.getParameter("sendEmail");
		String receiveEmail = request.getParameter("receiveEmail");
		String message = request.getParameter("message");
		
		messageVO vo = new messageVO(sendEmail, receiveEmail, message);
		messageDAO dao = new messageDAO();
		
		int cnt = dao.insertMessage(vo);
		
		if(cnt>0) {
			System.out.println("�޽��� ���� ����");
		}else {
			System.out.println("�޽��� ���� ����");
		}
		
		response.sendRedirect("main.jsp");
	}

}
