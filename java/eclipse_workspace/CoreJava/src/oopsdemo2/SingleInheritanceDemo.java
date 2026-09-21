/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :3:20:28 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo2;

public class SingleInheritanceDemo {

    public static void main(String[] args) {
        
        // Create Objects of Child Class
        Developer d1 = new Developer(101, "James Gosling", "JDBC", "Santander Bank"); // invokes derived class constr
        Developer d2 = new Developer(105, "Rod Jhonson", "Spring Framework", "Virgin Atlantic");

        d1.display(); // child class object invokes parent class method - inheritance
        d1.displayDeveloperDetails(); // child class object invokes child class method

        d2.display();
        d2.displayDeveloperDetails();

        Employee e1 = new Employee(106, "Mike"); // invokes parent class constructor
        e1.display();
    }
}
