/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :9:39:36 am
 * Email : saisushankindroji1476@gmail.com
 */


package oopsdemo2;

//Student has an Address - Unidirectional Relationship
public class Student {

  int rollNo;
  String name;

  // Entity Reference Aggregation - has a relationship
  Address ad;

  public Student(int rollNo, String name, Address ad) {
      this.rollNo = rollNo;
      this.name = name;
      this.ad = ad;
  }

  void display()
  {
      System.out.println("---------- Student Details ----------");
      System.out.println("Student Id : " + rollNo);
  }
}