/**
 * Author :sushank2
 * Date :13-Jul-2026
 * Time :4:00:26 pm
 * Email : saisushankindroji1476@gmail.com
 * 
 * JDBC PreparedStatement Example to retrieve records from MySQL Database table using PreparedStatement
 * 
 * PreparedStatement is used to execute parameterized queries.
 *  It is more efficient and secure than Statement.
 */

package jdbcdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.DriverManager;

public class PreparedStatementDemo {

	public static void main(String[] args) {

		Connection con=null;
		PreparedStatement pstmt;
		ResultSet rs;
		Scanner scan;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","root");

			// create a preparedstatement Object
			pstmt=con.prepareStatement("SELECT customerNumber,customerName,city,country FROM customers"
					+ " where country=?");

			scan=new Scanner(System.in);
			System.out.println("Enter Country name of Customers to be displayed :");
			String country=scan.next();

			//assign value for to i/p parameter of ps
			pstmt.setString(1, country);

			rs=pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}

			System.out.println("*****************************************");

			scan=new Scanner(System.in);
			System.out.println("Enter Country name of Customers to be displayed :");
			String country1=scan.next();

			//reuse ps
			pstmt.setString(1, country1);

			rs=pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}

