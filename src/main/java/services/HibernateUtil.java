package services;

import org.hibernate.SessionFactory;

public class HibernateUtil
{
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
