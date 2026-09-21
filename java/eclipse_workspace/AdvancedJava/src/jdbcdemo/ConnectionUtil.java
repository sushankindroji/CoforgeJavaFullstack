/**
 * Author :sushank2
 * Date :13-Jul-2026
 * Time :12:32:42 pm
 * Email : saisushankindroji1476@gmail.com
 */

package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	public static Connection createConnection() throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","root");
		return con;
	}

}