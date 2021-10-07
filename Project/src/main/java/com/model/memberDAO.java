package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
//DAO: Data Access Object
//DTO: Data Transfer Object
public class memberDAO {
	Connection conn = null;
	PreparedStatement pst=null;
	ResultSet rs = null;
	
	//db���� �޼ҵ�
	public void getConnection() {
		try {
			//1. JDBC ����̹� ���� �ε�
			//ClassNotFoundException ������ �ߴ°��
			//�ذ���1.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹��ε�");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "campus_k2_1006";
			String password = "smhrd2";
			//2. �����ͺ��̽� ���� ��ü(Connection) ����
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("db����");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//db close �޼ҵ�
	public void close() {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(pst!=null) {
				pst.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//ȸ�������Ҷ� ȣ���� �޼���
	public int join(String id, String pw) {
		//�ٸ�Ŭ�������� �޼��尡 ���𰡸� �˰��־�� �Ѵٸ� �Ű������� �Ѱ��ָ� �ȴ�.
		
		//try~catch: ����ó��(db�� ���� sql ���� ��Ÿ�ӿ����� �߻��� ����� �ֱ� ������)
		int cnt = 0;
		try {
			getConnection();
			System.out.println("����");
			
			//3. SQL �غ�/���� ��ü(PreparedStatement) ����
			pst = conn.prepareStatement("insert into member values(?,?,?,?,?,?,?)");
			
			//4. ���ε� ���� ä���(���ε庯�� ������ 1���� ����, ä���� ��)
			//pst.setString(1, );//ȸ����ȣ �������ֱ�
			pst.setString(2, id);
/*			pst.setString(3, name);
*			pst.setString(4, tel);
*			pst.setString(5, address);
*			pst.setString(6, interest);
*			pst.setString(7, job);
			*/ //���� ���̺� ���� ���� ���ϱ�. ���̺� ��й�ȣ �÷��� ����
			
			System.out.println("��������");

			
			//5. sql�� ���� �� ���ó��
			//cnt: sql�� ����� ���̺�� ��ȭ�� �Ͼ�� ���ڵ��� ��
			cnt = pst.executeUpdate();
			
			if(cnt>0) {
				System.out.println("ȸ�����Լ���!");

			}
			
		}catch(Exception e){
			System.out.println("ȸ�����Խ���");
			e.printStackTrace();//���ܻ�Ȳ �߻� ������� ���. ���߻�Ȳ���� ���� ���� ��õ
			
		}finally {
			close();
		}
		return cnt;
	}
	public memberVO login(String id, String pw) {

		//�޾ƿ� ���� ���̺�� �����ϴ��� Ȯ��(DB) JDBC
		memberVO vo = null;// �̸� �����Ѵ�
		try {
			getConnection();
			//3. SQL �غ�/���� ��ü(PreparedStatement) ����
			String sql = "select * from member where member_id=? and member_pw=?";
			///////////////////////////////////////////
			//sql�� �����ϱ� web_member�� ���� �÷��̸�����////
			///////////////////////////////////////////
			pst = conn.prepareStatement(sql);
			
			//4. ���ε� ���� ä���(���ε庯�� ������ 1���� ����, ä���� ��)
			pst.setString(1, id);
			pst.setString(2, pw);
			
			//5. sql�� ���� 
			rs = pst.executeQuery();
			
			//6.���ó��
			/////////////////////////////
			//�ʿ��Ұ�� if�� ���� ���� �츱��//
			////////////////////////////
			if(rs.next()) {
				System.out.println("�α��μ���");

				String get_id = rs.getString("id");//�����ͺ��̽��� ���̵�
				String get_pw = rs.getString("pw");//�����ͺ��̽��� ���
				
				vo = new memberVO(get_id, get_pw);//��ü�� ������

			}
			
		}catch(Exception e){
			System.out.println("�α��ν���");
			e.printStackTrace();
		}finally {
			
			close();
		}
		return vo;
	}
	//ȸ������������ �� ȣ���� �޼ҵ�
	public int update(String pw, String tel, String address, String email) {
		//���� �α����� ȸ��(�̸��� Ȱ��)�� pw, tel, address ����
		//���� ������ console�� "ȸ���������� ����" ���
		//(update�� java�ð� �ۼ��� update / messagesystem join(insert) ����)
		
		int cnt=0;
		
		try {
			getConnection();
			
			//3. SQL �غ�/���� ��ü(PreparedStatement) ����
			String sql="update web_member set pw=?, tel=?, address=? where email=?";
			pst = conn.prepareStatement(sql);
			
			//4. ���ε� ���� ä���(���ε庯�� ������ 1���� ����, ä���� ��)
			pst.setString(1, pw); //updateService���� �߶�Դµ� �������ǰ� �ȵǾ��ִ�. �׷��� �Ű������� �޾ƿ��ֱ� �Ѵ�.
			pst.setString(2, tel);
			pst.setString(3, address);
			pst.setString(4, email);
			
			//5. sql�� ���� �� ���ó��
			//cnt: sql�� ����� ���̺�� ��ȭ�� �Ͼ�� ���ڵ��� ��
			cnt = pst.executeUpdate();//��� ���ڵ尡 ��ȯ�Ǿ����� ������ ��ȯ
			
			
			
		}catch(Exception e){
			System.out.println("��������");
			e.printStackTrace();//���ܻ�Ȳ �߻� ������� ���. ���߻�Ȳ���� ���� ���� ��õ
			
		}finally {
			close();
		}
		return cnt;
	}
	
	//������ ȸ���������� �޼ҵ�
	public ArrayList<memberVO> select() {
		ArrayList<memberVO> list = new ArrayList<memberVO>();
		try {
			getConnection();
			String sql = "select email, tel, address from web_member";
			
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				//ȸ�� �Ѹ��� ���� ��
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				String address = rs.getString("address");
				
				//ȸ�� �Ѹ��� ��//�Ŀ�ġ�� ���
				memberVO vo = new memberVO(email, tel, address);
				list.add(vo);//����ū ���濡 ���
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
}
