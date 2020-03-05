package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Post {

	private Integer id;

	private String content;

	public Post(String content) {
		this.content = content;
	}

}
