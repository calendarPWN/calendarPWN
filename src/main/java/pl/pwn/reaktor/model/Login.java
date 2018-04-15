package pl.pwn.reaktor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "login")
	private String login;
	@Column(name = "password")
	private String password;
	
	@Column(name = "Trener_idTrener")
	private String idTrener;

	

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

	public String getIdTrener() {
		return idTrener;
	}

	public void setIdTrener(String idTrener) {
		this.idTrener = idTrener;
	}

	
	public Login(long id, String login, String password, String idTrener) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.idTrener = idTrener;
	}

	public Login() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((idTrener == null) ? 0 : idTrener.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (id != other.id)
			return false;
		if (idTrener == null) {
			if (other.idTrener != null)
				return false;
		} else if (!idTrener.equals(other.idTrener))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", login=" + login + ", password=" + password + ", idTrener=" + idTrener + "]";
	}

	

	
}
