package com.developers;

public class App {
 public static void main(String[] args) {
	Movie m =new Movie();
	m.setId(1);
	m.setName("Logan");
	m.setRatings(8);
	m.setSummery("Action");
	
	new JDBCImpl().save(m);
}
}
