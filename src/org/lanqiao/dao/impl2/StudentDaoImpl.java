package org.lanqiao.dao.impl2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao2.IStudentDao;
import org.lanqiao.enity2.Student;
import org.lanqiao.util.DBUtil;

public class StudentDaoImpl implements IStudentDao {
	// 增加学生
	public boolean addStudent(Student stu) {
		String sql = "insert into student(STUDENTNO,STUDENTNAME,STUDENTAGE, GRADENAME) values(?,?,?,?)";
		Object[] os = { stu.getStudentNo(), stu.getStudentName(), stu.getStudentAge(), stu.getGradeName() };
		return DBUtil.executeAddOrUpdateOrDelete(sql, os);
	}

	// 根据学号删除学生
	public boolean deleteStudentByNo(int stuNo) {
		String sql = "delete from student where STUDENTNO = ?";
		Object[] os = { stuNo };
		return DBUtil.executeAddOrUpdateOrDelete(sql, os);
	}

	// 修改学生信息:将原来学号为stuNo的学生信息，修改为实体类stu中的包含信息
	public boolean updateStudent(Student stu, int stuNo) {
		String sql = "update student set STUDENTNO = ?,STUDENTNAME = ?,STUDENTAGE = ?,GRADENAME=?  where STUDENTNO = ? ";
		Object[] os = { stu.getStudentNo(), stu.getStudentName(), stu.getStudentAge(), stu.getGradeName(),stu.getStudentNo() };
		return DBUtil.executeAddOrUpdateOrDelete(sql, os);
	}

	// 根据学号，查询某一个学生
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
				// 将查到的学生信息，封装到stu对象中
				stu = new Student(sNo, sName, sAge, gName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 判断students集合是否为空
		return stu;
	}

	// 查询全部学生
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
				// 将查到的学生信息，封装到stu对象中
				Student stu = new Student(sNo, sName, sAge, gName);
				// 将封装好的stu对象，存放到List集合中
				students.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 判断students集合是否为空
		return students;
	}

	// 根据学号，判断某一个学生是否已经存在
	public boolean isExistByNo(int stuNo) {
		boolean isExist = false;
		Student stu = queryStudentByNo(stuNo);
		// 如果stu为null，说明查无此人，即此人不存在；否则说明已经存在此人
		isExist = (stu == null) ? false : true;
		return isExist;
	}

	public int getTotalCount() {
		String sql = "select count(*) from student ";
		return DBUtil.getTotalCount(sql);
	}

	// 获取第currentPage页的全部学生信息（每页显示pageSize条数据）
	// 通过执行分页SQL语句实现
	public List<Student> getStudentsListForCurrentPage(int currentPage, int pageSize) {
		String sql = "select * from " + "(" + "select rownum r,t.* "
				+ "from (select s.* from student s order by STUDENTNO asc ) t " + "where rownum<= ? )" + "where r>= ?";
		Object[] os = { currentPage * pageSize, (currentPage - 1) * pageSize + 1 };
		System.out.println("StudentDaoImpl:pageSize---"+pageSize);
		// 获取当前页的学生集合
		ResultSet rs = DBUtil.executeQuery(sql, os);
		List<Student> students = new ArrayList<Student>();
		try {
			while (rs.next()) {
				int sNo = rs.getInt("STUDENTNO");
				String sName = rs.getString("STUDENTNAME");
				int sAge = rs.getInt("STUDENTAGE");
				String gName = rs.getString("GRADENAME");
				// 将查到的学生信息，封装到stu对象中
				Student stu = new Student(sNo, sName, sAge, gName);
				// 将封装好的stu对象，存放到List集合中
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
