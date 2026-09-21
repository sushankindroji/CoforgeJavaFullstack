package oopsdemo1;

/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :9:57:12 am
 * Email : saisushankindroji1476@gmail.com
 */

/** Java OOP to enter ProductId,Product Name, price & qty, calculate the Total bill 
 * & display details
 * 
 * Note: Product Name Should be multiple words.
 */

class Product {

    // Properties
    private int productId;
    private String productName;
    private float price;
    private int qty;

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    // Business Method
    public float totalBill() {
        return price * qty;
    }

    // Display Method
    public void display() {
        System.out.println("\n******** PRODUCT DETAILS ********");
        System.out.println("Product Id   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Price        : " + price);
        System.out.println("Quantity     : " + qty);
        System.out.println("Total Bill   : " + totalBill());
    }

    // toString()
    @Override
    public String toString() {
        return "Product [productId=" + productId +
                ", productName=" + productName +
                ", price=" + price +
                ", qty=" + qty + "]";
    }
}