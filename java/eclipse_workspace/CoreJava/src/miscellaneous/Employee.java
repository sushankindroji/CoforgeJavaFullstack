/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :10:10:41 am
 * Email : saisushankindroji1476@gmail.com
 */

package miscellaneous;

import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {

        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {

        return "Employee [id=" + id
                + ", name=" + name
                + ", salary=" + salary + "]";
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, salary);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Employee other = (Employee) obj;

        return id == other.id
                && Objects.equals(name, other.name)
                && Double.compare(salary, other.salary) == 0;
    }
}