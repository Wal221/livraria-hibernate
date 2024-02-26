package DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.Autor;
import entities.Editora;
import entities.Livro;


public class LivroDTO {
	
	private Long id;
	private String titulo;
	private LocalDate anoPub;
	private Editora editora;
	
	
	
	private List<Autor> autores = new ArrayList<>();
	
	
	public LivroDTO() {
		
	}
	
	
	

	public LivroDTO(Long id, String titulo, LocalDate anoPub, Editora editora, Autor autores) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anoPub = anoPub;
		this.editora = editora;
		this.autores.add(autores);
	}




	public LivroDTO(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.anoPub = livro.getAnoPub();
		this.autores.add((Autor) livro.getAutores());
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
	
	
	

}
