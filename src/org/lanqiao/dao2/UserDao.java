package org.lanqiao.dao2;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.lanqiao.enity2.User;
import org.lanqiao.util.DBUtil;

public class UserDao {
	public User findUserByUsername(String username) {
		String sql = "select * from userInformation where username=?";
		Object[] os = {username};
		ResultSet resultSet = DBUtil.executeQuery(sql, os);
		try {
			

			while (resultSet.next()) {
				String uname = resultSet.getString(1);
				String password = resultSet.getString(2);
				User user = new User(uname, password);
				return user;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(resultSet, null, null);
		}

		return null;
	}
}
