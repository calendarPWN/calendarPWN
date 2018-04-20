package pl.pwn.reaktor.model;

public class CalendarFilter {

	private String tematyka;
	private String trener;
	private String dzienSzkolenia;
	private String grupa;
	
	public CalendarFilter(String tematyka, String trener, String dzienSzkolenia, String grupa) {
		super();
		this.tematyka = tematyka;
		this.trener = trener;
		this.dzienSzkolenia = dzienSzkolenia;
		this.grupa = grupa;
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

	public String getDzienSzkolenia() {
		return dzienSzkolenia;
	}

	public void setDzienSzkolenia(String dzienSzkolenia) {
		this.dzienSzkolenia = dzienSzkolenia;
	}

	public String getGrupa() {
		return grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}

	@Override
	public String toString() {
		return "CalendarFilter [tematyka=" + tematyka + ", trener=" + trener + ", dzienSzkolenia=" + dzienSzkolenia
				+ ", grupa=" + grupa + "]";
	}
	
	
	

}

