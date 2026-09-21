/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :3:25:01 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class Nurse extends HospitalStaff {

    private int patientLoad;

    public Nurse(String name, String id, String department, int patientLoad) {
        super(name, id, department);
        this.patientLoad = patientLoad;
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " is caring for "
                + patientLoad + " patients.");
    }

    public void administerMedication() {
        System.out.println(getName() + " is administering medication.");
    }
}
