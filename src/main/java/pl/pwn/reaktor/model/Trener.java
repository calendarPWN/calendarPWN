package pl.pwn.reaktor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trener")
public class Trener {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtrener")
	private Long id;
	
	@Column(name = "imie")
	private String imie;
	
	@Column(name = "nazwisko")
	private String nazwisko;
	
	@Column(name = "inicjaly")
	private String inicjaly;
	
	@Column(name = "mentor")
	private Boolean mentor;

	public Trener() {
		super();
	}

	public Trener(String imie, String nazwisko, String inicjaly, Boolean mentor) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.inicjaly = inicjaly;
		this.mentor = mentor;
	}

	public Trener(Long id, String imie, String nazwisko, String inicjaly, Boolean mentor) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.inicjaly = inicjaly;
		this.mentor = mentor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getInicjaly() {
		return inicjaly;
	}

	public void setInicjaly(String inicjaly) {
		this.inicjaly = inicjaly;
	}

	public Boolean getMentor() {
		return mentor;
	}

	public void setMentor(Boolean mentor) {
		this.mentor = mentor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((inicjaly == null) ? 0 : inicjaly.hashCode());
		result = prime * result + ((mentor == null) ? 0 : mentor.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
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
		Trener other = (Trener) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		if (inicjaly == null) {
			if (other.inicjaly != null)
				return false;
		} else if (!inicjaly.equals(other.inicjaly))
			return false;
		if (mentor == null) {
			if (other.mentor != null)
				return false;
		} else if (!mentor.equals(other.mentor))
			return false;
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trener [id=" + id + ", imie=" + imie + ", nazwisko=" + nazwisko + ", inicjaly=" + inicjaly + ", mentor="
				+ mentor + "]";
	}
	
	
}
