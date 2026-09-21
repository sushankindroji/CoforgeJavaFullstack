/**
 * Author :sushank2
 * Date :13-Jul-2026
 * Time :4:28:09 pm
 * Email : saisushankindroji1476@gmail.com
 * JDBC Code to implement Employee CRUD operations using PreparedStatement
 * EmployeeCRUD is the main class to provide menu driven interface to perform CRUD operations
 */

package jdbcdemo;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeCRUD {

	public static void main(String[] args) {

		Employee e = new Employee();
		Scanner s = new Scanner(System.in);

		while (true) {

			System.out.println("\n************** Global Tech Solutions **************");
			System.out.println("----------- Employee Management System ----------");
			System.out.println("1. New Employee");
			System.out.println("2. Display Employees");
			System.out.println("3. Update Employee City");
			System.out.println("4. Delete Employee");
			System.out.println("5. Display Employee By ID");
			System.out.println("6. Exit");

			System.out.print("Enter your choice: ");
			int option = s.nextInt();

			switch (option) {

			case 1:
				System.out.print("Enter Employee Name: ");
				String name = s.next();

				System.out.print("Enter City: ");
				String city = s.next();

				System.out.print("Enter Contact No: ");
				String contactno = s.next();

				e.insertEmployee(name, city, contactno);
				break;

			case 2:
				try {
					e.getEmployee();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				break;

			case 3:
				System.out.print("Enter Employee ID: ");
				int eid = s.nextInt();

				System.out.print("Enter New City: ");
				city = s.next();

				e.updateEmployee(eid, city);
				break;

			case 4:
				System.out.print("Enter Employee ID: ");
				eid = s.nextInt();

				e.deleteEmployee(eid);
				break;

			case 5:
				System.out.print("Enter Employee ID: ");
				eid = s.nextInt();

				e.getEmployeeByID(eid);
				break;

			case 6:
				System.out.println("Program Terminated");
				s.close();
				System.exit(0);

			default:
				System.out.println("Invalid Selection");
			}
		}
	}
}