/**
 * Author :sushank2
 * Date :13-Jul-2026
 * Time :12:34:21 pm
 * Email : saisushankindroji1476@gmail.com
 */

package jdbcdemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableDemo {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			con = ConnectionUtil.createConnection();

			stmt = con.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery("SELECT * FROM products");

			System.out.println("Top to Bottom");

			while (rs.next()) {
				System.out.println(
						rs.getString("productCode") + "\t"
								+ rs.getString("productName") + "\t"
								+ rs.getString("productLine"));
			}

			System.out.println("\nBottom to Top");

			rs.afterLast();

			while (rs.previous()) {
				System.out.println(
						rs.getString("productCode") + "\t"
								+ rs.getString("productName") + "\t"
								+ rs.getString("productLine"));
			}

			System.out.println("\n50th Record");

			if (rs.absolute(50)) {
				System.out.println(
						rs.getString("productCode") + "\t"
								+ rs.getString("productName") + "\t"
								+ rs.getString("productLine"));
			}

			System.out.println("\n40th Record");

			if (rs.relative(-10)) {
				System.out.println(
						rs.getString("productCode") + "\t"
								+ rs.getString("productName") + "\t"
								+ rs.getString("productLine"));
			}

			System.out.println("\nFirst Record");

			rs.first();

			System.out.println(
					rs.getString("productCode") + "\t"
							+ rs.getString("productName") + "\t"
							+ rs.getString("productLine"));

			rs.absolute(4);
			System.out.println("Current Row : " + rs.getRow());

			rs.last();
			System.out.println("Total Records : " + rs.getRow());

			rs.close();
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}