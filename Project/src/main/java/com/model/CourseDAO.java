package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CourseDAO {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	// DB ���� �޼ҵ�
	public void getConnection() {
		try {
			// JDBC ����̹� ���� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "campus_k2_1006";
			String password = "smhrd2";
			
			// ������ ���̽� ���ᰴü ����
			conn = DriverManager.getConnection(url, user, password);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// DB close �޼ҵ�
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//��û�� ���������� �����ִ� �޼ҵ�
	//public void course_Select() {
		
	//}
	//���Ǹ� �����ϸ� Course���̺� insert�ϴ� ����
	public int course_insert(String member_id, int Lecture_no) {
		int cnt = 0;
		String member_no = null;
		try {
			getConnection();
			String sql1 = "select member_no from member where member_id=?";
			
			psmt = conn.prepareStatement(sql1);
			
			
			psmt.setString(1, member_id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {		
				member_no = rs.getString("member_no");
			}
			
			
			///====================================������� ��� �ʿ�================================
			//������ �������δ� ȸ����ȣ�� �ΰ������� ����ϴ°� ����Ʈ
			//���̺� �����ʿ�
			//�������� SEQUENCE�־��
			//���Ῡ��: NO
			//String sql2 = "insert into course values(?, ?, sysdate, ?, )";
			
			psmt.setString(1, member_no); //ȸ����ȣ ����
			psmt.setInt(2, Lecture_no); //�ΰ�����
									//������������ sysdate
			
			// sql�� ���� �� ���ó��
			cnt = psmt.executeUpdate();
						
			if(cnt > 0) {
				System.out.println("���Ǽ��� ����");
			}
						
		} catch(Exception e) {
			System.out.println("���Ǽ��� ����");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
}
