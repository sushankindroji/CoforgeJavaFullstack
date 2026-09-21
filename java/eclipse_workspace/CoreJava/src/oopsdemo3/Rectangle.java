/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :4:41:31 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class Rectangle implements IShape {

	private double length;
	private double width;

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	public void draw() {
		System.out.println("Drawing a Rectangle with length: " + length +
				" and width: " + width);
	}

	@Override
	public double getArea() {
		return length * width;
	}

	@Override
	public double calculatePerimeter() {
		return 2 * (length + width);
	}
}
