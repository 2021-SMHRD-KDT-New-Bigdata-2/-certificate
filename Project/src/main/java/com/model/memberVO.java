package com.model;

public class memberVO {//(memberValueObject)
	
	//�ʵ�(�Ӽ�)����
	//private: ����������(���� ��ü �������� ���ٰ���)
	private String id;
	private String email;
	private String pw;
	private String tel;
	private String address;
	
	//������ ��ȯŸ�� �ʿ����
	//������ �����ε� �ؼ� 2������, 4������ ������ �� �ִ� �����ڸ� ���� �� �ִ�.
	public memberVO(String email, String tel, String address) {
		this.email=email;
		this.tel=tel;
		this.address=address;
	}
	
	//getter
	public String getEmail() {
		return email;
	}
	public String getPw() {
		return pw;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}
	//setter�� �� ���� ���� ����. �����ͺ��̽����� update�� �ַ� ����Ѵ�.

	public String getId() {
		return id;
	}


	
}
