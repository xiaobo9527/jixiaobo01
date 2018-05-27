package org.lanqiao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil  {
	// ���Զ��弰��ʼ����ֵ
	public static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	public static final String USERNAME = "scott";
	public static final String PASSWORD = "tiger";
	static Connection connection = null;
	static PreparedStatement preparedStatement = null;

	// ͨ�õģ���ȡ���ݿ����Ӷ���ķ���
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	// ͨ�õģ���ȡPreparedStatement����ķ���
	public static PreparedStatement createPreparedStatement(String sql, Object[] os) {
		try {
			preparedStatement = getConnection().prepareStatement(sql);
			if (os != null) {
				for (int i = 0; i < os.length; i++) {
					preparedStatement.setObject(i + 1, os[i]);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	// ͨ�õģ��رշ������ݿ���ض���ķ���(ע��PreparedStatement�̳���Statement)
	public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
		try {
			if (resultSet != null)
				resultSet.close();
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ͨ�õ����ӡ�ɾ�����޸ķ���
	public static boolean executeAddOrUpdateOrDelete(String sql, Object[] os) {
		// flag��������Ƿ����ӳɹ��������ӳɹ��򷵻�true��������ʧ���򷵻�false
		 boolean flag = true;
		try {
			// ��ȡStatement����
			preparedStatement = createPreparedStatement(sql, os);
			preparedStatement.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			closeAll(null, preparedStatement, connection);
		}
		return flag;
	}

	// ͨ�õĲ�ѯ���������ز�ѯ�Ľ����ResultSet����
	public static ResultSet executeQuery(String sql, Object[] os) {
		ResultSet rs = null;
		try {
			preparedStatement = createPreparedStatement(sql, os);
		
			rs = preparedStatement.executeQuery();
		} catch (SQLException e) {
			System.out.println("SQLException��" + e);
		} catch (Exception e) {
			System.out.println("��ѯ�����쳣��" + e);
		}
		return rs;
	}
	 // ��ѯ��������
	public static int getTotalCount(String sql) {
		int count = -1;
		ResultSet rs = null;
		try {
			preparedStatement = createPreparedStatement(sql, null);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, preparedStatement, connection);
		}
		return count;

	}
}
