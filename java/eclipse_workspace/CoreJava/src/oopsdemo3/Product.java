/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :12:27:51 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class Product {

	private String name;
	private double price;

	// Constructor
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	// Getters
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	// Method to be overridden
	void display() {
		System.out.println("Product Name : " + name);
		System.out.println("Price        : " + price);
	}
}

//------------------------------------------------------------

class Book extends Product {

	private String author;

	public Book(String name, double price, String author) {
		super(name, price);
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	void display() {
		super.display();
		System.out.println("Author       : " + author);
	}

	void showBookInfo() {
		System.out.println("Book Information:");
		System.out.println("This book is a comprehensive guide to programming.");
		System.out.println("Published by Tech Publishers.");
	}
}

//------------------------------------------------------------

class Laptop extends Product {

	private String manufacturer;

	public Laptop(String name, double price, String manufacturer) {
		super(name, price);
		this.manufacturer = manufacturer;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	@Override
	void display() {
		super.display();
		System.out.println("Manufacturer : " + manufacturer);
	}

	void showSpecs() {
		System.out.println("Laptop Specifications:");
		System.out.println("Processor : Intel i7");
		System.out.println("RAM       : 16GB");
		System.out.println("Storage   : 512GB SSD");
	}
}