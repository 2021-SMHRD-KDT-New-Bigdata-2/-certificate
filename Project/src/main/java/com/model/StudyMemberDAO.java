package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	//������ ���͵������� �����ִ� �޼ҵ�(����������)
	public ArrayList<StudyVO> StudyMember_Select(int member_no) {
		ArrayList<StudyVO> list = new ArrayList<StudyVO>();
		try {
			getConnection();
			String sql = "select * from Study S join StudyMember SM on S.study_no = SM.study_no_sm where SM.member_no_sm = ?";
			
			// SQL ���� ��ü ����
			psmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			// ���ε� ���� ä���
			psmt.setInt(1, member_no);
			
			// sql�� ����
			rs = psmt.executeQuery();
			
			// ���ó��
			// ���͵� ���̺� null������ �̷���� �����־� ���ɸ�.
			
			
			while(true) {
				if(rs.next()) {	
					System.out.println("���͵� ��� ����");
					int study_no = rs.getInt("study_no");
					String study_name = rs.getString("study_name");
					String study_begin =  rs.getString("study_begin");
					String study_end =  rs.getString("study_end");
					String study_sub =  rs.getString("study_sub");
					String study_place =  rs.getString("study_place");
					String study_week =  rs.getString("study_week");
					String study_time =  rs.getString("study_time");
					
					StudyVO vo = new StudyVO(study_no, study_name, study_begin, study_end, study_sub, study_place, study_week, study_time);
					list.add(vo);
				}
				
				if(rs.isLast()) {
					break;
				}
				}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���͵� ��� ����");
		}finally {
			close();
		}
		return list;
	
	}

	
		//���͵� �����ϴ� �޼ҵ�
		public int study_Join(String studyNo, int memberNo) {
			int cnt=0;
			try {
				getConnection();
				String sql = "insert into sutdymember values(StudyMember_seq.nextval, ?, ?);";
				psmt.setString(1, studyNo);
				psmt.setInt(2, memberNo);
				cnt = psmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("���͵� ���� ���� ����");
			}finally {
				close();
			}
			return cnt;
		}

		public int Study_MypageView(int member_no) {
			int cnt = 0;
			
			try {
				getConnection();
				
				
				
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("���͵� ���� ���� ����");
			} finally {
				close();
			}
			return cnt;
		}

}
