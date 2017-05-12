package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.bean.UtilityBean;
import com.util.SessionFactoryUtils;

public class UtilityDAO {
	public boolean incrementCount() {
		Session session = SessionFactoryUtils.getSession();
		Transaction transaction = session.beginTransaction();

		transaction.begin();
		try {
			Query query= session.createQuery("update utility_table set visitedCount=visitedCount+1 where 1=1");
			int i=query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
		return true;
	}
	
	public boolean incrementCount(UtilityBean utilityBean) {
		Session session = SessionFactoryUtils.getSession();
		Transaction transaction = session.beginTransaction();

		transaction.begin();
		try {
			session.save(utilityBean);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

}
