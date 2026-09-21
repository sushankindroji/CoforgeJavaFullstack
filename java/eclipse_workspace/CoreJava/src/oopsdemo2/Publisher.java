/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :9:47:32 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo2;

public class Publisher {

    private String name;
    private String publisherID;
    private String city;

    public Publisher(String name, String publisherID, String city) {
        this.name = name;
        this.publisherID = publisherID;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getPublisherID() {
        return publisherID;
    }

    public String getCity() {
        return city;
    }
}