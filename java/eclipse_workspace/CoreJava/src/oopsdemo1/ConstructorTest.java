package oopsdemo1;

/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :11:53:26 am
 * Email : saisushankindroji1476@gmail.com
 */



class Pen {
    // properties/attributes of Pen
    String color;
    String type;

    // Constructor of Pen class
    Pen() {
        System.out.println("I am No-Args Constructor");
    }

    Pen(String color, String type) {
        System.out.println("I am Parameterized Constructor");
        this.color = color;
        this.type = type;
    }

    void display() {
        System.out.println("Pen Color: " + this.color + ", Pen Type: " + this.type);
    }
}



public class ConstructorTest {

    public static void main(String[] args) {

        Pen p1 = new Pen();
        Pen p2 = new Pen("Blue", "Ball");
        Pen p3 = new Pen("Black", "Gel");

        p1.display();
        p2.display();
        p3.display();
    }
}
