package org.lanqiao.dbutil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;


public class DBCPDemo {
	
	
	
	//a. 基于BasicDataSource的手动编码方式
	//获取DBCP数据源对象
//	public static DataSource getSourceWithDBCP() {
//		//配置数据源中的数据库信息
//		BasicDataSource  basicDataSource = new BasicDataSource();
//		basicDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
//		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCl");
//		basicDataSource.setUsername("scott");
//		basicDataSource.setPassword("scott");
//		
//		//设置数据源中连接池的信息
//		basicDataSource.setInitialSize(20);
//		basicDataSource.setMaxIdle(2);
//		return basicDataSource;
//	}
//	
//	
//	//测试DBCP数据源
//	public static void main(String[] args) {
//		DataSource ds = getSourceWithDBCP();
//		try {
//			Connection conn = ds.getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	
	
	//b. 基于BasicDataSourceFactory的配置文件方式
	//	<1>创建并编写配置文件
	//	创建配置文件：
	//	在src上点击鼠标右键→ New→ File→ 输入dbcpconfig.properties→ Finish
	// <2>获取数据源对象
	public static DataSource getDataSourceWithDBCPByProperties() {
		DataSource basicDataSource  = null;
		//创建一个配置文件props对象
		Properties props = new Properties();
		//将配置文件读取到输入流中
		InputStream input = new DBCPDemo().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
		try {
			//将配置文件中的信息，从输入流加载到props中
			props.load(input);
			//根据props中的配置信息，创建数据源对象
			basicDataSource = BasicDataSourceFactory.createDataSource(props);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return basicDataSource;
	}
	//测试DBCP数据源
	public static void main(String[] args) {
		DataSource ds = getDataSourceWithDBCPByProperties();
		try {
			Connection connection = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
