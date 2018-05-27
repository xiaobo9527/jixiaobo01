package org.lanqiao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil  {
	// 属性定义及初始化赋值
	public static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	public static final String USERNAME = "scott";
	public static final String PASSWORD = "tiger";
	static Connection connection = null;
	static PreparedStatement preparedStatement = null;

	// 通用的，获取数据库连接对象的方法
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

	// 通用的，获取PreparedStatement对象的方法
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

	// 通用的，关闭访问数据库相关对象的方法(注意PreparedStatement继承自Statement)
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

	// 通用的增加、删除、修改方法
	public static boolean executeAddOrUpdateOrDelete(String sql, Object[] os) {
		// flag用来标记是否增加成功，若增加成功则返回true，若增加失败则返回false
		 boolean flag = true;
		try {
			// 获取Statement对象
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

	// 通用的查询方法，返回查询的结果集ResultSet对象
	public static ResultSet executeQuery(String sql, Object[] os) {
		ResultSet rs = null;
		try {
			preparedStatement = createPreparedStatement(sql, os);
		
			rs = preparedStatement.executeQuery();
		} catch (SQLException e) {
			System.out.println("SQLException：" + e);
		} catch (Exception e) {
			System.out.println("查询发生异常：" + e);
		}
		return rs;
	}
	 // 查询数据总数
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
