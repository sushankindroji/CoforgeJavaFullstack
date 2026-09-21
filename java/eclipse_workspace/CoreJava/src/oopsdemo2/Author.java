/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :9:55:30 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo2;

public class Author {

    private String authorName;
    private int age;
    private String place;

    public Author(String authorName, int age, String place) {
        this.authorName = authorName;
        this.age = age;
        this.place = place;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getAge() {
        return age;
    }

    public String getPlace() {
        return place;
    }
}