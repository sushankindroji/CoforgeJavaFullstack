/**
 * Author :sushank2
 * Date :13-Jul-2026
 * Time :4:48:10 pm
 * Email : saisushankindroji1476@gmail.com
 */

package jdbcdemo;

import java.sql.*;

public class Employee {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public Employee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/EmployeeDB",
					"root",
					"root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertEmployee(String name, String city, String contactno) {
		try {
			ps = con.prepareStatement(
					"INSERT INTO Employee(name,city,contactno) VALUES(?,?,?)");

			ps.setString(1, name);
			ps.setString(2, city);
			ps.setString(3, contactno);

			int i = ps.executeUpdate();

			if (i > 0)
				System.out.println("Employee Inserted Successfully");
			else
				System.out.println("Insertion Failed");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getEmployee() throws SQLException {

		ps = con.prepareStatement("SELECT * FROM Employee");
		rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println(
					rs.getInt("eid") + "  "
							+ rs.getString("name") + "  "
							+ rs.getString("city") + "  "
							+ rs.getString("contactno"));
		}
	}

	public void updateEmployee(int eid, String city) {

		try {
			ps = con.prepareStatement(
					"UPDATE Employee SET city=? WHERE eid=?");

			ps.setString(1, city);
			ps.setInt(2, eid);

			int i = ps.executeUpdate();

			if (i > 0)
				System.out.println("Employee Updated Successfully");
			else
				System.out.println("Employee Not Found");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteEmployee(int eid) {

		try {
			ps = con.prepareStatement(
					"DELETE FROM Employee WHERE eid=?");

			ps.setInt(1, eid);

			int i = ps.executeUpdate();

			if (i > 0)
				System.out.println("Employee Deleted Successfully");
			else
				System.out.println("Employee Not Found");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getEmployeeByID(int eid) {

		try {
			ps = con.prepareStatement(
					"SELECT * FROM Employee WHERE eid=?");

			ps.setInt(1, eid);

			rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println(
						rs.getInt("eid") + "  "
								+ rs.getString("name") + "  "
								+ rs.getString("city") + "  "
								+ rs.getString("contactno"));
			} else {
				System.out.println("Employee Not Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
