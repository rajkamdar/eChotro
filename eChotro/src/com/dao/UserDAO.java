package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.bean.UserBean;
import com.util.SessionFactoryUtils;

public class UserDAO {

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

	public UserBean authenticateUser(String email, String password) {
		Session session = SessionFactoryUtils.getSession();
		Transaction transaction = session.beginTransaction();
		UserBean userBean = null;
		transaction.begin();
		try {
			Query query = session
					.createQuery(" from user_master where email=? and password=?");
			query.setString(0, email);
			query.setString(1, password);
			userBean = (UserBean) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return userBean;
	}

	public boolean isExists(String email) {
		Session session = SessionFactoryUtils.getSession();
		Transaction transaction = session.beginTransaction();
		UserBean userBean = null;
		transaction.begin();
		try {
			Query query = session
					.createQuery(" from user_master where email=?");
			query.setString(0, email);
			userBean = (UserBean) query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return userBean == null ? false : true;
	}

	public static void main(String[] args) throws Exception {

		UserBean bean = new UserBean();
		Session session = SessionFactoryUtils.getSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		session.save(bean);
		transaction.commit();
	}

}
