package my.study.jpastudy.service;

import jakarta.persistence.*;
import my.study.jpastudy.model.entity.Boards;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MytestService {

/*    @PersistenceContext
    EntityManager em;*/

    @PersistenceUnit
    EntityManagerFactory emf;

    public void insertBoard(){

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Boards boards = Boards.builder()
                        .title("test2 title")
                        .content("test2 contents")
                        .build();

        tx.begin();
        em.persist(boards);
        //em.flush();
        tx.commit();
    }

    public void listBoard(){

        EntityManager em = emf.createEntityManager();
        List<Boards> boardsList = em.createQuery("SELECT b FROM Boards b", Boards.class).getResultList();

        boardsList.forEach(boards -> {
            System.out.println("제목 : "+boards.getTitle() + "  내용 : "+boards.getContent());
        });
    }
}
