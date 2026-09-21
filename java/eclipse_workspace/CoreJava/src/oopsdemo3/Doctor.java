/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :3:25:30 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class Doctor extends HospitalStaff {

    private String specialization;

    public Doctor(String name, String id, String department, String specialization) {
        super(name, id, department);
        this.specialization = specialization;
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " is examining patients in the "
                + getDepartment() + " department.");
        System.out.println("Specialization: " + specialization);
    }

    public void prescribeMedication() {
        System.out.println(getName() + " is writing a prescription.");
    }
}
