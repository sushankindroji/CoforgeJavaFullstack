/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :12:27:19 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

class Book {
	int id;
	String name;
	String author;
	String publisher;
	int quantity;

	public Book(int id, String name, String author, String publisher, int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + author + " " + publisher + " " + quantity;
	}
}
