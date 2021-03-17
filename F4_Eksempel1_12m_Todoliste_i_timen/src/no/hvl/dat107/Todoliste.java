package no.hvl.dat107;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Todoliste", schema = "forelesning4")
public class Todoliste {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int listeId;
	private String navn;

	@OneToMany(mappedBy = "liste",
			fetch = FetchType.EAGER,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE},
			orphanRemoval = true)
	private List<Todo> todos;
	
	public Todoliste() {}
	
	public Todoliste(String navn) {
		this.navn = navn;
		this.todos = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return "Todoliste [listeId=" + listeId + ", navn=" + navn + ", todos=" + todos + "]";
	}

	public void leggTil(Todo todo) {
		todos.add(todo);
		todo.setListe(this);
	}

	public void fjern(Todo todo) {
		todos.remove(todo);
		todo.setListe(null);
	}

	public int getListeId() {
		return listeId;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

}




