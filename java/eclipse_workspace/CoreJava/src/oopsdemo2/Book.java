package oopsdemo2;

/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :9:47:32 am
 * Email : saisushankindroji1476@gmail.com
 */

public class Book {

	private String name;
	private int price;

	// Aggregation
	private Author author;
	private Publisher publisher;

	public Book(String name, int price, Author author, Publisher publisher) {
		this.name = name;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
	}

	void display() {

		System.out.println("*************** Book Details ****************");
		System.out.println("Book Name      : " + name);
		System.out.println("Book Price     : " + price);

		System.out.println("\n------------ Author Details ------------");
		System.out.println("Author Name    : " + author.getAuthorName());
		System.out.println("Author Age     : " + author.getAge());
		System.out.println("Author Place   : " + author.getPlace());

		System.out.println("\n----------- Publisher Details ----------");
		System.out.println("Publisher Name : " + publisher.getName());
		System.out.println("Publisher ID   : " + publisher.getPublisherID());
		System.out.println("Publisher City : " + publisher.getCity());
	}
}