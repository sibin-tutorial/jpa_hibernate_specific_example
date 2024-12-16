package edu.raj.dev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//Find a row by ID
public class Main3 {
	public static void main(String[] args) {

		// try with resource
		try (SessionFactory sessionFactory = HibernateUtil.getSession();
				Session session = sessionFactory.openSession();) {

			Transaction tx = session.beginTransaction();

			Employee emp = session.find(Employee.class, 3);

			System.out.println("Name: " + emp.getName() + " Salary: " + emp.getSalary());

			tx.commit();
		} catch (Exception e) {
			System.out.print(e);
		}

	}
}
