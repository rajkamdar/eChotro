package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.cfg.Configuration;

import com.dao.UtilityDAO;
import com.model.bean.UtilityBean;
import com.util.SessionFactoryUtils;

@WebListener
public class ContextListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

		SessionFactoryUtils.setSessionFactory(null);

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		SessionFactoryUtils.setSessionFactory(new Configuration().configure(
				"com/resource/hibernate.cfg.xml").buildSessionFactory());
		UtilityBean utilityBean=new UtilityBean();
		utilityBean.setVisitedCount(0);
		new UtilityDAO().incrementCount(utilityBean);

	}

}
