package org.lanqiao.enity2;
	//学生的实体类
public class Student {
	private int studentNo; // 学号
	private String studentName; // 姓名
	private int studentAge; // 年龄
	private String gradeName; // 年级

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
