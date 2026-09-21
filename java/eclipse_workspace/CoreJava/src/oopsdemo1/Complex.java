/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :12:40:54 pm
 * Email : saisushankindroji1476@gmail.com
 */


package oopsdemo1;

public class Complex {

    private double real;
    private double imaginary;

    // Generate Constructor using fields
    public Complex(double real, double imaginary) { // parameterized constructor
        this.real = real;
        this.imaginary = imaginary;
    }

    public void add(Complex obj) // method which accepts object as an argument
    {
        // c1.real+c2.real
        //this keyword refers to current object calling the method
        this.real += obj.real;
        this.imaginary += obj.imaginary;
    }

    public void display()
    {
        System.out.println(this.real + " + i" + this.imaginary);
    }
}