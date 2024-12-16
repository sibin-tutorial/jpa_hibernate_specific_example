package edu.raj.dev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//Update data
public class Main4 {

	public static void main(String[] args) {

		try (SessionFactory sessionFactory = HibernateUtil.getSession();
				Session session = sessionFactory.openSession();) {

			Transaction tx = session.beginTransaction();
			Employee emp = session.find(Employee.class, 2);

			emp.setName("Irfan");

			// Update
			session.merge(emp);
			System.out.println("Data updated");
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
