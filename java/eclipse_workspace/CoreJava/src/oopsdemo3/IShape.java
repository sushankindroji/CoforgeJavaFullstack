package oopsdemo3;

public interface IShape {
	//implicitly public, static and final - constant
	public String LABEL="Shape";

	//interface methods are implicitly abstract and public
	void draw();

	public abstract double getArea();
	public abstract double calculatePerimeter();

}
