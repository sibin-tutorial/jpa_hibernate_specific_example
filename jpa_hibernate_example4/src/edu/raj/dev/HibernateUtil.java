package edu.raj.dev;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory getSession() {

		try {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Employee.class).buildSessionFactory();

			return sessionFactory;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
