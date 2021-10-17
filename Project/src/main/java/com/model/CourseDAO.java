package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	public int Course_Insert(int member_no, int lecture_no) {
		int cnt = 0;
		
		try {
			getConnection();
			
			// �ΰ� ������ �� ����ó�� ����:
			// member_no, lecture_no�� �Ű������� ����
			// ������ȣ�� �������� SQL developer���� ����
			// �������۽ð��� ������ �ð����� ����
			// ���Ῡ�δ� ���ý� N���� �����ϰ� �Ŀ� Y�� �ٲܼ��ְ�
			
			// ȸ���� ������ �����ϸ� ���������� ������ �� ����� �۵���Ű�� ���ϰ� �ؾ���.
			
			// �������ý� ���������� sql��
			String sql = "insert into COURSE values(COURSE_SEQ.nextval, ?, ?, TO_CHAR(SYSDATE, 'YYYY-MM-DD'), 'N')";
//			String sql = "select member_no from member where member_id=?";
			
			// SQL ���� ��ü ����
			psmt = conn.prepareStatement(sql);
			
			// ���ε� ���� ä���
			psmt.setInt(1, member_no);
			psmt.setInt(2, lecture_no);
			
			// sql�� ���� �� ���ó��
			cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("���� ���ü���");
			}
			
			
//			///====================================������� ��� �ʿ�================================
//			//������ �������δ� ȸ����ȣ�� �ΰ������� ����ϴ°� ����Ʈ
//			//���̺� �����ʿ�
//			//�������� SEQUENCE�־��
//			//���Ῡ��: NO
//			//String sql2 = "insert into course values(?, ?, sysdate, ?, )";
//			
//			psmt.setString(1, member_no); //ȸ����ȣ ����
//			psmt.setInt(2, lecture_no); //�ΰ�����
//									//������������ sysdate
//			
//			// sql�� ���� �� ���ó��
//			cnt = psmt.executeUpdate();
//						
//			if(cnt > 0) {
//				System.out.println("���Ǽ��� ����");
//			}
						
		} catch(Exception e) {
			System.out.println("���Ǽ��� ����");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	// ������ ���������� �������� �޼ҵ�
	public CourseVO Course_Select(int member_no, int lecture_no) {
		CourseVO vo = null;
		
		try {
			getConnection();
			
			// �������� �������� sql��
			String sql = "select * from COURSE where member_no_co = ? and lecture_no_co = ?";
			
			// SQL ���� ��ü ����
			psmt = conn.prepareStatement(sql);
			
			// ���ε� ���� ä���
			psmt.setInt(1, member_no);
			psmt.setInt(2, lecture_no);
			
			// sql�� ����
			rs = psmt.executeQuery();
			
			// ���ó��
			if(rs.next()) {		
				System.out.println("���ǵ����� �������� ����");
				
				int get_member_no_co = rs.getInt("member_no_co");
				int get_lecture_no_co = rs.getInt("lecture_no_co");
				String get_course_sd = rs.getString("course_sd");
				String get_course_comp = rs.getString("course_comp");
				int get_course_no = rs.getInt("course_no");
				
				vo = new CourseVO(get_member_no_co, get_lecture_no_co, get_course_sd, get_course_comp, get_course_no);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ǵ����� �������� ����");
		} finally {
			close();
		}
		return vo;
	}
	
	// ������ȣ�� �����Ͽ� ���������� �������� �޼ҵ�
	public CourseVO Course_SelectByCourse(int course_no) {
		CourseVO vo = null;
		
		try {
			getConnection();
			
			// �������� �������� sql��
			String sql = "select * from COURSE where course_no = ?";
			
			// SQL ���� ��ü ����
			psmt = conn.prepareStatement(sql);
			
			// ���ε� ���� ä���
			psmt.setInt(1, course_no);
			
			// sql�� ����
			rs = psmt.executeQuery();
			
			// ���ó��
			if(rs.next()) {		
				System.out.println("���ǵ����� �������� ����");
				
				int get_member_no_co = rs.getInt("member_no_co");
				int get_lecture_no_co = rs.getInt("lecture_no_co");
				String get_course_sd = rs.getString("course_sd");
				String get_course_comp = rs.getString("course_comp");
				int get_course_no = rs.getInt("course_no");
				
				vo = new CourseVO(get_member_no_co, get_lecture_no_co, get_course_sd, get_course_comp, get_course_no);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ǵ����� �������� ����");
		} finally {
			close();
		}
		return vo;
	}
	
	// �����Ϸ� ǥ�� �޼ҵ�
	public int Course_Complete(int course_no) {
		int cnt = 0;
		
		try {
			getConnection();
			
			// ����Ϸ����� ���� sql��
			String sql = "update COURSE set course_onoff = 'Y' where course_no = ?";
			
			// SQL ���� ��ü ����
			psmt = conn.prepareStatement(sql);
			
			// ���ε� ���� ä���
			psmt.setInt(1, course_no);
			
			// sql�� ���� �� ���ó��
			cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("ȸ������ ���� ����");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���Ῡ�� ���� ����");
		} finally {
			close();
		}
		return cnt;
	}
	public ArrayList<LectureVO> Course_mypage(int member_no) {
		ArrayList<LectureVO> list = new ArrayList<LectureVO>();
		try {
			getConnection();
			
			// �������� �������� sql��
			String sql = "select * from COURSE join lecture on lecture_no = lecture_no_co where member_no_co = ?";
			
			// SQL ���� ��ü ����
			psmt = conn.prepareStatement(sql);
			
			// ���ε� ���� ä���
			psmt.setInt(1, member_no);
			
			// sql�� ����
			rs = psmt.executeQuery();
			
			// ���ó��
			if(rs.next()) {		
				System.out.println("���������� ���ǵ����� �������� ����");
				
				// ���ó��
				while(true) {
					if(rs.next()) {		
						int get_no = rs.getInt("lecture_no");
						String get_cat = rs.getString("lecture_cat");
						String get_name = rs.getString("lecture_name");		
						String get_teach = rs.getString("lecture_teach");
						String get_count = rs.getString("lecture_count");
						int get_price = rs.getInt("lecture_price");
						double get_point = rs.getDouble("lecture_point");
						String get_review = rs.getString("lecture_review");
						String get_url = rs.getString("lecture_url");

						LectureVO vo = new LectureVO(get_no, get_name, get_teach, get_count, get_price, get_point, get_review, get_url, get_cat);
						list.add(vo);
					}
					
					if(rs.isLast()) {
						break;
					}
				}
				
				
			}
			}catch (Exception e) {
			e.printStackTrace();
			System.out.println("���������� ���ǵ����� �������� ����");
		}finally {
			close();
		}
		return list;
	}
}
