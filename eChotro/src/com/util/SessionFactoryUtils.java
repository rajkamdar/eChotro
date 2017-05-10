package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtils {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null)
			sessionFactory=new Configuration().configure(
					"com/resource/hibernate.cfg.xml").buildSessionFactory();
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactoryUtils.sessionFactory = sessionFactory;
	}
	
	public static Session getSession()
	{
		return getSessionFactory().openSession();
	}

}
