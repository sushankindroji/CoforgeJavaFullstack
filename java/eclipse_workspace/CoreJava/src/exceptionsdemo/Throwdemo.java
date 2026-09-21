/**
 * Author :sushank2
 * Date :09-Jul-2026
 * Time :2:37:51 pm
 * Email : saisushankindroji1476@gmail.com
 */

package exceptionsdemo;

public class Throwdemo {

	public static void hello(int a){
		if (a==0)
			throw new ArithmeticException("pass non zero Values");
		else 
			System.out.println(a);

	}
	public static void main(String[] args) {
		hello(100);
		hello(0);
	}

}

