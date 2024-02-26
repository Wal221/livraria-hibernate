package DTO;

import entities.Editora;



public class EditoraDTO {
	private Long id;
	private String nome;
	
	
	
	
	public EditoraDTO() {
		
	}
	
	public EditoraDTO(Editora editora) {
		this.id = editora.getId();
		this.nome = editora.getNome();
	}

	public EditoraDTO(Long id, String nome) {
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
		return "EditoraDTO{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				'}';
	}
}
