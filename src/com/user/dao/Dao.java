package com.user.dao;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.user.bean.Bean;
import com.user.utils.DBUtils;

public class Dao {
	
	public  static boolean insertUser(Bean b) {
		System.out.println(b.getSex());
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="insert into user values(?,?,?)";
		try {
			int i=qr.update(sql,b.getName(),b.getId(),b.getSex());
			if(i>0) return true;
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	} 
	public  static boolean updateUser(Bean b) {
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="update user set name=?,sex=? where id=?";
		try {
			int i=qr.update(sql,b.getName(),b.getSex(),b.getId());
			if(i>0) return true;
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	} 
	
	
	public  static boolean deleteUser(Bean b) {
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="delete from user where id=?";
		try {
			int i=qr.update(sql,b.getId());
			if(i>0) return true;
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	} 
	
	public  static List<Bean> queryUser() {
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="select * from user";
		try {
			List<Bean> list =qr.query(sql, new BeanListHandler<Bean>(Bean.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
	
	public Dao() {
		// TODO Auto-generated constructor stub
	}

}
