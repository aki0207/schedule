
package model;

import java.io.Serializable;

public class User implements Serializable {

	private String name;
	private String pass;
	private String id;

	public User() {
	}

	public User(String id, String pass, String name) {

		this.id = id;
		this.pass = pass;
		this.name = name;

	}

	public String getId() {

		return id;

	}

	public String getPass() {

		return pass;

	}

	public String getName() {

		return name;

	}
	
	public String setName(String name) {
		
		this.name = name;
		return name;
		
	}

}