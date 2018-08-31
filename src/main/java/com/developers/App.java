package com.developers;

public class App {
	public static void main(String[] args) {
		Movie m = new Movie();
		m.setId(1);
		m.setName("Logan");
		m.setRating(8);
		m.setSummery("Action");

		// to save movie object in to DB
		new JDBCImpl().save(m);

		// to print movie obj to console
		// JDBCImpl db=new JDBCImpl();
		// System.out.println(db.getMovie(1));
	}
}
