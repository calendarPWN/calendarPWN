package pl.pwn.reaktor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plan")
public class Plan {
	//idplan, idgrupa, dzien_szkol
	//tematy_szkolen_idtematy_szkolen, trener_idtrener, szkolenie_idszkolenie
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idplan")
	private Long idPlan;

	@Column(name = "idgrupa")
	private Long idGrupa;

	@Column(name = "dzien_szkol")
	private Long dzienSzkol;
	
	@Column(name = "tematy_szkolen_idtematy_szkolen")
	private Long tSzkIdTSzk;
	
	@Column(name = "trener_idtrener")
	private Long trIdTr;
	
	@Column(name = "szkolenie_idszkolenie")
	private Long szkIdSzk;

	public Plan() {
		super();
	}

	public Plan(Long idGrupa, Long dzienSzkol, Long tSzkIdTSzk, Long trIdTr, Long szkIdSzk) {
		super();
		this.idGrupa = idGrupa;
		this.dzienSzkol = dzienSzkol;
		this.tSzkIdTSzk = tSzkIdTSzk;
		this.trIdTr = trIdTr;
		this.szkIdSzk = szkIdSzk;
	}

	public Plan(Long idPlan, Long idGrupa, Long dzienSzkol, Long tSzkIdTSzk, Long trIdTr, Long szkIdSzk) {
		super();
		this.idPlan = idPlan;
		this.idGrupa = idGrupa;
		this.dzienSzkol = dzienSzkol;
		this.tSzkIdTSzk = tSzkIdTSzk;
		this.trIdTr = trIdTr;
		this.szkIdSzk = szkIdSzk;
	}

	public Long getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Long idPlan) {
		this.idPlan = idPlan;
	}

	public Long getIdGrupa() {
		return idGrupa;
	}

	public void setIdGrupa(Long idGrupa) {
		this.idGrupa = idGrupa;
	}

	public Long getDzienSzkol() {
		return dzienSzkol;
	}

	public void setDzienSzkol(Long dzienSzkol) {
		this.dzienSzkol = dzienSzkol;
	}

	public Long gettSzkIdTSzk() {
		return tSzkIdTSzk;
	}

	public void settSzkIdTSzk(Long tSzkIdTSzk) {
		this.tSzkIdTSzk = tSzkIdTSzk;
	}

	public Long getTrIdTr() {
		return trIdTr;
	}

	public void setTrIdTr(Long trIdTr) {
		this.trIdTr = trIdTr;
	}

	public Long getSzkIdSzk() {
		return szkIdSzk;
	}

	public void setSzkIdSzk(Long szkIdSzk) {
		this.szkIdSzk = szkIdSzk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dzienSzkol == null) ? 0 : dzienSzkol.hashCode());
		result = prime * result + ((idGrupa == null) ? 0 : idGrupa.hashCode());
		result = prime * result + ((idPlan == null) ? 0 : idPlan.hashCode());
		result = prime * result + ((szkIdSzk == null) ? 0 : szkIdSzk.hashCode());
		result = prime * result + ((tSzkIdTSzk == null) ? 0 : tSzkIdTSzk.hashCode());
		result = prime * result + ((trIdTr == null) ? 0 : trIdTr.hashCode());
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
		Plan other = (Plan) obj;
		if (dzienSzkol == null) {
			if (other.dzienSzkol != null)
				return false;
		} else if (!dzienSzkol.equals(other.dzienSzkol))
			return false;
		if (idGrupa == null) {
			if (other.idGrupa != null)
				return false;
		} else if (!idGrupa.equals(other.idGrupa))
			return false;
		if (idPlan == null) {
			if (other.idPlan != null)
				return false;
		} else if (!idPlan.equals(other.idPlan))
			return false;
		if (szkIdSzk == null) {
			if (other.szkIdSzk != null)
				return false;
		} else if (!szkIdSzk.equals(other.szkIdSzk))
			return false;
		if (tSzkIdTSzk == null) {
			if (other.tSzkIdTSzk != null)
				return false;
		} else if (!tSzkIdTSzk.equals(other.tSzkIdTSzk))
			return false;
		if (trIdTr == null) {
			if (other.trIdTr != null)
				return false;
		} else if (!trIdTr.equals(other.trIdTr))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Plan [idPlan=" + idPlan + ", idGrupa=" + idGrupa + ", dzienSzkol=" + dzienSzkol + ", tSzkIdTSzk="
				+ tSzkIdTSzk + ", trIdTr=" + trIdTr + ", szkIdSzk=" + szkIdSzk + "]";
	}
	
	
}
