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
			psmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			// sql�� ����
			rs = psmt.executeQuery();
			
			// ���ó��
			// while������ ù��° �����Ͱ� ����� �ȵǴ� ���� Ȯ���ؼ� �ӽ���ġ

				
			while(true) {
				if(rs.next()) {		
					int study_no = rs.getInt("study_no");
					System.out.println(study_no);
					String study_name = rs.getString("study_name");
					String study_begin = rs.getString("study_begin");
					String study_end = rs.getString("study_end");
					String study_sub = rs.getString("study_sub");
					String study_place = rs.getString("study_place");
					String study_week = rs.getString("study_week");
					String study_time = rs.getString("study_time");
					 
					StudyVO vo = new StudyVO(study_no, study_name, study_begin, study_end, study_sub, study_place, study_week, study_time);
					list.add(vo);
				}
				
				if(rs.isLast()) {
					break;
				}
			}

			
			
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
				
				vo = new StudyVO(study_no, study_name, study_begin, study_end, study_sub, study_place, study_week, study_time);
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
	public int Study_Creation(String study_name, String study_begin, String study_end, String study_sub, String study_place, String study_week, String study_time, int member_no) {
		int cnt = 0;
		
		try {
			getConnection();
			
			// ���͵����� ���� sql��
			String sql1 = "insert into study values(study_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
			
			// SQL ���� ��ü ����
			psmt = conn.prepareStatement(sql1);
			
			// ���ε� ���� ä���
			psmt.setString(1, study_name);
			psmt.setString(2, study_begin);
			psmt.setString(3, study_end);
			psmt.setString(4, study_sub);
			psmt.setString(5, study_place);
			psmt.setString(6, study_week);
			psmt.setString(7, study_time);
			
			// sql�� ���� �� ���ó��
			cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("���͵����̺� ���� ����");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("���͵����� ���� ����");
		} finally {
			close();
		}
		return cnt;
	}

	public int StudyMember_Creation(int study_no, int member_no) {
		int cnt = 0;
		
		try {
			getConnection();
			
			// ���͵����� ���� sql��
			String sql = "insert into studymember values(studyMember_seq.nextval, ?, ?)";
			
			// SQL ���� ��ü ����
			psmt = conn.prepareStatement(sql);
						
			// ���ε� ���� ä���
			psmt.setInt(1, study_no);
			psmt.setInt(2, member_no);
			
			// sql�� ���� �� ���ó��
			cnt = psmt.executeUpdate();
						
			if(cnt > 0) {
				System.out.println("���͵��� ���� ����");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("���͵��� ���� ����");
		} finally {
			close();
		}
		return cnt;
	}
//	//���͵��ȣ�������� �޼���
//	int study_no= newStudyNo();			
	
	//��� ���� ���͵��� �ѹ��� �޾ƿ��� �޼���
		public int newStudyNo() {
			int study_no = 0;
			
			try {
				getConnection();
				
				// ���͵����� ������� sql��
				String sql = "select study_no from (select study_no from study order by study_no desc) where rownum =1";
				//study �÷��� ���͵� �ѹ��������� �������� ������ ���� ���� ������ ��ȣ�� �������� sql���Դϴ�.
				
				// sql�� ����
				rs = psmt.executeQuery();
				
				// ���ó��
				if(rs.next()) {		
					System.out.println("���͵��ȣ ��� ����");
					study_no = Integer.parseInt(rs.getString("study_no"));
				}
				
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("���͵��ȣ ��� ����");
			} finally {
				close();
			}
			
			return study_no;
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
//				String study_onoff = rs.getString("study_onoff");
				
				StudyVO vo = new StudyVO(study_no, study_name, study_begin, study_end, study_sub, study_place, study_week, study_time);
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
	
	// ���͵� �˻����ִ� �޼ҵ� 
	public ArrayList<StudyVO> Study_Search(String words) {
		ArrayList<StudyVO> list = new ArrayList<StudyVO>();
		String sql = "";
		
		try {
			getConnection();
			
			// �������� �˻�� ����
			String[] hitwords = words.split(" ");
			
			System.out.println(hitwords);
			for (int i= 0; i< hitwords.length ; i++){
				System.out.println(hitwords[i]);
			}
			
			for (int i=0; i<hitwords.length; i++) {
				// �˻� sql��
				sql = "select * from Study where study_name like '%" + hitwords[i] + "%' OR study_sub like '%" + hitwords[i] + "%' OR study_place like '%" + hitwords[i] + "%'";
				
				// SQL ���� ��ü ����
				psmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				// sql�� ����
				rs = psmt.executeQuery();
				
				// �˻�� �Ȱɸ��� ��� �ӵ��� �ʹ������� �˻�� ������ ���� ��� ��Ƽ���� ���� iteration���� �ѱ�� �κ� �߰�
				if(!rs.next()) {
					continue;
				} else {
					int get_no = rs.getInt("study_no");
					String get_name = rs.getString("study_name");
					String get_begin = rs.getString("study_begin");
					String get_end = rs.getString("study_end");
					String get_sub = rs.getString("study_sub");
					String get_place = rs.getString("study_place");
					String get_week = rs.getString("study_week");
					String get_time = rs.getString("study_time");
					
					StudyVO vo = new StudyVO(get_no, get_name, get_begin, get_end, get_sub, get_place, get_week, get_time);
					list.add(vo);
				
					// ���ó��
					while(true) {
						if(rs.next()) {
							get_no = rs.getInt("study_no");
							get_name = rs.getString("study_name");
							get_begin = rs.getString("study_begin");
							get_end = rs.getString("study_end");
							get_sub = rs.getString("study_sub");
							get_place = rs.getString("study_place");
							get_week = rs.getString("study_week");
							get_time = rs.getString("study_time");
							
							vo = new StudyVO(get_no, get_name, get_begin, get_end, get_sub, get_place, get_week, get_time);
							list.add(vo);
						}
						
						if(rs.isLast()) {
							break;
						}
						
						if(!rs.next()) {
							break;
						}
					}
				}
			}
			System.out.println("���͵� �˻� ����");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("���͵� �˻� ����");
		} finally {
			close();
		}
		return list;
	}
}
