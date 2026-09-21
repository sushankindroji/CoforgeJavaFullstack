/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :4:17:59 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BloggingSystem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		HashMap<Integer, Blog> blogMap = new HashMap<>();

		// Initial Blogs
		blogMap.put(101, new Blog(101, "Intro to Java", "Ravi",
				"Java basics for beginners."));
		blogMap.put(103, new Blog(103, "Spring Boot Guide", "Priya",
				"Step-by-step Spring Boot tutorial."));
		blogMap.put(102, new Blog(102, "Frontend Trends", "Anita",
				"Exploring 2025 frontend frameworks."));

		boolean running = true;

		while (running) {

			System.out.println("\n===== BLOGGING SYSTEM =====");
			System.out.println("1. Add Blog");
			System.out.println("2. Update Blog");
			System.out.println("3. Delete Blog");
			System.out.println("4. Search Blog");
			System.out.println("5. Display All (HashMap)");
			System.out.println("6. Display All (TreeMap)");
			System.out.println("7. Exit");

			System.out.print("Enter Choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:

				System.out.print("Enter Blog ID: ");
				int id = sc.nextInt();
				sc.nextLine();

				if (blogMap.containsKey(id)) {
					System.out.println("Blog ID already exists.");
					break;
				}

				System.out.print("Enter Title: ");
				String title = sc.nextLine();

				System.out.print("Enter Author: ");
				String author = sc.nextLine();

				System.out.print("Enter Content: ");
				String content = sc.nextLine();

				blogMap.put(id, new Blog(id, title, author, content));

				System.out.println("Blog Added Successfully.");
				break;

			case 2:

				System.out.print("Enter Blog ID to Update: ");
				int updateId = sc.nextInt();
				sc.nextLine();

				Blog updateBlog = blogMap.get(updateId);

				if (updateBlog != null) {

					System.out.print("Enter New Title: ");
					updateBlog.setTitle(sc.nextLine());

					System.out.print("Enter New Content: ");
					updateBlog.setContent(sc.nextLine());

					System.out.println("Blog Updated Successfully.");
				} else {
					System.out.println("Blog Not Found.");
				}

				break;

			case 3:

				System.out.print("Enter Blog ID to Delete: ");
				int deleteId = sc.nextInt();

				if (blogMap.remove(deleteId) != null)
					System.out.println("Blog Deleted.");
				else
					System.out.println("Blog Not Found.");

				break;

			case 4:

				System.out.print("Enter Blog ID to Search: ");
				int searchId = sc.nextInt();

				Blog found = blogMap.get(searchId);

				if (found != null)
					System.out.println(found);
				else
					System.out.println("Blog Not Found.");

				break;

			case 5:

				System.out.println("\nBlogs in HashMap:");

				for (Map.Entry<Integer, Blog> entry : blogMap.entrySet()) {
					System.out.println(entry.getValue());
				}

				break;

			case 6:

				TreeMap<Integer, Blog> treeMap = new TreeMap<>(blogMap);

				System.out.println("\nBlogs in TreeMap:");

				for (Map.Entry<Integer, Blog> entry : treeMap.entrySet()) {
					System.out.println(entry.getValue());
				}

				break;

			case 7:

				running = false;
				System.out.println("Thank You!");
				break;

			default:

				System.out.println("Invalid Choice.");
			}
		}

		sc.close();
	}
}