package com.model;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		// ����� �ڵ� ��������
		
		// DAO�� Lecture_viewAll �����ؼ� ��ü ���̺� ������ ��������
		LectureDAO dao = new LectureDAO();
		ArrayList<LectureVO> list = dao.Lecture_ViewAll();
		
		for(int i=0; i<list.size();i++) {
			LectureVO vo = list.get(i);	
			
			String a = vo.getLecture_name();
			
			System.out.println(a);
		}

	}

}
