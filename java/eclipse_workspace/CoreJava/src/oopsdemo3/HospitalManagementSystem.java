/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :3:34:16 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class HospitalManagementSystem {

	public static void main(String[] args) {

		// Create different types of hospital staff
		Doctor doctor = new Doctor(
				"Dr. Smith",
				"DOC123",
				"Cardiology",
				"Cardiologist");

		Nurse nurse = new Nurse(
				"Nurse Johnson",
				"NUR456",
				"Emergency",
				8);

		AdminStaff admin = new AdminStaff(
				"Mr. Davis",
				"ADM789",
				"Administration",
				"Billing");

		// Demonstrate polymorphism
		HospitalStaff[] staffMembers = {doctor, nurse, admin};

		for (HospitalStaff staff : staffMembers) {

			System.out.println("\n---------------------------------");
			System.out.println("Name       : " + staff.getName());
			System.out.println("ID         : " + staff.getId());
			System.out.println("Department : " + staff.getDepartment());

			staff.performDuties();
			staff.attendMeeting();

			// Role-specific methods
			if (staff instanceof Doctor) {
				((Doctor) staff).prescribeMedication();
			} else if (staff instanceof Nurse) {
				((Nurse) staff).administerMedication();
			} else if (staff instanceof AdminStaff) {
				((AdminStaff) staff).processPaperwork();
			}
		}
	}
}