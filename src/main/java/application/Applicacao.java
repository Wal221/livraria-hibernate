package application;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.AutorDAO;
import DAO.EditoraDAO;
import DTO.AutorDTO;
import DTO.EditoraDTO;
import entities.Autor;
import entities.Editora;
import entities.Livro;

public class Applicacao {

	public static void main(String[] args) {

		//Autor autor = new Autor(3L,"Walmir");
		//AutorDAO save = new AutorDAO();
		//save.add(autor);

//		AutorDTO autor1 = new AutorDTO();
//		autor1 = save.getById(1L);
//		System.out.println(autor1);
      //  save.delete(autor);

		Editora edi =  new Editora(2L,"Artenova");
		EditoraDAO save = new EditoraDAO();

		System.out.println(save.getById(2L));
		//save.add(edi);
	}

}
