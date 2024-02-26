package DTO;

import entities.Autor;

import javax.persistence.Basic;



public class AutorDTO {
	
	
	
	private Long id;
	private String nome;
	
	
	public AutorDTO() {
		
	}
	
	
	public AutorDTO(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
	}

	public AutorDTO(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "AutorDTO [id=" + id + ", nome=" + nome + "]";
	}
	
	

}
