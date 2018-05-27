package org.lanqiao.dao2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.enity2.Student;

//对实体类增删改查的数据库基本操作
public class StudentDao {
	public static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	public static final String USERNAME = "scott";
	public static final String PASSWORD = "tiger";

	// 增加学生信息
	public boolean addStudent(Student stu) {
		// 用flag来标记是否增加成功
		boolean flag = true;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// 加载驱动
			Class.forName(DRIVER_NAME);
			// 获取连接
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into student(studentNo,studentName,studentAge,gradeName) values(?,?,?,?)";
			// 创建preparedStatement对象，将参数化的sql语句发送到数据库
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, stu.getStudentNo());
			preparedStatement.setString(2, stu.getStudentName());
			preparedStatement.setInt(3, stu.getStudentAge());
			preparedStatement.setString(4, stu.getGradeName());

			// 执行sql语句
			int result = preparedStatement.executeUpdate();

			// 判断结果sql语句执行的结果，大于0表示增加成功，反之表示增加失败
			if (result > 0) {
				System.out.println("StudentDao:增加成功");
			} else {
				System.out.println("StudentDao:增加失败");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				flag = false;
			}

		}

		return flag;
	}

	// 根据学号查询某一学生
	public Student queryStudentByNo(int stuNo) {
		Student stu = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// 记载驱动
			Class.forName(DRIVER_NAME);
			// 获取连接
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "select studentNo,studentName,studentAge,gradeName from student where studentNo=?";

			// 创建preparedStatement对象，将参数化的sql语句发送到数据库
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, stuNo);
			// 执行sql语句
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int sNo = resultSet.getInt(1);
				String sName = resultSet.getString(2);
				int sAge = resultSet.getInt(3);
				String gNane = resultSet.getString(4);
				// 将查询到的学生对象封装到Student实体中
				stu = new Student(sNo, sName, sAge, gNane);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stu;
	}

	// 根据学号判断某一学生是否已存在
	public boolean isExitsByNo(int stuNo) {
		boolean isExits = false;
		//要判断该学生是否存在，需要先查询该学生是否存在：调用该类中的根据学号查询学生方法
		Student stu = this.queryStudentByNo(stuNo);
		// if (stu == null) {
		// isExits = false;
		// } else {
		// isExits = true;
		// }
		// return isExits;

		isExits = (stu == null) ? false : true;
		return isExits;
	}

	// 根据学号，删除一个学生
	public boolean deleteStudentByNo(int stuNo) {
		// 设置flag标记学生是否删除成功
		boolean flag = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// 获取连接
			Class.forName(DRIVER_NAME);
			// 获取连接
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "delete from student where studentNo=?";
			// 创建preparedStatement对象，将参数化的sql语句发送到数据库
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, stuNo);
			// 执行sql语句
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				flag = false;
			}
		}
		return flag;
	}

	// 修改学生的信息：根据学生的学号，将学生信息修改为实体类stu中的包含信息
	public boolean updateStudent(Student stu, int stuNo) {
		// flag表示修改学生信息是否成功
		boolean flag = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// 记载驱动
			Class.forName(DRIVER_NAME);
			// 获取连接
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// 修改学生的sql语句
			String sql = "update student set studentNo=?,studentName=?,studentAge=?,gradeName=? where studentNo=?";
			// 创建PreparedStatement对象，将数据化的sql语句传入数据库
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, stu.getStudentNo());
			preparedStatement.setString(2, stu.getStudentName());
			preparedStatement.setInt(3, stu.getStudentAge());
			preparedStatement.setString(4, stu.getGradeName());
			preparedStatement.setInt(5, stu.getStudentNo());
			// 执行sql语句
			preparedStatement.executeQuery();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			flag = false;
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				flag = false;
			}
		}

		return flag;
	}

	// 查询全部学生
	public List<Student> queryAllStudents() {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> students = new ArrayList<Student>();

		try {
			// 记载驱动
			Class.forName(DRIVER_NAME);
			// 获取连接
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from student";
			// 创建preparedStatement对象，将sql语句发送到数据库
			preparedStatement = connection.prepareStatement(sql);
			// 执行sql语句
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int sNo = resultSet.getInt(1);
				String sName = resultSet.getString(2);
				int sAge = resultSet.getInt(3);
				String gName = resultSet.getString(4);
				// 将查到的学生信息，封装到stu对象中
				Student stu = new Student(sNo, sName, sAge, gName);
				// 将stu对象的学生信息存入集合中
				students.add(stu);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}
}
