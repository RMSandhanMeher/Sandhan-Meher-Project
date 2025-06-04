package com.java.hib;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
 
public class EmployShowMain {
	public static void main(String[] args) {
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("connected");
		Session session = sf.openSession();
		Transaction transaction=session.beginTransaction();
		Employ emp1 = new Employ(6511, "John Doe",Gender.MALE, "IT", "Developer", 55000.00);
		Employ emp2 = new Employ(6512, "John Doe",Gender.MALE, "IT", "Developer", 55000.00);
		session.save(emp1);
		session.save(emp1);
		transaction.commit();
	}
}