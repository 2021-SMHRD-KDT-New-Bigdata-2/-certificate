package com.model;

public class StudyMemberVO {
	// �ʵ����
	private int SM_id;	// ���͵� ID
	private int study_no_SM;	// ���͵� ����
	private int member_no_SM;	// ȸ����ȣ
	private String SM_title;	// ���͵�����
	private String SM_sd;	// ��������
	private String SM_ed;	// ��������
	private String SM_notice;	// ��������
	private String SM_region;	// ���͵� ����

	// ������
	public StudyMemberVO(int SM_id, int study_no_SM, int member_no_SM, String SM_title, String SM_sd, String SM_ed,
			String SM_notice, String SM_region) {
		super();
		this.SM_id = SM_id;
		this.study_no_SM = study_no_SM;
		this.member_no_SM = member_no_SM;
		this.SM_title = SM_title;
		this.SM_sd = SM_sd;
		this.SM_ed = SM_ed;
		this.SM_notice = SM_notice;
		this.SM_region = SM_region;
	}
	
	// �޼ҵ�(get,set)
	public int getSM_id() {
		return SM_id;
	}

	public void setSM_id(int SM_id) {
		this.SM_id = SM_id;
	}

	public int getStudy_no_SM() {
		return study_no_SM;
	}

	public void setStudy_no_SM(int study_no_SM) {
		this.study_no_SM = study_no_SM;
	}

	public int getMember_no_SM() {
		return member_no_SM;
	}

	public void setMember_no_SM(int member_no_SM) {
		this.member_no_SM = member_no_SM;
	}

	public String getSM_title() {
		return SM_title;
	}

	public void setSM_title(String SM_title) {
		this.SM_title = SM_title;
	}

	public String getSM_sd() {
		return SM_sd;
	}

	public void setSM_sd(String SM_sd) {
		this.SM_sd = SM_sd;
	}

	public String getSM_ed() {
		return SM_ed;
	}

	public void setSM_ed(String SM_ed) {
		this.SM_ed = SM_ed;
	}

	public String getSM_notice() {
		return SM_notice;
	}

	public void setSM_notice(String SM_notice) {
		this.SM_notice = SM_notice;
	}

	public String getSM_region() {
		return SM_region;
	}

	public void setSM_region(String SM_region) {
		this.SM_region = SM_region;
	}
}
