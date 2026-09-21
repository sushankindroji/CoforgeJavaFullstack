/**
 * Author :sushank2
 * Date :13-Jul-2026
 * Time :2:06:35 pm
 * Email : saisushankindroji1476@gmail.com
 */

package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JoinDemo2 {

	// Database credentials
	private static final String URL = "jdbc:mysql://localhost:3306/classicmodels";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	// Multi-line SQL (Java 15+)
	private static final String SQL = """
			SELECT
			    c.customerNumber,
			    c.customerName,
			    c.city,
			    c.country,
			    o.orderNumber,
			    o.orderDate,
			    o.status
			FROM customers c
			LEFT JOIN orders o
			ON c.customerNumber = o.customerNumber
			ORDER BY c.customerNumber
			""";

	public static void main(String[] args) {

		try {
			// Load MySQL Driver (optional for JDBC 4+)
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Try-With-Resources
			try (
					Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(SQL);
					) {

				System.out.printf("%-8s %-30s %-15s %-15s %-10s %-12s %-15s%n",
						"CustNo", "Customer Name", "City", "Country",
						"OrderNo", "Order Date", "Status");

				System.out.println("----------------------------------------------------------------------------------------------------------");

				while (rs.next()) {

					System.out.printf(
							"%-8d %-30s %-15s %-15s %-10d %-12s %-15s%n",
							rs.getInt("customerNumber"),
							rs.getString("customerName"),
							rs.getString("city"),
							rs.getString("country"),
							rs.getInt("orderNumber"),
							rs.getDate("orderDate"),
							rs.getString("status"));
				}

			}

		} catch (ClassNotFoundException e) {
			System.out.println("MySQL Driver Not Found.");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Database Error.");
			e.printStackTrace();
		}
	}
}