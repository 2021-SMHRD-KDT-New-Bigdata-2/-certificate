package com.model;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		// ����� �ڵ� ��������
		
		// DAO�� Lecture_viewAll �����ؼ� ��ü ���̺� ������ ��������
		LectureDAO dao = new LectureDAO();
		ArrayList<LectureVO> list = dao.Lecture_ViewAll();
		
		if(list.size()>0) {
			LectureVO vo = list.get(1);
			
			String a = vo.getLecture_name();
			
			System.out.println(a);
		} else {
			System.out.println("list����");
		}

	}

}
