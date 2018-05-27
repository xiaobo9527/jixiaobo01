package org.lanqiao.dao.impl2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao2.IStudentDao;
import org.lanqiao.enity2.Student;
import org.lanqiao.util.DBUtil;

public class StudentDaoImpl implements IStudentDao {
	// ����ѧ��
	public boolean addStudent(Student stu) {
		String sql = "insert into student(STUDENTNO,STUDENTNAME,STUDENTAGE, GRADENAME) values(?,?,?,?)";
		Object[] os = { stu.getStudentNo(), stu.getStudentName(), stu.getStudentAge(), stu.getGradeName() };
		return DBUtil.executeAddOrUpdateOrDelete(sql, os);
	}

	// ����ѧ��ɾ��ѧ��
	public boolean deleteStudentByNo(int stuNo) {
		String sql = "delete from student where STUDENTNO = ?";
		Object[] os = { stuNo };
		return DBUtil.executeAddOrUpdateOrDelete(sql, os);
	}

	// �޸�ѧ����Ϣ:��ԭ��ѧ��ΪstuNo��ѧ����Ϣ���޸�Ϊʵ����stu�еİ�����Ϣ
	public boolean updateStudent(Student stu, int stuNo) {
		String sql = "update student set STUDENTNO = ?,STUDENTNAME = ?,STUDENTAGE = ?,GRADENAME=?  where STUDENTNO = ? ";
		Object[] os = { stu.getStudentNo(), stu.getStudentName(), stu.getStudentAge(), stu.getGradeName(),stu.getStudentNo() };
		return DBUtil.executeAddOrUpdateOrDelete(sql, os);
	}

	// ����ѧ�ţ���ѯĳһ��ѧ��
	public Student queryStudentByNo(int stuNo) {
		String sql = "select STUDENTNO,STUDENTNAME,STUDENTAGE,GRADENAME from student where STUDENTNO = ? ";
		Object[] os = { stuNo };
		Student stu = null;
		try {
			ResultSet rs = DBUtil.executeQuery(sql, os);
			if (rs.next()) {
				int sNo = rs.getInt("STUDENTNO");
				String sName = rs.getString("STUDENTNAME");
				int sAge = rs.getInt("STUDENTAGE");
				String gName = rs.getString("GRADENAME");
				// ���鵽��ѧ����Ϣ����װ��stu������
				stu = new Student(sNo, sName, sAge, gName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// �ж�students�����Ƿ�Ϊ��
		return stu;
	}

	// ��ѯȫ��ѧ��
	public List<Student> queryAllStudents() {
		String sql = "select STUDENTNO,STUDENTNAME,STUDENTAGE,GRADENAME from student ";
		Object[] os = null;
		List<Student> students = new ArrayList<Student>();
		try {
			ResultSet rs = DBUtil.executeQuery(sql, os);
			while (rs.next()) {
				int sNo = rs.getInt("STUDENTNO");
				String sName = rs.getString("STUDENTNAME");
				int sAge = rs.getInt("STUDENTAGE");
				String gName = rs.getString("GRADENAME");
				// ���鵽��ѧ����Ϣ����װ��stu������
				Student stu = new Student(sNo, sName, sAge, gName);
				// ����װ�õ�stu���󣬴�ŵ�List������
				students.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// �ж�students�����Ƿ�Ϊ��
		return students;
	}

	// ����ѧ�ţ��ж�ĳһ��ѧ���Ƿ��Ѿ�����
	public boolean isExistByNo(int stuNo) {
		boolean isExist = false;
		Student stu = queryStudentByNo(stuNo);
		// ���stuΪnull��˵�����޴��ˣ������˲����ڣ�����˵���Ѿ����ڴ���
		isExist = (stu == null) ? false : true;
		return isExist;
	}

	public int getTotalCount() {
		String sql = "select count(*) from student ";
		return DBUtil.getTotalCount(sql);
	}

	// ��ȡ��currentPageҳ��ȫ��ѧ����Ϣ��ÿҳ��ʾpageSize�����ݣ�
	// ͨ��ִ�з�ҳSQL���ʵ��
	public List<Student> getStudentsListForCurrentPage(int currentPage, int pageSize) {
		String sql = "select * from " + "(" + "select rownum r,t.* "
				+ "from (select s.* from student s order by STUDENTNO asc ) t " + "where rownum<= ? )" + "where r>= ?";
		Object[] os = { currentPage * pageSize, (currentPage - 1) * pageSize + 1 };
		System.out.println("StudentDaoImpl:pageSize---"+pageSize);
		// ��ȡ��ǰҳ��ѧ������
		ResultSet rs = DBUtil.executeQuery(sql, os);
		List<Student> students = new ArrayList<Student>();
		try {
			while (rs.next()) {
				int sNo = rs.getInt("STUDENTNO");
				String sName = rs.getString("STUDENTNAME");
				int sAge = rs.getInt("STUDENTAGE");
				String gName = rs.getString("GRADENAME");
				// ���鵽��ѧ����Ϣ����װ��stu������
				Student stu = new Student(sNo, sName, sAge, gName);
				// ����װ�õ�stu���󣬴�ŵ�List������
				students.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, DBUtil.createPreparedStatement(sql, os), DBUtil.getConnection());
		}
		return students;
	}

}
