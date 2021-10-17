package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudyMemberDAO {
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
	//������ ���͵������� �����ִ� �޼ҵ�
	//public void StudyMember_Select()

	
		//���͵� �����ϴ� �޼ҵ�
		public int study_Join(String studyNo, String memberNo) {
			int cnt=0;
			try {
				getConnection();
				String sql = "insert into sutdymember values(StudyMember_seq.nextval, ?, ?);";
				psmt.setString(1, studyNo);
				psmt.setString(2, memberNo);
				cnt = psmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("���͵� ���� ���� ����");
			}finally {
				close();
			}
			return cnt;
		}
		// �������������� COURSE�� �ڽ��� ������ ���͵� �� �� �־�� ��
		//���Ѽ� ������
/*		public int study_Create(String study_name, int study_begin, int study_end, String study_sub, String study_place, String study_week, String study_time) {
			int cnt = 0;
			
			try {
				getConnection();
				
				// ���͵����� ����� sql��(�ۼ���...)
				String sql = "insert into StudyMember values(StudyMember_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
				
				psmt.setString(1, study_name);
				psmt.setInt(2, study_begin);
				psmt.setInt(3, study_end);
				psmt.setString(4, study_sub);
				psmt.setString(5, study_place);
				psmt.setString(6, study_week);
				psmt.setString(7, study_time);
				
				cnt = psmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("���͵� ���� ���� ����");
			} finally {
				close();
			}
			return cnt;
		}
*/
}
