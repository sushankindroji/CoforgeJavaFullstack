/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :10:21:34 am
 * Email : saisushankindroji1476@gmail.com
 */

package miscellaneous;

public class ObjectClassDemo {

    public static void main(String[] args) {

        Employee emp1 = new Employee(101, "Alice", 50000);

        Employee emp2 = new Employee(101, "Alice", 50000);

        Employee emp3 = new Employee(102, "Bob", 60000);

        System.out.println(emp1);

        System.out.println("emp1 equals emp2 : "
                + emp1.equals(emp2));

        System.out.println("emp1 equals emp3 : "
                + emp1.equals(emp3));

        System.out.println("emp1 HashCode : "
                + emp1.hashCode());

        System.out.println("emp2 HashCode : "
                + emp2.hashCode());

        System.out.println("emp3 HashCode : "
                + emp3.hashCode());

        System.out.println("Class Name : "
                + emp1.getClass().getName());

        System.out.println("Is emp1 Employee? "
                + (emp1 instanceof Employee));
    }
}