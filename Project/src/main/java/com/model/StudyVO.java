package com.model;

public class StudyVO {
	// �ʵ����
	private int study_no;	// ����
	private String study_name; // ���͵��
	private String study_begin;	// ��������
	private String study_end; // ��������
	private String study_sub;	// ���͵����
	private String study_place; // ���
	private String study_week;	// ����
	private String study_time; // �ð�
	
	// ������
	public StudyVO(int study_no, String study_name, String study_begin, String study_end, String study_sub,
			String study_place, String study_week, String study_time) {
		super();
		this.study_no = study_no;
		this.study_name = study_name;
		this.study_begin = study_begin;
		this.study_end = study_end;
		this.study_sub = study_sub;
		this.study_place = study_place;
		this.study_week = study_week;
		this.study_time = study_time;
	}
	
	// �޼ҵ�(get,set)
	public int getStudy_no() {
		return study_no;
	}

	public void setStudy_no(int study_no) {
		this.study_no = study_no;
	}

	public String getStudy_name() {
		return study_name;
	}

	public void setStudy_name(String study_name) {
		this.study_name = study_name;
	}

	public String getStudy_begin() {
		return study_begin;
	}

	public void setStudy_begin(String study_begin) {
		this.study_begin = study_begin;
	}

	public String getStudy_end() {
		return study_end;
	}

	public void setStudy_end(String study_end) {
		this.study_end = study_end;
	}

	public String getStudy_sub() {
		return study_sub;
	}

	public void setStudy_sub(String study_sub) {
		this.study_sub = study_sub;
	}

	public String getStudy_place() {
		return study_place;
	}

	public void setStudy_place(String study_place) {
		this.study_place = study_place;
	}

	public String getStudy_week() {
		return study_week;
	}

	public void setStudy_week(String study_week) {
		this.study_week = study_week;
	}

	public String getStudy_time() {
		return study_time;
	}

	public void setStudy_time(String study_time) {
		this.study_time = study_time;
	}

	
}
