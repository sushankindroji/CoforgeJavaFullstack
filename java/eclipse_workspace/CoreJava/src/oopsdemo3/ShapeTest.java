/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :4:45:51 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class ShapeTest {

	public static void main(String[] args) {

		IShape shape = new Circle(10);

		System.out.println("Using Interface: " + IShape.LABEL);

		shape.draw();
		System.out.println("Area of Circle: " + shape.getArea());
		System.out.println("Perimeter of Circle: " + shape.calculatePerimeter());

		System.out.println();

		// Switching from one implementation to another
		shape = new Rectangle(10, 7);

		shape.draw();
		System.out.println("Area of Rectangle: " + shape.getArea());
		System.out.println("Perimeter of Rectangle: " + shape.calculatePerimeter());
	}
}

