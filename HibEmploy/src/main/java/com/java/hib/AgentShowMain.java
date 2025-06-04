package com.java.hib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class AgentShowMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory= new AnnotationConfiguration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		Query qry=session.createQuery("from Agent");
		List<Agent> agentList=qry.list();
		for (Agent agent : agentList) {
			System.out.println(agent);
		}
	}
}
