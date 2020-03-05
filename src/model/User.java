package model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private static int maxPostId;

	public Integer id;
	private String login;
	private String firstName;
	private String lastName;
	private String picture;
	private String bio;
	private List<User> friends;
	private List<Post> posts;

	public User(int id, String login, String firstName, String lastName, String picture, String bio) {
		this.id = id;
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
		this.picture = picture;
		this.bio = bio;
		friends = new ArrayList<>();
		posts = new ArrayList<>();
	}

	public void addPost(Post post) {
		maxPostId++;
		post.setId(maxPostId);
		posts.add(post);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + "]";
	}

}
