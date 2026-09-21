/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :3:05:54 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

import java.util.Objects;

public class Product {

	private int productId;
	private String productName;
	private double price;

	public Product(int productId, String productName, double price) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}

	// Update product price
	public void updatePrice(double newPrice) {
		this.price = newPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;

		Product other = (Product) obj;

		return productId == other.productId;
	}

	@Override
	public String toString() {
		return "Product ID : " + productId +
				", Product Name : " + productName +
				", Price : ₹" + price;
	}
}
