package pl.pwn.reaktor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "szkolenie")
public class Szkolenia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idszkolenie")
	private long id;
	
	@Column(name = "nazwa")
	private String nazwa;
	
	@Column(name = "liczba_dni")
	private Long liczbaDni;
	
	@Column(name = "typ")
	private String typ;

	public Szkolenia() {
		super();
	}

	public Szkolenia(String nazwa, Long liczbaDni, String typ) {
		super();
		this.nazwa = nazwa;
		this.liczbaDni = liczbaDni;
		this.typ = typ;
	}

	public Szkolenia(long id, String nazwa, Long liczbaDni, String typ) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.liczbaDni = liczbaDni;
		this.typ = typ;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Long getLiczbaDni() {
		return liczbaDni;
	}

	public void setLiczbaDni(Long liczbaDni) {
		this.liczbaDni = liczbaDni;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((liczbaDni == null) ? 0 : liczbaDni.hashCode());
		result = prime * result + ((nazwa == null) ? 0 : nazwa.hashCode());
		result = prime * result + ((typ == null) ? 0 : typ.hashCode());
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
		Szkolenia other = (Szkolenia) obj;
		if (id != other.id)
			return false;
		if (liczbaDni == null) {
			if (other.liczbaDni != null)
				return false;
		} else if (!liczbaDni.equals(other.liczbaDni))
			return false;
		if (nazwa == null) {
			if (other.nazwa != null)
				return false;
		} else if (!nazwa.equals(other.nazwa))
			return false;
		if (typ == null) {
			if (other.typ != null)
				return false;
		} else if (!typ.equals(other.typ))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Szkolenia [id=" + id + ", nazwa=" + nazwa + ", liczbaDni=" + liczbaDni + ", typ=" + typ + "]";
	}
	
	
	
}