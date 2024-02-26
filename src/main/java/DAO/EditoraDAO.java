package DAO;

import DTO.AutorDTO;
import DTO.EditoraDTO;
import conexao.ClienteConnectd;
import entities.Autor;
import entities.Editora;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class EditoraDAO {

    ClienteConnectd connectd;

    public void add(Editora editora){
        Session session = connectd.getSessionFactory().openSession();
        if(!session.getTransaction().isActive()) {
            session.getTransaction().begin();
            session.persist(editora);
            session.getTransaction().commit();
            session.close();
        }else{
            System.out.println("A outra transação sendo executada");
        }
    }

    public EditoraDTO  getById(Long id){
        Session session = connectd.getSessionFactory().openSession();
        EditoraDTO edi = new EditoraDTO();
        if(!session.getTransaction().isActive()){
            Editora editora = new Editora();
            session.getTransaction().begin();
            editora = (Editora) session.get(Editora.class,id);
            edi = new EditoraDTO(editora);
            session.getTransaction().commit();
            session.close();
        }

        return edi;
    }

    public List<EditoraDTO> getAll(){
        Session session = connectd.getSessionFactory().openSession();
        Query consulta = session.createQuery("FROM Editora");
         List<Editora> editora = consulta.getResultList();
         List<EditoraDTO> edi =  new ArrayList<>();
        int i = 0;
        for(Editora a: editora){
            edi.add(i,new EditoraDTO(a));
            i++;
        }
        session.close();
        return edi;
    }

    public void update(Editora editora, String name){
        //significa que a editora existe na base de dados então posso atualizali
        Session session = connectd.getSessionFactory().openSession();
        //Editora edi = new Editora(); não e necessario uma varivel para busca na base de dados pois aparentemente o simple
                                       //metodo merge ja busca para você
        if(editora.getId() != null){
            session.getTransaction().begin();
            editora.setNome(name);
            session.merge(editora);
            session.getTransaction().commit();
            session.close();
            System.out.println("Para fins de teste esse metodo foi bem sucedido");
        }


    }

    public void delete(Editora editora){

     if(editora.getId() != null){
         Session session = connectd.getSessionFactory().openSession();
         session.getTransaction().begin();
         session.remove(editora);
         session.getTransaction().commit();
         session.close();
     }
    }
}
