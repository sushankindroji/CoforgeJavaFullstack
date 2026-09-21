package oopsdemo1;

/**
 * Author : sushank2
 * Date : 07-Jul-2026
 * Time : 9:24:38 am
 * Email : saisushankindroji1476@gmail.com
 */

class Lamp {

    // true if light is on
    // false if light is off
    private boolean isOn;

    // method to turn on the light
    public void turnOn() {
        isOn = true;
        System.out.println("Light On? " + isOn);
    }

    // method to turn off the light
    public void turnOff() {
        isOn = false;
        System.out.println("Light On? " + isOn);
    }
}

public class LampTest {

    public static void main(String[] args) {

        // Create Lamp objects
        Lamp led = new Lamp();
        Lamp halogen = new Lamp();

        // Switch on led & halogen
        led.turnOn();
        halogen.turnOn();

        // Switch off led & halogen
        led.turnOff();
        halogen.turnOff();
    }
}