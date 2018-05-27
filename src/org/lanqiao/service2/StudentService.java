package org.lanqiao.service2;

import java.util.List;

import org.lanqiao.dao.impl2.StudentDaoImpl;
import org.lanqiao.enity2.Student;

//业务逻辑层--->实现带逻辑的“增删改查”操作，本质是对数据访问层的多个方法进行了“组装”
public class StudentService {
	// 业务逻辑层依赖于数据访问层
	StudentDaoImpl stuDao = new StudentDaoImpl();

	// 增加学生
	public boolean addStudent(Student stu) {
		//增加之前需要先进行判断该学生是否已经存在
		if (stuDao.isExistByNo(stu.getStudentNo())) {
			System.out.println("此人已存在，不能重复增加");
			return false;
		}
		// 调用访问层的方法，实现学生的增加
		return stuDao.addStudent(stu);
	}

	// 根据学号，删除学生
	public boolean deleteStudentByNo(int stuNo) {
		// 删除之前，先判断该学生是否存在，若不存在则无法删除
		if (stuDao.isExistByNo(stuNo) == false) {
			// isExitsByNo返回值为false表示该学生不存在
			System.out.println("提示---StudentService:该学生不存在，删除失败");
			return false;
		} else {

			// 调用数据访问层，实现删除功能
			return stuDao.deleteStudentByNo(stuNo);
		}
	}
	
	// 修改学生信息:将原来学号为stuNo的学生信息，修改为实体类stu中的包含信息
	public boolean updateStudent(Student stu,int stuNo) {
		//修改之前先判断：判断该学生是否存在，若不存在，修改失败
		if(stuDao.isExistByNo(stuNo) == false) {
			System.out.println("该学生不存在，修改失败");
			return false;
		}else {
			return stuDao.updateStudent(stu, stuNo);
			
		}
		
	}
	//查询全部学生
		public List<Student> queryAllStudent(){
			
			//查询操作一般不用判断，直接调用数据访问层的方法即可
			return stuDao.queryAllStudents();
		}
		
		//根据学号，判断某一学生是否存在
		public boolean isExistByNo(int stuNo) {
			
			//直接调用数据访问层的方法进行判断
			return stuDao.isExistByNo(stuNo);
			
		}
		
		//根据学号，查询某一个学生
		public Student queryStudengByNo(int stuNo) {
			//查询操作一般不用判断，直接调用数据访问层的方法即可
			return stuDao.queryStudentByNo(stuNo);
		}
}
