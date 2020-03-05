package service;

import java.util.Arrays;
import java.util.List;

import model.Post;
import model.User;

public class UserService {
	private final List<User> users;

	public UserService() {
		final User[] USERS = {
				new User(1, "olivier", "Olivier", "BROSSERON", "D8yziSlWwAA4NFb.jpg", "Il était une fois"),
				new User(2, "magnum", "Thomas", "MAGNUM", "51x2+ZcUMOL._AC_.jpg", "Je n'ai pas peur des profiteurs"),
				new User(3, "doc", "Emmett", "BROWN", "full.jpg", "Il suffira d'insigne"),
				new User(4, "marty", "Martin", "McFLY",
						"220px-Michael_J._Fox_as_Marty_McFly_in_Back_to_the_Future,_1985.jpg",
						"Rappelle-toi Barbara") };
		USERS[0].setFriends(Arrays.asList(new User[] { USERS[1], USERS[2], USERS[3] }));
		USERS[1].setFriends(Arrays.asList(new User[] { USERS[0], USERS[2], USERS[3] }));
		USERS[2].setFriends(Arrays.asList(new User[] { USERS[1], USERS[0], USERS[3] }));
		USERS[3].setFriends(Arrays.asList(new User[] { USERS[1], USERS[2], USERS[0] }));
		USERS[0].addPost(new Post("Lorem ipsum"));
		USERS[0].addPost(new Post("Mary Poppins s'en va à la pêche"));
		USERS[0].addPost(new Post("Winnie l'Ourson aime le miel"));
		USERS[1].addPost(new Post("Peter Pan et les indiens"));
		users = Arrays.asList(USERS);
	}

	public User findOne(Integer id) {
		return users.stream() //
				.filter(user -> user.getId() == id) //
				.findFirst() //
				.orElse(null);
	}

}
