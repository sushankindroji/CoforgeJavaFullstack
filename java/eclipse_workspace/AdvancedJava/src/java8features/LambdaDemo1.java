/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :10:20:24 am
 * Email : saisushankindroji1476@gmail.com
 */

package java8features;

public class LambdaDemo1 {

    public static void main(String[] args) {

        Calculator op1 = (a, b) -> a + b;
        System.out.println("Addition of 2 nums: " + op1.calculate(200, 155));

        Calculator op2 = (a, b) -> a - b;
        System.out.println("Subtraction of 2 nums: " + op2.calculate(200, 155));

        Calculator op3 = (a, b) -> a * b;
        System.out.println("Multiplication of 2 nums: " + op3.calculate(200, 155));

        Calculator op4 = (a, b) -> a / b;
        System.out.println("Division of 2 nums: " + op4.calculate(200, 155));

    }
}
