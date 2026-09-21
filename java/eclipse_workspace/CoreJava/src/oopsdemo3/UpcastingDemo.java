/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :1:01:50 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class UpcastingDemo {

	public static void main(String[] args) {


		Product product; // creating a reference variable

		//product obj refers to Book Object
		product =new Book("Java programming",450,"James Gosling"); //Upcasting
		System.out.println("------------- Book Details --------------");
		product.display(); //Dynamic Binding -- calls Book's display()

		//Switching from one implementation to another is easy 
		product=new Laptop("IdeaPad",60000.00,"Lenova"); //Upcasting
		System.out.println("------------- Laptop Details --------------");
		product.display();//Dynamic Binding

		product =new Book("Python Made Easy",650,"Balaguruswamy"); //Upcasting
		System.out.println("------------- Book Details --------------");
		product.display(); //Dynamic Binding

		//Downcasting
		//  product.showSpecs(); //Compile Time Error

		if (product instanceof Laptop) {
			Laptop lap = (Laptop) product; // Downcasting - Casting Product to Laptop
			lap.showSpecs();
		} else {
			Book b = (Book) product; // Downcasting - Casting Product to Book
			b.showBookInfo();
		}
		//	       Laptop lap=(Laptop)product; //Downcasting - Casting Product to Laptop
		//	       lap.showSpecs(); //Now it works fine

	}

}
