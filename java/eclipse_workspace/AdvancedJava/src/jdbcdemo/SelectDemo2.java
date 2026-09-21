/**
 * Author :sushank2
 * Date :13-Jul-2026
 * Time :11:53:29 am
 * Email : saisushankindroji1476@gmail.com
 */

package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo2 {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/quickupi";
		String user = "root";
		String password = "root";

		try {
			// Step 1: Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Establish Connection
			Connection con = DriverManager.getConnection(url, user, password);

			// Step 3: Create Statement
			Statement stmt = con.createStatement();

			// Step 4: Execute Query
			ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.printf("%-5s %-20s %-12s %-28s %-8s %-12s %-12s%n",
					"ID", "Name", "Mobile", "Email", "Gender", "DOB", "City");
			System.out.println("-----------------------------------------------------------------------------------------------");

			// Step 5: Read Records
			while (rs.next()) {

				System.out.printf(
						"%-5d %-20s %-12s %-28s %-8s %-12s %-12s%n",
						rs.getInt("user_id"),
						rs.getString("full_name"),
						rs.getString("mobile_number"),
						rs.getString("email"),
						rs.getString("gender"),
						rs.getDate("dob"),
						rs.getString("city"));
			}

			// Step 6: Close Resources
			rs.close();
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}