package org.lanqiao.dao2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.enity2.Student;

//��ʵ������ɾ�Ĳ�����ݿ��������
public class StudentDao {
	public static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	public static final String USERNAME = "scott";
	public static final String PASSWORD = "tiger";

	// ����ѧ����Ϣ
	public boolean addStudent(Student stu) {
		// ��flag������Ƿ����ӳɹ�
		boolean flag = true;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// ��������
			Class.forName(DRIVER_NAME);
			// ��ȡ����
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into student(studentNo,studentName,studentAge,gradeName) values(?,?,?,?)";
			// ����preparedStatement���󣬽���������sql��䷢�͵����ݿ�
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, stu.getStudentNo());
			preparedStatement.setString(2, stu.getStudentName());
			preparedStatement.setInt(3, stu.getStudentAge());
			preparedStatement.setString(4, stu.getGradeName());

			// ִ��sql���
			int result = preparedStatement.executeUpdate();

			// �жϽ��sql���ִ�еĽ��������0��ʾ���ӳɹ�����֮��ʾ����ʧ��
			if (result > 0) {
				System.out.println("StudentDao:���ӳɹ�");
			} else {
				System.out.println("StudentDao:����ʧ��");
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

	// ����ѧ�Ų�ѯĳһѧ��
	public Student queryStudentByNo(int stuNo) {
		Student stu = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// ��������
			Class.forName(DRIVER_NAME);
			// ��ȡ����
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "select studentNo,studentName,studentAge,gradeName from student where studentNo=?";

			// ����preparedStatement���󣬽���������sql��䷢�͵����ݿ�
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, stuNo);
			// ִ��sql���
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int sNo = resultSet.getInt(1);
				String sName = resultSet.getString(2);
				int sAge = resultSet.getInt(3);
				String gNane = resultSet.getString(4);
				// ����ѯ����ѧ�������װ��Studentʵ����
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

	// ����ѧ���ж�ĳһѧ���Ƿ��Ѵ���
	public boolean isExitsByNo(int stuNo) {
		boolean isExits = false;
		//Ҫ�жϸ�ѧ���Ƿ���ڣ���Ҫ�Ȳ�ѯ��ѧ���Ƿ���ڣ����ø����еĸ���ѧ�Ų�ѯѧ������
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

	// ����ѧ�ţ�ɾ��һ��ѧ��
	public boolean deleteStudentByNo(int stuNo) {
		// ����flag���ѧ���Ƿ�ɾ���ɹ�
		boolean flag = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// ��ȡ����
			Class.forName(DRIVER_NAME);
			// ��ȡ����
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "delete from student where studentNo=?";
			// ����preparedStatement���󣬽���������sql��䷢�͵����ݿ�
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, stuNo);
			// ִ��sql���
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

	// �޸�ѧ������Ϣ������ѧ����ѧ�ţ���ѧ����Ϣ�޸�Ϊʵ����stu�еİ�����Ϣ
	public boolean updateStudent(Student stu, int stuNo) {
		// flag��ʾ�޸�ѧ����Ϣ�Ƿ�ɹ�
		boolean flag = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// ��������
			Class.forName(DRIVER_NAME);
			// ��ȡ����
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// �޸�ѧ����sql���
			String sql = "update student set studentNo=?,studentName=?,studentAge=?,gradeName=? where studentNo=?";
			// ����PreparedStatement���󣬽����ݻ���sql��䴫�����ݿ�
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, stu.getStudentNo());
			preparedStatement.setString(2, stu.getStudentName());
			preparedStatement.setInt(3, stu.getStudentAge());
			preparedStatement.setString(4, stu.getGradeName());
			preparedStatement.setInt(5, stu.getStudentNo());
			// ִ��sql���
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

	// ��ѯȫ��ѧ��
	public List<Student> queryAllStudents() {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> students = new ArrayList<Student>();

		try {
			// ��������
			Class.forName(DRIVER_NAME);
			// ��ȡ����
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from student";
			// ����preparedStatement���󣬽�sql��䷢�͵����ݿ�
			preparedStatement = connection.prepareStatement(sql);
			// ִ��sql���
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int sNo = resultSet.getInt(1);
				String sName = resultSet.getString(2);
				int sAge = resultSet.getInt(3);
				String gName = resultSet.getString(4);
				// ���鵽��ѧ����Ϣ����װ��stu������
				Student stu = new Student(sNo, sName, sAge, gName);
				// ��stu�����ѧ����Ϣ���뼯����
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
