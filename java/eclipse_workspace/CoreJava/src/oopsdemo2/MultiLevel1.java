/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :4:21:01 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo2;

public class MultiLevel1 {

    public static void main(String[] args) {

        Director d1 = new Director(101, "Keane", 5000);

        System.out.println("********** Director Details **********");
        d1.display();
        d1.getHRA();
        d1.getDA();
        d1.getTA();
        d1.getGross();

        Manager m1 = new Manager(201, "Mary", 4000);

        System.out.println("\n********** Manager Details **********");
        m1.display();
        m1.getHRA();
        m1.getDA();
        m1.getGross();

        Staff s1 = new Staff(301, "Helen", 2000);

        System.out.println("\n********** Staff Details **********");
        s1.display();
        s1.getHRA();
        s1.print();
    }
}