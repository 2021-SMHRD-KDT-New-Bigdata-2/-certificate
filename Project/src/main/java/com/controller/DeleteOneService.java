package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.messageDAO;

@WebServlet("/DeleteOneService")
public class DeleteOneService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num = request.getParameter("num");
				System.out.println("num: "+num);
		
		messageDAO dao = new messageDAO();
		int cnt = dao.deleteOne(num);
		
		if (cnt>0) {
			System.out.println("�޽��� �ϳ� ���� ����");
		}else {
			System.out.println("�޽��� �ϳ� ���� ����");
		}
		response.sendRedirect("main.jsp");
		
	}

}
