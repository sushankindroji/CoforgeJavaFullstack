/**
 * Author :sushank2
 * Date :13-Jul-2026
 * Time :12:48:05 pm
 * Email : saisushankindroji1476@gmail.com
 */

package jdbcdemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JoinDemo {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			// Create Connection
			con = ConnectionUtil.createConnection();

			// Create Statement
			stmt = con.createStatement();

			// Join Query
			String sql = "SELECT c.id, c.first_name, sk.name "
					+ "FROM candidates c "
					+ "INNER JOIN candidate_skills s ON c.id = s.candidate_id "
					+ "INNER JOIN skills sk ON s.skill_id = sk.id";

			rs = stmt.executeQuery(sql);

			System.out.println("Candidate ID\tFirst Name\tSkill");

			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t\t"
								+ rs.getString(2) + "\t\t"
								+ rs.getString(3));
			}

		} catch (Exception e) {
			System.out.println("Error:");
			e.printStackTrace();

		} finally {

			try {
				if (rs != null)
					rs.close();

				if (stmt != null)
					stmt.close();

				if (con != null)
					con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("Resources Closed.");
		}
	}
}
