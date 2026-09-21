package oopsdemo1;

/**
 * Author : sushank2
 * Date : 07-Jul-2026
 * Time : 9:34:29 am
 * Email : saisushankindroji1476@gmail.com
 */

class Book {

    // Properties
    private int bookId;
    private String bookName;
    private float price;
    private String publisher;

    // Default Constructor
    public Book() {

    }

    // Parameterized Constructor
    public Book(int bookId, String bookName, float price, String publisher) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.publisher = publisher;
    }

    // Getters and Setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // Display Method
    public void display() {
        System.out.println("************* Welcome to Coforge Library **************");
        System.out.println("Book Id      : " + bookId);
        System.out.println("Book Name    : " + bookName);
        System.out.println("Price        : " + price);
        System.out.println("Publisher    : " + publisher);
    }

    // Calculate Discount Price (10%)
    public float discountPrice() {
        return price - (price * 0.10f);
    }

    // toString() Method
    @Override
    public String toString() {
        return "Book [bookId=" + bookId +
                ", bookName=" + bookName +
                ", price=" + price +
                ", publisher=" + publisher + "]";
    }
}