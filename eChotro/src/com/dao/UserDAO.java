package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.bean.UserBean;
import com.util.SessionFactoryUtils;

public class UserDAO {

	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public boolean addUser(UserBean userBean) {
		Session session = SessionFactoryUtils.getSession();
		Transaction transaction = session.beginTransaction();

		transaction.begin();
		try {
			session.save(userBean);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
		return true;
	}
	public UserBean authenticateUser(String email,String password) {
		Session session = SessionFactoryUtils.getSession();
		Transaction transaction = session.beginTransaction();
		UserBean userBean;
		transaction.begin();
		try {
			 userBean=(UserBean) session.createQuery(" from user_master where email="+email+" and password="+password).list().get(0);
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
		return userBean;
	}

	
	public static void main(String[] args) throws Exception {
		
		UserBean bean=new UserBean();
		Session session=SessionFactoryUtils.getSession();
		 Transaction transaction= session.beginTransaction();
		transaction.begin(); 	
		 session.save(bean);
		 transaction.commit();
	}
	

}
