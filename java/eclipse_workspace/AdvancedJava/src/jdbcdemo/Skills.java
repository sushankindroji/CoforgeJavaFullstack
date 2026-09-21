/**
 * Author :sushank2
 * Date :13-Jul-2026
 * Time :4:17:29 pm
 * Email : saisushankindroji1476@gmail.com
 */

package jdbcdemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class Skills {

	private Connection con;
	private CallableStatement cstmt;
	private ResultSet rs;

	// Constructor to create DB connection
	public Skills() throws Exception {
		con = ConnectionUtil.createConnection();
	}

	public void getSkills(int candidateId) throws Exception {

		// Call Stored Procedure
		cstmt = con.prepareCall("{call get_candidate_skill(?)}");
		cstmt.setInt(1, candidateId);

		rs = cstmt.executeQuery();

		if (!rs.next()) {
			System.out.println("No Skills Found.");
		} else {

			do {
				System.out.println(
						rs.getString("first_name") + " "
								+ rs.getString("last_name")
								+ " - "
								+ rs.getString("skill"));
			} while (rs.next());
		}

		rs.close();
		cstmt.close();
		con.close();
	}
}