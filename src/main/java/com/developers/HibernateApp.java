package com.developers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApp {
// First Hibernate Code
	public static void main(String[] args) {
		// Reading Data from DB using Hibernate
		/*Movie m = new Movie();
		m.setId(1);
		m.setName("Logan");
		m.setRating(9);
		m.setSummery("Action");*/
		
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("myPersistanceUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Movie m=new Movie();
		
		em.remove(m);
//		m = em.find(Movie.class, 1);
//		m = em.getReference(Movie.class, 10);
		System.out.println(m);
		
		
		/*
		Configuration con= new Configuration();
		con.configure("persistence.xml");
		SessionFactory s=con.buildSessionFactory();
		Session session=s.getCurrentSession();
		session.save(object);*/
		
		tx.commit();
	}
}