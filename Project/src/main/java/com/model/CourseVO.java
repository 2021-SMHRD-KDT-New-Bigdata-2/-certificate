package com.model;

public class CourseVO {
	// �ʵ����
	private int member_no_co;	// ȸ����ȣ
	private int lecture_no_co;	// �ΰ�����
	private String course_sd; // ������������
	private String course_comp; // ���Ῡ��
	private int course_no;	// ������ȣ
	
	// ������
	public CourseVO(int member_no_co, int lecture_no_co, String course_sd, String course_comp, int course_no) {
		super();
		this.member_no_co = member_no_co;
		this.lecture_no_co = lecture_no_co;
		this.course_sd = course_sd;
		this.course_comp = course_comp;
		this.course_no = course_no;
	}
	
	// �޼ҵ�(get,set)
	public int getMember_no_co() {
		return member_no_co;
	}

	public void setMember_no_co(int member_no_co) {
		this.member_no_co = member_no_co;
	}

	public int getLecture_no_co() {
		return lecture_no_co;
	}

	public void setLecture_no_co(int lecture_no_co) {
		this.lecture_no_co = lecture_no_co;
	}

	public String getCourse_sd() {
		return course_sd;
	}

	public void setCourse_sd(String course_sd) {
		this.course_sd = course_sd;
	}

	public String getCourse_comp() {
		return course_comp;
	}

	public void setCourse_comp(String course_comp) {
		this.course_comp = course_comp;
	}

	public int getCourse_no() {
		return course_no;
	}

	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}
}
