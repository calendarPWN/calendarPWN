package pl.pwn.reaktor.model;

public class CalendarFilter {

	private String termin;
	private String tematyka;
	private String trener;
	private String weekend;
	private String grupa;
	
	public CalendarFilter(String termin, String tematyka, String trener, String weekend, String grupa) {
		super();
		this.termin = termin;
		this.tematyka = tematyka;
		this.trener = trener;
		this.weekend = weekend;
		this.grupa = grupa;
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

	public String getWeekend() {
		return weekend;
	}

	public void setWeekend(String weekend) {
		this.weekend = weekend;
	}

	public String getGrupa() {
		return grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}
	
	
}
