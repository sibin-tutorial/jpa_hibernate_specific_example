package edu.raj.dev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//Insert data into database
public class Main1 {

	public static void main(String[] args) {

		try (SessionFactory sessionFactory = HibernateUtil.getSession();
				Session session = sessionFactory.openSession();) {

			Employee emp1 = new Employee("Athira", 50000.0);
			Employee emp2 = new Employee("Sibin", 500.0);
			Employee emp3 = new Employee("Anu", 2500.0);

			// Begin transaction
			Transaction transaction = session.beginTransaction();

			session.persist(emp1);
			session.persist(emp2);
			session.persist(emp3);

			System.out.println("Data successfully inserted");

			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);

		}
	}
}
