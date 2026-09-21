/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :4:40:30 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class Circle implements IShape {


	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}
	@Override
	public void draw() {

		System.out.println("Drawing a Circle with radius: " + radius);

	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;

	}
	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		return 2* Math.PI*radius;

	}

}

