/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :4:12:50 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo2;

class Staff {

    private int empId;
    private String name;
    protected float salary, hra;

    public Staff(int empId, String name, float salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    void getHRA() {
        hra = (salary * 60) / 100;
        System.out.println("HRA : " + hra);
    }

    void display() {
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.println("Salary : " + salary);
    }

    void print() {
        System.out.println("Gross Salary of Staff : " + (salary + hra));
    }
}

class Manager extends Staff {

    protected float da;
    private float gross;

    public Manager(int empId, String name, float salary) {
        super(empId, name, salary);
    }

    void getDA() {
        da = (salary * 80) / 100;
        System.out.println("DA : " + da);
    }

    void getGross() {
        gross = salary + hra + da;
        System.out.println("Gross Salary of Manager : " + gross);
    }
}

class Director extends Manager {

    private float ta;
    private float gross;

    public Director(int empId, String name, float salary) {
        super(empId, name, salary);
    }

    void getTA() {
        ta = (salary * 30) / 100;
        System.out.println("TA : " + ta);
    }

    @Override
    void getGross() {
        gross = salary + hra + da + ta;
        System.out.println("Gross Salary of Director : " + gross);
    }
}