package controlflow;

/**
 * Author :sushank2
 * Date :06-Jul-2026
 * Time :11:48:58 am
 * Email : saisushankindroji1476@gmail.com
 */


public class ForDemo {

	public static void main(String[] args) {
		int i, j;

		System.out.println("Display Nos from 1-25");
		for (i = 1; i <= 10; i++) {
			System.out.print(i + "\t");
		}

		System.out.println();
		System.out.println("Display Nos from 100-75");
		for (j = 100; j >= 90; j--) {
			System.out.print(j + "\t");
		}

		System.out.println("\nDisplay Nos from 1-25 & 100-75 together");

		for (i = 1, j = 100; i <= 10 || j >= 90; i++, j--) {
			if (i <= 10) {
				System.out.print(i + "\t");
			}
			if (j >= 90) {
				System.out.print(j + "\t");
			}
		}
	}
}