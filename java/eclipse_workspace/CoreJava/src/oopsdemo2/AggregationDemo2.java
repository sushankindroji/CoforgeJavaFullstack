/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :9:58:03 am
 * Email : saisushankindroji1476@gmail.com
 */


package oopsdemo2;

public class AggregationDemo2 {

	public static void main(String[] args) {

		Author author = new Author("Jai", 43, "India");

		Publisher publisher = new Publisher(
				"Z Publications",
				"ZOT56-F",
				"Hyderabad");

		Book b = new Book(
				"Java for Beginners",
				700,
				author,
				publisher);

		b.display();
	}
}