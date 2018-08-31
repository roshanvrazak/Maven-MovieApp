package com.developers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCImpl {
	public void save(Movie m) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CapsV3_db", "root", "root");
			String sql = "insert into movies_info values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m.getId());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getSummery());
			pstmt.setInt(4, m.getRatings());

			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("Data Inserted");
			} else {
				System.out.println("Failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
