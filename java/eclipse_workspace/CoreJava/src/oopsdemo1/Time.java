/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :12:55:18 pm
 * Email : saisushankindroji1476@gmail.com
 */



package oopsdemo1;

public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    // Constructor
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    // Method to add another Time object
    public void add(Time t) {

        this.seconds += t.seconds;

        if (this.seconds >= 60) {
            this.minutes += this.seconds / 60;
            this.seconds = this.seconds % 60;
        }

        this.minutes += t.minutes;

        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }

        this.hours += t.hours;
    }

    // Display method
    public void display() {
        System.out.println(hours + " : " + minutes + " : " + seconds);
    }
}
