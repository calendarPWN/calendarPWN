package pl.pwn.reaktor.model;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	@Entity
	public class Plan {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long idPlan;
		private long idGrupa;
		private String dzien_szkol;
		
<<<<<<< HEAD
}
=======
}
>>>>>>> klaudiusz
