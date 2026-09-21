package oopsdemo4;

public interface TwitterOperations {
	void login();

	void postTweet(String tweet);

	void likeTweet(int likes);

	void followUser(String username);

	void logout();

}