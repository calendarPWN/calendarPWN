package pl.pwn.reaktor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grupa")
public class Grupa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idgrupa")
	private long id;
	
	@Column(name = "akronim")
	private String akronim;
	
	@Column(name = "data_start")
	private String dataStart;
	
	@Column(name = "szkolenie_idszkolenie")
	private Long idSzkolenie;

	public Grupa() {
		super();
	}

	public Grupa(String akronim, String dataStart, Long idSzkolenie) {
		super();
		this.akronim = akronim;
		this.dataStart = dataStart;
		this.idSzkolenie = idSzkolenie;
	}

	public Grupa(long id, String akronim, String dataStart, Long idSzkolenie) {
		super();
		this.id = id;
		this.akronim = akronim;
		this.dataStart = dataStart;
		this.idSzkolenie = idSzkolenie;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAkronim() {
		return akronim;
	}

	public void setAkronim(String akronim) {
		this.akronim = akronim;
	}

	public String getDataStart() {
		return dataStart;
	}

	public void setDataStart(String dataStart) {
		this.dataStart = dataStart;
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
		result = prime * result + ((akronim == null) ? 0 : akronim.hashCode());
		result = prime * result + ((dataStart == null) ? 0 : dataStart.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((idSzkolenie == null) ? 0 : idSzkolenie.hashCode());
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
		Grupa other = (Grupa) obj;
		if (akronim == null) {
			if (other.akronim != null)
				return false;
		} else if (!akronim.equals(other.akronim))
			return false;
		if (dataStart == null) {
			if (other.dataStart != null)
				return false;
		} else if (!dataStart.equals(other.dataStart))
			return false;
		if (id != other.id)
			return false;
		if (idSzkolenie == null) {
			if (other.idSzkolenie != null)
				return false;
		} else if (!idSzkolenie.equals(other.idSzkolenie))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grupa [id=" + id + ", akronim=" + akronim + ", dataStart=" + dataStart + ", idSzkolenie=" + idSzkolenie
				+ "]";
	}
	
}
