package DAO;

import DTO.AutorDTO;
import conexao.ClienteConnectd;
import entities.Autor;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AutorDAO {
    ClienteConnectd connectd;


    public void add(Autor autor){
        Session session = connectd.getSessionFactory().openSession();
        if(!session.getTransaction().isActive()) {
            session.getTransaction().begin();
            session.persist(autor);
            session.getTransaction().commit();
            session.close();
        }else{
            System.out.println("A outra transação sendo executada");
        }
    }

    public AutorDTO getById( Long id){
        AutorDTO autorDTO = new AutorDTO();
        Session session = connectd.getSessionFactory().openSession();
        if(!session.getTransaction().isActive()){
            Autor auto = new Autor();
            session.getTransaction().begin();
            auto = (Autor) session.get(Autor.class,id);
            autorDTO = new AutorDTO(auto);
            session.getTransaction().commit();
            session.close();
        }

        return autorDTO;
    }

    public List<AutorDTO> getAll(){
        Session session = connectd.getSessionFactory().openSession();
        Query consulta = session.createQuery("FROM Autor");
        List<Autor> autores = consulta.getResultList();
        List<AutorDTO> autorDTO = new ArrayList<>();
        int i = 0;
        for(Autor a: autores){
           autorDTO.add(i,new AutorDTO(a));
           i++;
        }
        session.close();
        return autorDTO;
    }

    public void update(Autor autor,String name){
            //significa que o altor existe na base de dados então posso atualizali
        Session session = connectd.getSessionFactory().openSession();
            if(getById(autor.getId()) != null){
               // session.getTransaction().rollback();
                if(!session.getTransaction().isActive()){
                    session.getTransaction().begin();
                    autor.setNome(name);
                    session.merge(autor);
                    session.getTransaction().commit();
                    session.close();
                    System.out.println(autor);
                }

            }else{
            System.out.println("Autor não encontrado");
            }



    }

    public void delete(Autor autor){
        Session session = connectd.getSessionFactory().openSession();
        if(getById(autor.getId()) != null){
            session.beginTransaction();
            session.delete(autor);
            session.getTransaction().commit();
            session.close();
        }

    }
}
