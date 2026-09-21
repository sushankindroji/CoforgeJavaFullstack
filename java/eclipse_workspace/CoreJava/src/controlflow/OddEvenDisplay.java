package controlflow;

/**
 * Author :sushank2
 * Date :06-Jul-2026
 * Time :10:53:13 am
 * Email : saisushankindroji1476@gmail.com
 */


public class OddEvenDisplay {
    public static void main(String[] args) {

        System.out.println("ODD\tEVEN");
        System.out.println("---\t----");

        for (int i = 1; i <= 10; i += 2) {
            System.out.println(i + "\t" + (i + 1));
        }
    }
}
