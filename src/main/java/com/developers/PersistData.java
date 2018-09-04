package com.developers;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistData {

	// Persisting data into DB using Hibernate
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Movie id:");
		int id = Integer.parseInt(sc.next());

		System.out.println("Enter Movie Name:");
		String nam = sc.next();
		

		System.out.println("Enter Movie Rating:");
		int rat = Integer.parseInt(sc.next());

		System.out.println("Enter Movie Summery:");
		String sum = sc.next();

		Movie m = new Movie();
		m.setId(id);
		m.setName(nam);
		m.setRating(rat);
		m.setSummery(sum);

		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(m);
		
		//em.persist(m);
/*		Since we are altering the object present in PERSISTENCE CONTEXT , it automatically updates Object in the DB
		m.setSummery("Perseistance Context Summery");*/
//		System.out.println(m);
		
		
		System.out.println("Data Inserted !!!");
		tx.commit();
	}
}
