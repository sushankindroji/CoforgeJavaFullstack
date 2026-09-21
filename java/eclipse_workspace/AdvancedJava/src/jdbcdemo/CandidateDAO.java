package jdbcdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Author :sushank2
 * Date :13-Jul-2026
 * Time :2:58:20 pm
 * Email : saisushankindroji1476@gmail.com
 * 
 * DAO class for inserting Candidate records into the database using JDBC.
 * PreparedStatement is used to prevent SQL injection and improve performance.
 */
public class CandidateDAO {

	private final String INSERT_QUERY =
			"INSERT INTO candidates(first_name,last_name,dob,phone,email) VALUES(?,?,?,?,?)";

	public boolean insertCandidate(Candidate candidate) {

		try(Connection conn =ConnectionUtil.createConnection();
				PreparedStatement pstmt= conn.prepareStatement(INSERT_QUERY)){

			pstmt.setString(1,candidate.getFirstName());
			pstmt.setString(2,candidate.getLastName());
			pstmt.setString(3,candidate.getDob());
			pstmt.setString(4,candidate.getPhone());
			pstmt.setString(5,candidate.getEmail());

			int rows=pstmt.executeUpdate();

			return rows>0;
		}catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

}
