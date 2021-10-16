package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class LectureDAO {
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
	
	// �������� ��ü �����͸� �����ִ� �޼ҵ�
	public ArrayList<LectureVO> Lecture_ViewAll() {
		ArrayList<LectureVO> list = new ArrayList<LectureVO>();
		
		try {
			getConnection();
			
			// �������� ��ü��� sql��
			String sql = "select * from Lecture";
			
			// SQL ���� ��ü����
			psmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			// sql�� ����
			rs = psmt.executeQuery();
			
			// ���ó��
			while(true) {
				if(rs.next()) {		
					int get_no = rs.getInt("lecture_no");
					String get_name = rs.getString("lecture_name");
					String get_teach = rs.getString("lecture_teach");
					String get_count = rs.getString("lecture_count");
					int get_price = rs.getInt("lecture_price");
					double get_point = rs.getDouble("lecture_point");
					String get_review = rs.getString("lecture_review");
					String get_url = rs.getString("lecture_url");
					String get_cat = rs.getString("lecture_cat");
					
					LectureVO vo = new LectureVO(get_no, get_name, get_teach, get_count, get_price, get_point, get_review, get_url, get_cat);
					list.add(vo);
				}
				
				if(rs.isLast()) {
					break;
				}
			}
			System.out.println("�������� ��� ����");

			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("�������� ��� ����");
		} finally {
			close();
		}
		return list;
	}

	// �˻� �޼ҵ�
	public ArrayList<LectureVO> Lecture_Search(String words){
		ArrayList<LectureVO> list = new ArrayList<LectureVO>();
		String sql = "";
		
		try {
			getConnection();
			
			// �������� �˻�� ����
			String[] hitwords = words.split(" ");

			for (int i=0; i<hitwords.length; i++) {
				
				// �˻� sql��
//				sql = "select * from Lecture where lecture_name like '%" + hitwords[i] + "%'";//Ǫ��
				// ���䵥���Ͱ� �ʹ��� �˻��� �۵�����
//				sql = "select * from Lecture where lecture_name like '%" + hitwords[i] + "%' OR lecture_teach like '%" + hitwords[i] + "%' OR lecture_count like '%" + hitwords[i] + "%' OR lecture_review like '%" + hitwords[i] + "%' OR lecture_cat like '%" + hitwords[i] + "%'";
				// ����˻��� �� �ڵ���
				sql = "select * from Lecture where lecture_name like '%" + hitwords[i] + "%' OR lecture_teach like '%" + hitwords[i] + "%' OR lecture_cat like '%" + hitwords[i] + "%'";

				// ���� ���Ǹ� �ɸ� �����۸�ũ���� �˻��Ǿ���� 
				// ���� lecture_name�� "https://"�� ������ �� �� ������ ������ �����Ѵ�.(X �� ����� Ʋ����)
				
				// SQL ���� ��ü ����
				psmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

				// sql�� ����
				rs = psmt.executeQuery();
				
				// �˻�� �Ȱɸ��� ��� �ӵ��� �ʹ������� �˻�� ������ ���� ��� ��Ƽ���� ���� iteration���� �ѱ�� �κ� �߰�
				if(!rs.next()) {
					continue;
				}
				
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
			System.out.println("�˻� ����");
					
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("�˻� ����");
		} finally {
			close();
		}
		
		return list;
	}

	// ���� �޼ҵ�
	public ArrayList<LectureVO> Lecture_filter(ArrayList<String> filter){
		ArrayList<LectureVO> list = new ArrayList<LectureVO>();
		String sql = "";
		
		try {
			getConnection();
			
			for(int i=0; i<filter.size();i++) {
				// ���� sql��(�ݺ����� ���� ������ ���Ϳ� ���� ����鸸 ��������)
				sql = "select * from Lecture where lecture_cat = ?";
				
				// SQL ���� ��ü ����
				psmt = conn.prepareStatement(sql);
				
				// ���ε� ���� ä���
				psmt.setString(1, filter.get(i));
				
				// sql�� ����
				rs = psmt.executeQuery();
				
				// ���ó��
				if(rs.next()) {		
					int get_no = rs.getInt("lecture_no");
					String get_name = rs.getString("lecture_name");
					String get_teach = rs.getString("lecture_teach");
					String get_count = rs.getString("lecture_count");
					int get_price = rs.getInt("lecture_price");
					double get_point = rs.getDouble("lecture_point");
					String get_review = rs.getString("lecture_review");
					String get_url = rs.getString("lecture_url");
					String get_cat = rs.getString("lecture_cat");
					
					LectureVO vo = new LectureVO(get_no, get_name, get_teach, get_count, get_price, get_point, get_review, get_url, get_cat);
					list.add(vo);
				}
			}
			System.out.println("���� �˻� ����");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("���� �˻� ����");
		} finally {
			close();
		}
		return list;
	}
	
	// ������������ 4�������� ���������� ���� �޼ҵ�(���Ǹ�, �����, ����, ī�װ�)
	public ArrayList<LectureVO> Lecture_MainView() {
		ArrayList<LectureVO> list = new ArrayList<LectureVO>();
		
		try {
			getConnection();
			
			// ���������� �Ϻ�Į���� ����ϴ� sql��(���� 4���� �̾Ƴ��� �۾��� controller�� Lecture_MainViewService���� ����)
			String sql = "select lecture_name, lecture_teach, lecture_point, lecture_cat from Lecture order by lecture_point desc";
			
			// SQL ���� ��ü����
			psmt = conn.prepareStatement(sql);
			
			// sql�� ����
			rs = psmt.executeQuery();
			
			// ���ó��
			if(rs.next()) {		
				System.out.println("�������� ����â ���� ����");
				
				String lecture_name = rs.getString("lecture_name");
				String lecture_teach = rs.getString("lecture_teach");
				int lecture_point = rs.getInt("lecture_point");
				String lecture_cat = rs.getString("lecture_cat");

				
				LectureVO vo = new LectureVO(lecture_name, lecture_teach, lecture_point, lecture_cat);
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("�������� ����â ���� ����");
		} finally {
			close();
		}
		return list;
	}

	// ������ ������ ���並 �����ִ� ���
	public String[] Lecture_SelectReview(int lecture_no){
		String get_review = null;
		String[] reviewlist = null;
		
		try {
			getConnection();
			
			// ������ ������ ���並 ����ϴ� sql��
			String sql = "select lecture_review from Lecture where lecture_no = ?";
			
			// SQL ���� ��ü����
			psmt = conn.prepareStatement(sql);
			
			// ���ε� ���� ä���
			psmt.setInt(1, lecture_no);
			
			// sql�� ����
			rs = psmt.executeQuery();
			
			// ���ó��
			if(rs.next()) {		
				// ��ó���� ���� ��°�� ������
				get_review = rs.getString("lecture_review");
				
				// �����ڿ� ���� ���並 �ɰ��� ����
				reviewlist = get_review.split("DELIMITER111 ");
			}
			
			System.out.println("����ǥ�� ����");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("����ǥ�� ����");
		} finally {
			close();
		}
		return reviewlist;
	}
	
	//�������������� ���������� �����ִ� �޼ҵ�
		//public void Lecture_SelectMy(i){
		//}
	//���Ǹ� �����ϸ�, COURSE���̺� �ڵ����� ���̰� �ϴ� �޼ҵ�
		//public void Lecture_Select() {
			
		//}
}

