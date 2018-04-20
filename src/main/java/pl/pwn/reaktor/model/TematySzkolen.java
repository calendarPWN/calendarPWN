package pl.pwn.reaktor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tematy_szkolen")
public class TematySzkolen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtematy_szkolen")
	private long id;
	
	@Column(name = "temat")
	private String temat;
	
	public TematySzkolen() {
		super();
	}

	public TematySzkolen(String temat) {
		super();
		this.temat = temat;
	}

	public TematySzkolen(long id, String temat) {
		super();
		this.id = id;
		this.temat = temat;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTemat() {
		return temat;
	}

	public void setTemat(String temat) {
		this.temat = temat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((temat == null) ? 0 : temat.hashCode());
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
		TematySzkolen other = (TematySzkolen) obj;
		if (id != other.id)
			return false;
		if (temat == null) {
			if (other.temat != null)
				return false;
		} else if (!temat.equals(other.temat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TematySzkolen [id=" + id + ", temat=" + temat + "]";
	}
	
}