/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :3:26:26 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class AdminStaff extends HospitalStaff {

    private String role;

    public AdminStaff(String name, String id, String department, String role) {
        super(name, id, department);
        this.role = role;
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " is performing " + role
                + " tasks in the " + getDepartment() + " department.");
    }

    public void processPaperwork() {
        System.out.println(getName() + " is processing hospital paperwork.");
    }
}