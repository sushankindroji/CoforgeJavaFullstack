/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :4:14:30 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

public class Blog {

	private int blogId;
	private String title;
	private String author;
	private String content;

	public Blog() {

	}

	public Blog(int blogId, String title, String author, String content) {
		this.blogId = blogId;
		this.title = title;
		this.author = author;
		this.content = content;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId +
				", title=" + title +
				", author=" + author +
				", content=" + content + "]";
	}
}
