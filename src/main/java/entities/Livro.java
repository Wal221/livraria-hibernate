package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import jakarta.persistence.*;


@Entity
@Table
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic(optional=false)
	private String titulo;
	@Basic(optional =false)
	@Temporal(TemporalType.DATE)
	private LocalDate anoPub;

	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="editora.id", nullable=false)
	private Editora editora;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Autor> autores = new ArrayList<>();
	
	
	public Livro() {
		
	}
	
	

	public Livro(Long id, String titulo, LocalDate anoPub,Editora editora, Autor autor) {
		this.id = id;
		this.titulo = titulo;
		this.anoPub = anoPub;
		this.autores.add(autor);
	;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getAnoPub() {
		return anoPub;
	}

	public void setAnoPub(LocalDate anoPub) {
		this.anoPub = anoPub;
	}
	
	


	public Editora getEditora() {
		return editora;
	}



	public void setEditora(Editora editora) {
		this.editora = editora;
	}



	public List<Autor> getAutores() {
		return autores;
	}



	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}



	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", anoPub=" + anoPub + "," +"]";
	}
	
	
	

}
