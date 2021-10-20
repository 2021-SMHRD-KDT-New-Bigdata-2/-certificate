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

// �������� ��ü �����͸� �����ִ� �޼ҵ�(������������ ���� 10���� ���)
public ArrayList<LectureVO> Lecture_ViewAll(int i) {
	ArrayList<LectureVO> list = new ArrayList<LectureVO>();
	
	try {
		getConnection();
		
		// �������� ��ü��� sql��
//		String sql = "select * from Lecture";
		
		// �������� ��ü���(10��) sql��(����� ���ǹ�ȣ ���� �������� ���ķ� �Ǿ�����)
		String sql = "select * from (select ROWNUM rnum, L.* from (select * from Lecture order by Lecture_no asc) L) where rnum between ? and ?";
		
		// SQL ���� ��ü����
		psmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		// ���ε� ���� ä���
		psmt.setInt(1, 1+(i-1)*10);
		psmt.setInt(2, 10+(i-1)*10);
		
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
	public ArrayList<LectureVO> Lecture_Search(String words, int j){
		ArrayList<LectureVO> list = new ArrayList<LectureVO>();
//		list = null;
		String sql = "";
		
		try {
			getConnection();
			
			// �������� �˻�� ����
			String[] hitwords = words.split(" ");
			
			//===================������� ���� ��� �ȵ�============
			for (int i= 0; i< hitwords.length ; i++){
				System.out.println(hitwords[i]);
			}

			for (int i=0; i<hitwords.length; i++) {
				
				// �˻� sql��
//				sql = "select * from Lecture where lecture_name like '%" + hitwords[i] + "%'";//Ǫ��
				// ���䵥���Ͱ� �ʹ��� �˻��� �۵�����
//				sql = "select * from Lecture where lecture_name like '%" + hitwords[i] + "%' OR lecture_teach like '%" + hitwords[i] + "%' OR lecture_count like '%" + hitwords[i] + "%' OR lecture_review like '%" + hitwords[i] + "%' OR lecture_cat like '%" + hitwords[i] + "%'";
				// ����˻��� �� �ڵ���
//				sql = "select lecture_no, lecture_cat, lecture_name, lecture_teach, lecture_count, lecture_price, lecture_point, lecture_url from Lecture where lecture_name like '%" + hitwords[i] + "%' OR lecture_teach like '%" + hitwords[i] + "%' OR lecture_cat like '%" + hitwords[i] + "%'";
				
				// []���Խ� �˻��� �ȵǴ°� ����
				// �˻���� 10���� ����ϴ� sql��
//				sql = "select * from (select ROWNUM rnum, L.* from (select lecture_no, lecture_cat, lecture_name, lecture_teach, lecture_count, lecture_price, lecture_point, lecture_url from Lecture where lecture_name like '%" + hitwords[i] + "%' OR lecture_teach like '%" + hitwords[i] + "%' OR lecture_cat like '%" + hitwords[i] + "%') L)";
		
				sql = "select * from (select ROWNUM rnum, L.* from (select lecture_no, lecture_cat, lecture_name, lecture_teach, lecture_count, lecture_price, lecture_point, lecture_url from Lecture where lecture_name like '%" + hitwords[i] + "%' OR lecture_teach like '%" + hitwords[i] + "%' OR lecture_cat like '%" + hitwords[i] + "%' order by Lecture_no asc) L) where rnum between ? and ?";
				// ���� ���Ǹ� �ɸ� �����۸�ũ���� �˻��Ǿ���� 
				// ���� lecture_name�� "https://"�� ������ �� �� ������ ������ �����Ѵ�.(X �� ����� Ʋ����)
				
				// SQL ���� ��ü ����
				psmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

				// ���ε� ���� ä���
				psmt.setInt(1, 1+(j-1)*10);
				psmt.setInt(2, 10+(j-1)*10);
				
				// sql�� ����
				rs = psmt.executeQuery();
				
				// �˻�� �Ȱɸ��� ��� �ӵ��� �ʹ������� �˻�� ������ ���� ��� ��Ƽ���� ���� iteration���� �ѱ�� �κ� �߰�
				if(!rs.next()) {
					continue;
				} else {
					int get_no = rs.getInt("lecture_no");
					String get_cat = rs.getString("lecture_cat");
					String get_name = rs.getString("lecture_name");		
					String get_teach = rs.getString("lecture_teach");
					String get_count = rs.getString("lecture_count");
					int get_price = rs.getInt("lecture_price");
					double get_point = rs.getDouble("lecture_point");
//					String get_review = rs.getString("lecture_review");
					String get_url = rs.getString("lecture_url");

					LectureVO vo = new LectureVO(get_no, get_name, get_teach, get_count, get_price, get_point, get_url, get_cat);
//					LectureVO vo = new LectureVO(get_no, get_name, get_teach, get_count, get_price, get_point, get_review, get_url, get_cat);
					list.add(vo);
					
					// ���ó��
					while(true) {
						if(rs.next()) {		
							get_no = rs.getInt("lecture_no");
							get_cat = rs.getString("lecture_cat");
							get_name = rs.getString("lecture_name");		
							get_teach = rs.getString("lecture_teach");
							get_count = rs.getString("lecture_count");
							get_price = rs.getInt("lecture_price");
							get_point = rs.getDouble("lecture_point");
//							get_review = rs.getString("lecture_review");
							get_url = rs.getString("lecture_url");

							vo = new LectureVO(get_no, get_name, get_teach, get_count, get_price, get_point, get_url, get_cat);
//							vo = new LectureVO(get_no, get_name, get_teach, get_count, get_price, get_point, get_review, get_url, get_cat);
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
				sql = "select * from LECTURE where LECTURE_CAT = ?";
				
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
//					String get_review = rs.getString("lecture_review");
					String get_url = rs.getString("lecture_url");
					String get_cat = rs.getString("lecture_cat");
					
					LectureVO vo = new LectureVO(get_no, get_name, get_teach, get_count, get_price, get_point, get_url, get_cat);
//					LectureVO vo = new LectureVO(get_no, get_name, get_teach, get_count, get_price, get_point, get_review, get_url, get_cat);
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
	public ArrayList<LectureVO> Lecture_MainView(int i) {
		ArrayList<LectureVO> list = new ArrayList<LectureVO>();
		String site_url = null;
		
		switch (i) {
			case 0: site_url = "taling.me"; break;
			case 1: site_url = "edu.goorm.io"; break;
			case 2: site_url = "www.inflearn.com"; break;
			// Ŭ����101����Ʈ�� ���� DB�� url�� null�� ����Ǿ �׿� ���� �ۼ�
			case 3: site_url = null; break;
		}
			
		try {
			getConnection();
			
//			// ���������� �Ϻ�Į���� ����ϴ� sql��(���� 4���� �̾Ƴ��� �۾��� controller�� Lecture_MainViewService���� ����)
//			String sql = "select lecture_name, lecture_teach, lecture_point, lecture_cat from Lecture order by lecture_point desc";
//			// ���������� �Ϻ�Į���� ����Ʈ���� �ϳ��� ����ϴ� sql��, (���� 1���� �̾Ƴ��� �۾��� controller�� Lecture_MainViewService���� ����)
			String sql = "select * from LECTURE where LECTURE_URL like '%"+ site_url +"' order by lecture_point desc";
			
			// SQL ���� ��ü����
			psmt = conn.prepareStatement(sql);
			
			// sql�� ����
			rs = psmt.executeQuery();
			
			// ���ó��
			if(rs.next()) {		
				System.out.println("�������� ����â ���� ����");
				
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
				reviewlist = get_review.split("\\$");
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
	
	
}

