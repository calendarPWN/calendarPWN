package pl.pwn.reaktor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	private String login;

	private String password;

	private String name;

	@Column(name = "last_name")
	private String lastName;

	public User() {
		super();
	}

	public User(String login, String password, String name, String lastName) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
	}

	public User(long id, String login, String password, String name, String lastName) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", name=" + name + ", lastName="
				+ lastName + "]";
	}

}
