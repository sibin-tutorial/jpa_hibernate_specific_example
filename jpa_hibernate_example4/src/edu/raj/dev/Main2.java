package edu.raj.dev;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//Fetch all data from employee_table
public class Main2 {

	public static void main(String[] args) {

		try (SessionFactory sessionFactory = HibernateUtil.getSession();
				Session session = sessionFactory.openSession();) {

			Transaction tx = session.beginTransaction();

			// HQL (Hibernate query language)
			String str = "FROM Employee";
			List<Employee> empList = session.createQuery(str, Employee.class).getResultList();

			for (Employee emp : empList) {
				System.out.println("Employee name: " + emp.getName() + " Salary: " + emp.getSalary());
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
