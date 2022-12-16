package com.web.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConfigSqlSessionFactory {

	private static SqlSessionFactory sessionFactory;
	static {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
