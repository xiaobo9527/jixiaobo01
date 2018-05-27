package org.lanqiao.dbutil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;


public class DBCPDemo {
	
	
	
	//a. ����BasicDataSource���ֶ����뷽ʽ
	//��ȡDBCP����Դ����
//	public static DataSource getSourceWithDBCP() {
//		//��������Դ�е����ݿ���Ϣ
//		BasicDataSource  basicDataSource = new BasicDataSource();
//		basicDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
//		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCl");
//		basicDataSource.setUsername("scott");
//		basicDataSource.setPassword("scott");
//		
//		//��������Դ�����ӳص���Ϣ
//		basicDataSource.setInitialSize(20);
//		basicDataSource.setMaxIdle(2);
//		return basicDataSource;
//	}
//	
//	
//	//����DBCP����Դ
//	public static void main(String[] args) {
//		DataSource ds = getSourceWithDBCP();
//		try {
//			Connection conn = ds.getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	
	
	//b. ����BasicDataSourceFactory�������ļ���ʽ
	//	<1>��������д�����ļ�
	//	���������ļ���
	//	��src�ϵ������Ҽ��� New�� File�� ����dbcpconfig.properties�� Finish
	// <2>��ȡ����Դ����
	public static DataSource getDataSourceWithDBCPByProperties() {
		DataSource basicDataSource  = null;
		//����һ�������ļ�props����
		Properties props = new Properties();
		//�������ļ���ȡ����������
		InputStream input = new DBCPDemo().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
		try {
			//�������ļ��е���Ϣ�������������ص�props��
			props.load(input);
			//����props�е�������Ϣ����������Դ����
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
	//����DBCP����Դ
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
