package pl.pwn.reaktor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "view_calendar")
public class Calendar {

	//grupa, dzien_szkolenia, termin, trener, tematyka
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "termin")
	private String termin;
	
	@Column(name = "tematyka")
	private String tematyka;
	
	@Column(name = "trener")
	private String trener;
	
	@Column(name = "grupa")
	private String grupa;
	
	@Column(name = "dzien_szkolenia")
	private String dzien;
	
	public Calendar(String termin, String tematyka, String trener, String grupa, String dzien) {
		super();
		this.termin = termin;
		this.tematyka = tematyka;
		this.trener = trener;
		this.grupa = grupa;
		this.dzien = dzien;
	}

	public Calendar() {
		super();
	}

	public String getTermin() {
		return termin;
	}

	public void setTermin(String termin) {
		this.termin = termin;
	}

	public String getTematyka() {
		return tematyka;
	}

	public void setTematyka(String tematyka) {
		this.tematyka = tematyka;
	}

	public String getTrener() {
		return trener;
	}

	public void setTrener(String trener) {
		this.trener = trener;
	}

	public String getGrupa() {
		return grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}

	public String getDzien() {
		return dzien;
	}

	public void setDzien(String dzien) {
		this.dzien = dzien;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dzien == null) ? 0 : dzien.hashCode());
		result = prime * result + ((grupa == null) ? 0 : grupa.hashCode());
		result = prime * result + ((tematyka == null) ? 0 : tematyka.hashCode());
		result = prime * result + ((termin == null) ? 0 : termin.hashCode());
		result = prime * result + ((trener == null) ? 0 : trener.hashCode());
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
		Calendar other = (Calendar) obj;
		if (dzien == null) {
			if (other.dzien != null)
				return false;
		} else if (!dzien.equals(other.dzien))
			return false;
		if (grupa == null) {
			if (other.grupa != null)
				return false;
		} else if (!grupa.equals(other.grupa))
			return false;
		if (tematyka == null) {
			if (other.tematyka != null)
				return false;
		} else if (!tematyka.equals(other.tematyka))
			return false;
		if (termin == null) {
			if (other.termin != null)
				return false;
		} else if (!termin.equals(other.termin))
			return false;
		if (trener == null) {
			if (other.trener != null)
				return false;
		} else if (!trener.equals(other.trener))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Calendar [termin=" + termin + ", tematyka=" + tematyka + ", trener=" + trener + ", grupa=" + grupa
				+ ", dzien=" + dzien + "]";
	}
	
	
	
}
