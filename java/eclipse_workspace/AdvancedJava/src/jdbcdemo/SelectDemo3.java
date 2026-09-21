/**
 * Author :sushank2
 * Date :13-Jul-2026
 * Time :12:09:33 pm
 * Email : saisushankindroji1476@gmail.com
 */

package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo3 {

	// Database credentials
	private static final String URL = "jdbc:mysql://localhost:3306/classicmodels";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL Driver Loaded Successfully.");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connected to Database Successfully.");

			stmt = conn.createStatement();

			String sql = "SELECT productCode, productName, productLine, quantityInStock FROM products ORDER BY productLine";

			rs = stmt.executeQuery(sql);

			System.out.println("------ Product Records ------");

			while (rs.next()) {

				String code = rs.getString("productCode");
				String name = rs.getString("productName");
				String line = rs.getString("productLine");
				int qty = rs.getInt("quantityInStock");

				System.out.printf(
						"ProductCode: %s | Product Name: %s | ProductLine: %s | Quantity: %d%n",
						code, name, line, qty);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("Resources Closed.");
		}
	}
}