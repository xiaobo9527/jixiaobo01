package org.lanqiao.enity2;
	//ѧ����ʵ����
public class Student {
	private int studentNo; // ѧ��
	private String studentName; // ����
	private int studentAge; // ����
	private String gradeName; // �꼶

	public Student() {

	}

	public Student(int studentNo, String studentName, int studentAge, String gradeName) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.gradeName = gradeName;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String stidentName) {
		this.studentName = stidentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

}
