/**
 * Author :sushank2
 * Date :09-Jul-2026
 * Time :10:03:35 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo4;

public interface IUserOperations {

	void login();

	void logout();
}

interface ISocialFeatures {

	void createPost(String post);

	void sendFriendRequest(String friendName);

	void likePost(int likes);
}
