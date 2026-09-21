/**
 * Author :sushank2
 * Date :13-Jul-2026
 * Time :2:16:45 pm
 * Email : saisushankindroji1476@gmail.com
 */

package jdbcdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class InsertDemo {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psInsert = null;
		PreparedStatement psSelect = null;
		PreparedStatement psCount = null;
		ResultSet rs = null;
		int count;

		try {
			// Create connection
			con = ConnectionUtil.createConnection();

			// ---------- TAKE INPUT FROM USER ----------
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Skill Name: ");
			String skillName = sc.nextLine();

			// ---------- INSERT RECORD USING PREPARED STATEMENT ----------
			String insertSql = "INSERT INTO skills(name) VALUES(?)";
			psInsert = con.prepareStatement(insertSql);
			psInsert.setString(1, skillName);

			//Executing DML query
			count = psInsert.executeUpdate(); 

			if (count > 0) {
				System.out.println(count + " Record Inserted Successfully");
			}

			// ---------- DISPLAY ALL RECORDS ----------
			String selectSql = "SELECT id, name FROM skills";
			psSelect = con.prepareStatement(selectSql);
			rs = psSelect.executeQuery();

			System.out.println("\nAll Records in Skills Table:");
			while (rs.next()) {
				System.out.println(
						"ID: " + rs.getInt("id") +
						", Name: " + rs.getString("name")
						);
			}

			// ---------- COUNT TOTAL RECORDS ----------
			String countSql = "SELECT COUNT(id) FROM skills";
			psCount = con.prepareStatement(countSql);
			rs = psCount.executeQuery();

			if (rs.next()) {
				System.out.println("\nTotal no. of records is: " + rs.getInt(1));
			}

			con.close();
			sc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

