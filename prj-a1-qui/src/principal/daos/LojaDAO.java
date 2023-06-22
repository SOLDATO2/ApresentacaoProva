package principal.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import principal.Modelos.Loja;

public class LojaDAO {
    EntityManagerFactory emf;
    EntityManager em;

    public LojaDAO(){
        emf = Persistence.createEntityManagerFactory("a1_mysql");
        em = emf.createEntityManager();
    }

    public void salvarLoja(Loja loja){
        em.getTransaction().begin();
        em.persist(loja);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
