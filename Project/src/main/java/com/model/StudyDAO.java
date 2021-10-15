package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudyDAO {
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
	
	// ���͵� ���� ��ü�����͸� �����ִ� �޼ҵ�
	public ArrayList<StudyVO> Study_SeclectAll() {
		ArrayList<StudyVO> list = new ArrayList<StudyVO>();
		
		try {
			getConnection();
			
			// ���͵����� ��ü��� sql��
			String sql = "select * from Study";
			
			// SQL ���� ��ü����
			psmt = conn.prepareStatement(sql);
			
			// sql�� ����
			rs = psmt.executeQuery();
			
			// ���ó��
			while(true) {
				if(rs.next()) {		
					int study_no = rs.getInt("study_no");
					String study_name = rs.getString("study_name");
					String study_begin = rs.getString("study_begin");
					String study_end = rs.getString("study_end");
					String study_sub = rs.getString("study_sub");
					String study_place = rs.getString("study_place");
					String study_week = rs.getString("study_week");
					String study_time = rs.getString("study_time");
					String study_onoff = rs.getString("study_onoff");
					
					StudyVO vo = new StudyVO(study_no, study_name, study_begin, study_end, study_sub, study_place, study_week, study_time, study_onoff);
					list.add(vo);
				}
				
				if(rs.isLast()) {
					break;
				}
			}
			System.out.println("���͵����� ��� ����");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("���͵����� ��� ����");
		} finally {
			close();
		}
		return list;
	}

	
	// ���͵� ���� �ϳ��� �����ؼ� �����ִ� �޼ҵ�
	public StudyVO Study_SelectOne(int study_no) {
		StudyVO vo = null;
		
		try {
			getConnection();
			
			// ���͵����� ������� sql��
			String sql = "select * from Study where study_no=?";
			
			// SQL ���� ��ü����
			psmt = conn.prepareStatement(sql);
			
			// ���ε� ���� ä���
			psmt.setInt(1, study_no);
			
			// sql�� ����
			rs = psmt.executeQuery();
			
			// ���ó��
			if(rs.next()) {		
				System.out.println("���͵����� �Ϻ���� ����");
				
				String study_name = rs.getString("study_name");
				String study_begin = rs.getString("study_begin");
				String study_end = rs.getString("study_end");
				String study_sub = rs.getString("study_sub");
				String study_place = rs.getString("study_place");
				String study_week = rs.getString("study_week");
				String study_time = rs.getString("study_time");
				String study_onoff = rs.getString("study_onoff");
				
				vo = new StudyVO(study_no, study_name, study_begin, study_end, study_sub, study_place, study_week, study_time, study_onoff);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("���͵����� �Ϻ���� ����");
		} finally {
			close();
		}
		
		return vo;
	}
	
	// ���͵� ������ ������ �� �����͸� �����ϴ� �޼ҵ�
	public int Study_Creation(String study_name, String study_begin, String study_end, String study_sub, String study_place, String study_week, String study_time, String study_onoff) {
		int cnt = 0;
		
		try {
			getConnection();
			
			// ���͵����� ���� sql��
			String sql = "insert into Study values(Study_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			// SQL ���� ��ü ����
			psmt = conn.prepareStatement(sql);
			
			// ���ε� ���� ä���
			psmt.setString(1, study_name);
			psmt.setString(2, study_begin);
			psmt.setString(3, study_end);
			psmt.setString(4, study_sub);
			psmt.setString(5, study_place);
			psmt.setString(6, study_week);
			psmt.setString(7, study_time);
			psmt.setString(8, study_onoff);
			
			// sql�� ���� �� ���ó��
			cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("���͵����� ���� ����");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("���͵����� ���� ����");
		} finally {
			close();
		}
		return cnt;
	}
	
	// ���͵� ������ �����ϴ� �޼ҵ�(�ۼ���...Study�� StudyMember���̺��� �ߺ��� �κ� �����ʿ�)
	public void Study_Join(int study_no, int member_no) {
		int cnt = 0;
		
		try {
			getConnection();
			
			// ���͵����� ���� sql��(�ۼ���...)
			String sql = "insert into StudyMember values(StudyMember_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("���͵� ���� ���� ����");
		} finally {
			close();
		}
	}
	
	// ���͵� ���� ���Ῡ�θ� ǥ���ϴ� �޼ҵ�(delete)
	public int Study_End(int study_no) {
		//cnt���� �ʱ�ȭ
		int cnt = 0;
		
		try {
			getConnection();
			//���͵� ���ִ� sql��(delete)
			//Study���̺����� ����, studyMember���̺����� �������� �ʾƵ� �� ����
			String sql = "delete from Study where study_no=?";
			
			//sql�� ���� ��ü ����
			psmt= conn.prepareStatement(sql);
			
			//���ε庯��-���͵����
			psmt.setInt(1, study_no);
			
			//sql ���� �� �����
			cnt = psmt.executeUpdate();
			//���� ���� ���� ���
			if(cnt > 0) {
				System.out.println("���͵� ���� ���� ����");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("���͵� ���� ���� ����");
		}finally {
			close();
		}
		return cnt;
	}
	
	// ������������ 4�������� ���͵������� ���� �޼ҵ�
	//���� Ÿ���� ArrayList<StudyVO>->���͵� ������ ����
	public ArrayList<StudyVO> Study_MainView() {
		ArrayList<StudyVO> list = new ArrayList<StudyVO>();
		try {
			getConnection();
			
			//���͵� �������� ���� ������� 4���� ����ϴ� sql��
			//���������� ���͵�������� ���� ������ �����ͼ� 4���� ���
			String sql = "selete * from (selete * from Study order by study_begin asc) where rownum = 4";
			
			//sql�� ���� ��ü ����
			psmt= conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			//������������ ��� ���͵� ���� ��������
			if(rs.next()) {
				System.out.println("���������� ���͵� ���� ��� ����");
				
				//���͵� ���� ��� ���� ������
				//study_no�� �Ȱ����͵� �� �� ������ �ǳ��ʿ�
				int study_no = rs.getInt("study_no");
				String study_name = rs.getString("study_name");
				String study_begin = rs.getString("study_begin");
				String study_end = rs.getString("study_end");
				String study_sub = rs.getString("study_sub");
				String study_place = rs.getString("study_place");
				String study_week = rs.getString("study_week");
				String study_time = rs.getString("study_time");
				String study_onoff = rs.getString("study_onoff");
				
				StudyVO vo = new StudyVO(study_no, study_name, study_begin, study_end, study_sub, study_place, study_week, study_time, study_onoff);
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("������������ ���͵� ���̱� ����");
		}finally {
			close();
		}
		return list;
	}
}
