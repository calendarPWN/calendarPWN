package pl.pwn.reaktor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kolejnosc")
public class Kolejnosc {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idkolejnosc")
	private long id;
	
	@Column(name = "kolejnosc")
	private String kolejnosc;
	
	@Column(name = "szkolenie_idszkolenie")
	private Long idSzkolenie;

	public Kolejnosc() {
		super();
	}

	public Kolejnosc(String kolejnosc, Long idSzkolenie) {
		super();
		this.kolejnosc = kolejnosc;
		this.idSzkolenie = idSzkolenie;
	}

	public Kolejnosc(long id, String kolejnosc, Long idSzkolenie) {
		super();
		this.id = id;
		this.kolejnosc = kolejnosc;
		this.idSzkolenie = idSzkolenie;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKolejnosc() {
		return kolejnosc;
	}

	public void setKolejnosc(String kolejnosc) {
		this.kolejnosc = kolejnosc;
	}

	public Long getIdSzkolenie() {
		return idSzkolenie;
	}

	public void setIdSzkolenie(Long idSzkolenie) {
		this.idSzkolenie = idSzkolenie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((idSzkolenie == null) ? 0 : idSzkolenie.hashCode());
		result = prime * result + ((kolejnosc == null) ? 0 : kolejnosc.hashCode());
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
		Kolejnosc other = (Kolejnosc) obj;
		if (id != other.id)
			return false;
		if (idSzkolenie == null) {
			if (other.idSzkolenie != null)
				return false;
		} else if (!idSzkolenie.equals(other.idSzkolenie))
			return false;
		if (kolejnosc == null) {
			if (other.kolejnosc != null)
				return false;
		} else if (!kolejnosc.equals(other.kolejnosc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Kolejnosc [id=" + id + ", kolejnosc=" + kolejnosc + ", idSzkolenie=" + idSzkolenie + "]";
	}
	
	
}
