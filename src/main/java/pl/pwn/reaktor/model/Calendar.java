package pl.pwn.reaktor.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Calendar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String termin;
	@Column(nullable = false)
	private String tematyka;
	private String trener;
	private String weekend;
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
	public String getWeekend() {
		return weekend;
	}
	public void setWeekend(String weekend) {
		this.weekend = weekend;
	}
	public Calendar(String termin, String tematyka, String trener, String weekend) {
		super();
		this.termin = termin;
		this.tematyka = tematyka;
		this.trener = trener;
		this.weekend = weekend;
	}
	public Calendar() {
		super();
	}
	@Override
	public String toString() {
		return "Plan [termin=" + termin + ", tematyka=" + tematyka + ", trener=" + trener + ", weekend=" + weekend
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tematyka == null) ? 0 : tematyka.hashCode());
		result = prime * result + ((termin == null) ? 0 : termin.hashCode());
		result = prime * result + ((trener == null) ? 0 : trener.hashCode());
		result = prime * result + ((weekend == null) ? 0 : weekend.hashCode());
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
		if (weekend == null) {
			if (other.weekend != null)
				return false;
		} else if (!weekend.equals(other.weekend))
			return false;
		return true;
	}
	
	
}